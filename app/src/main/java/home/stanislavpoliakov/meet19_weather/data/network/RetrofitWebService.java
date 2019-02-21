package home.stanislavpoliakov.meet19_weather.data.network;

import home.stanislavpoliakov.meet19_weather.domain.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitWebService {

    //Токен здесь. Пусть его retrofit подтянет через аннтоцию
    @GET("2028fd6e9ece283ff30f8a5a8f2597db/{locationPoint}")
    Call<Weather> getWeather(@Path("locationPoint") String locationPoint);
}
