package demo.com.stickerapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import demo.com.stickerapp.R;
import demo.com.stickerapp.BR;
import demo.com.stickerapp.databinding.ActivitySplashBinding;
import demo.com.stickerapp.ui.base.BaseActivity;
import demo.com.stickerapp.ui.main.MainActivity;


public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {
    @Inject
    SplashViewModel mSplashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startSeeding();
    }

    @Override
    public void openLoginActivity() {
//        Intent intent = LoginActivity.newIntent(SplashActivity.this);
//        startActivity(intent);
//        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }
}
