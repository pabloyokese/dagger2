package demo.com.stickerapp.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import java.lang.ref.WeakReference;

import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {
    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    public BaseViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    private WeakReference<N> mNavigator;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public DataManager getDataManager() {
        return mDataManager;
    }
    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
