package demo.com.stickerapp.ui.splash;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {
    @Provides
    SplashViewModel provideSplashViewModel(){
        return new SplashViewModel();
    }
}
