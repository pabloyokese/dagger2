package demo.com.stickerapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import demo.com.stickerapp.R;
import demo.com.stickerapp.ui.base.BaseActivity;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    MainViewModel viewModel;

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public MainViewModel getViewModel() {
        return null;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}