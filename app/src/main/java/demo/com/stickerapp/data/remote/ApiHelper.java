package demo.com.stickerapp.data.remote;

import demo.com.stickerapp.data.model.api.BlogResponse;
import demo.com.stickerapp.data.model.api.LoginRequest;
import demo.com.stickerapp.data.model.api.LoginResponse;
import demo.com.stickerapp.data.model.api.LogoutResponse;
import demo.com.stickerapp.data.model.api.OpenSourceResponse;
import io.reactivex.Single;

public interface ApiHelper {
    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
