package demo.com.stickerapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.ViewModelProviderFactory;
import demo.com.stickerapp.data.DummyClass;

@Module
public class MainActivityModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

}
