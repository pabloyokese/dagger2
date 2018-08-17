package demo.com.stickerapp.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.com.stickerapp.ui.main.MainActivity;
import demo.com.stickerapp.ui.main.MainActivityModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
