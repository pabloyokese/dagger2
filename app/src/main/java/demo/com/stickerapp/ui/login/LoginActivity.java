package demo.com.stickerapp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import demo.com.stickerapp.BR;

import javax.inject.Inject;

import demo.com.stickerapp.R;
import demo.com.stickerapp.databinding.ActivityLoginBinding;
import demo.com.stickerapp.ui.base.BaseActivity;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements LoginNavigator {


    @Inject
    LoginViewModel mLoginViewModel;

    private ActivityLoginBinding mActivityLoginBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);

    }
    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }
    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {

    }

    @Override
    public void openMainActivity() {

    }
}
