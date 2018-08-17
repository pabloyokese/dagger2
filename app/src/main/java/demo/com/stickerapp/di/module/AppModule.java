package demo.com.stickerapp.di.module;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.data.DummyClass;

@Module
public class AppModule {

    @Provides
    DummyClass provideLogic() {
        return new DummyClass();
    }

}
