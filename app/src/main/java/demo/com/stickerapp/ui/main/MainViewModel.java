package demo.com.stickerapp.ui.main;


import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.text.TextUtils;

import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.ui.base.BaseViewModel;
import demo.com.stickerapp.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    private final ObservableField<String> appVersion = new ObservableField<>();
    private final ObservableField<String> userEmail = new ObservableField<>();

    private final ObservableField<String> userName = new ObservableField<>();

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }
    public void onNavMenuCreated() {
//        final String currentUserName = getDataManager().getCurrentUserName();
//        if (!TextUtils.isEmpty(currentUserName)) {
//            userName.set(currentUserName);
//        }
//
//        final String currentUserEmail = getDataManager().getCurrentUserEmail();
//        if (!TextUtils.isEmpty(currentUserEmail)) {
//            userEmail.set(currentUserEmail);
//        }
//
//        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
//        if (!TextUtils.isEmpty(profilePicUrl)) {
//            userProfilePicUrl.set(profilePicUrl);
//        }
    }
}
