package demo.com.stickerapp.ui.login;

import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.ui.base.BaseViewModel;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void onServerLoginClick() {
        getNavigator().login();
    }
}
