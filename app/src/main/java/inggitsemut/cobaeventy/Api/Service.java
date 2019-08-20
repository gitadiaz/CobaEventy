package inggitsemut.cobaeventy.Api;

import inggitsemut.cobaeventy.Model.JWTToken;
import inggitsemut.cobaeventy.Model.ScreenItemList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    // get intro slider
    @GET("splashscreen")
    Call<ScreenItemList> getIntroSlider();

    // Login
    @FormUrlEncoded
    @POST("auth/login")
    Call<JWTToken> userLogin (
      @Field("username") String username,
      @Field("password") String password
    );

}