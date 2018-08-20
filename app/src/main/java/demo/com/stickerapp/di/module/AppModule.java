package demo.com.stickerapp.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.com.stickerapp.BuildConfig;
import demo.com.stickerapp.R;
import demo.com.stickerapp.data.AppDataManager;
import demo.com.stickerapp.data.DataManager;
import demo.com.stickerapp.data.local.prefs.AppPreferencesHelper;
import demo.com.stickerapp.data.local.prefs.PreferencesHelper;
import demo.com.stickerapp.data.remote.ApiHeader;
import demo.com.stickerapp.data.remote.ApiHelper;
import demo.com.stickerapp.data.remote.AppApiHelper;
import demo.com.stickerapp.di.ApiInfo;
import demo.com.stickerapp.di.DatabaseInfo;
import demo.com.stickerapp.di.PreferenceInfo;
import demo.com.stickerapp.utils.AppConstants;
import demo.com.stickerapp.utils.rx.AppSchedulerProvider;
import demo.com.stickerapp.utils.rx.SchedulerProvider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
