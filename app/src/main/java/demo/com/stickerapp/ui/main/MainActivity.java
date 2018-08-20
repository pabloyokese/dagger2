package demo.com.stickerapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import demo.com.stickerapp.BR;
import demo.com.stickerapp.R;
import demo.com.stickerapp.databinding.ActivitySplashBinding;
import demo.com.stickerapp.ui.base.BaseActivity;
import demo.com.stickerapp.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    MainViewModel viewModel;

    private ActivityMainBinding mActivityMainBinding;
    private MainViewModel mMainViewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;

//    @Inject
//    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }
    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        return mMainViewModel;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);
//        AndroidInjection.inject(this);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return fragmentDispatchingAndroidInjector;
        return null;
    }
}