package demo.com.stickerapp.ui.splash;

import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.ui.base.BaseViewModel;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator>{

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startSeeding() {
        decideNextActivity();
    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openMainActivity();
        }
    }
}
