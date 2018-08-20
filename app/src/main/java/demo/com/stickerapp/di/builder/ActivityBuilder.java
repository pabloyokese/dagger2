package demo.com.stickerapp.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.com.stickerapp.ui.login.LoginActivity;
import demo.com.stickerapp.ui.login.LoginActivityModule;
import demo.com.stickerapp.ui.main.MainActivity;
import demo.com.stickerapp.ui.main.MainActivityModule;
import demo.com.stickerapp.ui.splash.SplashActivity;
import demo.com.stickerapp.ui.splash.SplashActivityModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

}
