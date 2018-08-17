package demo.com.stickerapp.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import demo.com.stickerapp.MvvmApp;
import demo.com.stickerapp.di.builder.ActivityBuilder;
import demo.com.stickerapp.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(MvvmApp app);
}
