package demo.com.stickerapp;

import android.app.Application;

import demo.com.stickerapp.data.model.DaggerMyComponent;
import demo.com.stickerapp.data.model.MyComponent;
import demo.com.stickerapp.data.model.MyModule;

public class MyApplication extends Application {
    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = createMyComponent();
    }

    MyComponent getMyComponent() {
        return mMyComponent;
    }

    private MyComponent createMyComponent() {
        return DaggerMyComponent
                .builder()
                .myModule(new MyModule())
                .build();
    }
}
