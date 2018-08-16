package demo.com.stickerapp.data.model;

import javax.inject.Singleton;

import dagger.Component;
import demo.com.stickerapp.MainActivity;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
