package demo.com.stickerapp.ui.main;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.data.DummyClass;

@Module
public class MainActivityModule {

    @Provides
    DummyClass provideMainViewModel() {
        return new DummyClass();
    }

}
