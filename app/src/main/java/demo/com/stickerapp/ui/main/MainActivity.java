package demo.com.stickerapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import demo.com.stickerapp.BR;
import demo.com.stickerapp.R;
import demo.com.stickerapp.databinding.ActivitySplashBinding;
import demo.com.stickerapp.ui.base.BaseActivity;
import demo.com.stickerapp.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    MainViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}