package demo.com.stickerapp.ui.splash;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

@Module
public class SplashActivityModule {
    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new SplashViewModel(dataManager, schedulerProvider);
    }
}
