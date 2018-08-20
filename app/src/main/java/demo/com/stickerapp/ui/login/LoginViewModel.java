package demo.com.stickerapp.ui.login;

import demo.com.stickerapp.ui.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public void onServerLoginClick() {
        getNavigator().login();
    }
}
