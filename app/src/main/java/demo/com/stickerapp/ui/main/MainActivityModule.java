package demo.com.stickerapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.ViewModelProviderFactory;
import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

@Module
public class MainActivityModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }

}
