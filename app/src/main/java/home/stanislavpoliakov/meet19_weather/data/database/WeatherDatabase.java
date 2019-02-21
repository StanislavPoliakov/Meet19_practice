package home.stanislavpoliakov.meet19_weather.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import home.stanislavpoliakov.meet19_weather.domain.Weather;

@Database(entities = Weather.class, version = 3)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDAO getWeatherDAO();
}
