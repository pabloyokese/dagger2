package demo.com.stickerapp.ui.login;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

@Module
public class LoginActivityModule {
    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager,schedulerProvider);
    }
}
