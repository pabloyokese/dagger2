package demo.com.stickerapp.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import dagger.android.AndroidInjection;
import demo.com.stickerapp.utils.NetworkUtils;

public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel> extends AppCompatActivity {

    private T mViewDataBinding;
    private V mViewModel;

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();


    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();


    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }
    public void openActivityOnTokenExpire() {
//        startActivity(LoginActivity.newIntent(this));
        finish();
    }
}
