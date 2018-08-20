package demo.com.stickerapp.ui.main;


import android.databinding.ObservableField;

import demo.com.stickerapp.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private final ObservableField<String> appVersion = new ObservableField<>();
    public ObservableField<String> getAppVersion() {
        return appVersion;
    }



}
