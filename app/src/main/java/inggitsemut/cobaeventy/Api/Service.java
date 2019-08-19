package inggitsemut.cobaeventy.Api;

import inggitsemut.cobaeventy.Models.ScreenItemList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    // get intro slider
    @GET("splashscreen")
    Call<ScreenItemList> getIntroSlider();


}