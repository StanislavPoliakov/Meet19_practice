package home.stanislavpoliakov.meet19_weather.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final String TAG = "meet19_logs";
    private static final String BASE_URL = "https://api.darksky.net/forecast/";
    private static final String TOKEN = "2028fd6e9ece283ff30f8a5a8f2597db/";

    public RetrofitWebService getService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(RetrofitWebService.class);
    }
}
