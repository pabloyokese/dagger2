package demo.com.stickerapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import demo.com.stickerapp.BR;
import demo.com.stickerapp.BuildConfig;
import demo.com.stickerapp.R;
import demo.com.stickerapp.databinding.ActivitySplashBinding;
import demo.com.stickerapp.databinding.NavHeaderMainBinding;
import demo.com.stickerapp.ui.base.BaseActivity;
import demo.com.stickerapp.databinding.ActivityMainBinding;
import demo.com.stickerapp.ui.login.LoginActivity;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

//    @Inject
//    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Inject
    MainViewModel viewModel;

    private ActivityMainBinding mActivityMainBinding;
    private MainViewModel mMainViewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }
    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        return mMainViewModel;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);
        setUp();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    private void setUp() {
        mDrawer = mActivityMainBinding.drawerView;
        mToolbar = mActivityMainBinding.toolbar;
        mNavigationView = mActivityMainBinding.navigationView;
//        mCardsContainerView = mActivityMainBinding.cardsContainer;

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        mMainViewModel.updateAppVersion(version);
        mMainViewModel.onNavMenuCreated();
//        setupCardContainerView();
//        subscribeToLiveData();
    }
    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, mActivityMainBinding.navigationView, false);
        mActivityMainBinding.navigationView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mMainViewModel);

        mNavigationView.setNavigationItemSelectedListener(
                item -> {
                    mDrawer.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {
                        case R.id.navItemAbout:
//                            showAboutFragment();
                            return true;
                        case R.id.navItemRateUs:
//                            RateUsDialog.newInstance().show(getSupportFragmentManager());
                            return true;
                        case R.id.navItemFeed:
//                            startActivity(FeedActivity.newIntent(MainActivity.this));
                            return true;
                        case R.id.navItemLogout:
                            mMainViewModel.logout();
                            return true;
                        default:
                            return false;
                    }
                });
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private void lockDrawer() {
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    private void unlockDrawer() {
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

}