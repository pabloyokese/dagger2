package demo.com.stickerapp.ui.splash;

import demo.com.stickerapp.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator>{

    public void startSeeding() {
        decideNextActivity();
    }

    private void decideNextActivity() {
        getNavigator().openMainActivity();
    }
}
