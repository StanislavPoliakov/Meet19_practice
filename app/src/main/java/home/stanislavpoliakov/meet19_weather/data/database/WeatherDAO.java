package home.stanislavpoliakov.meet19_weather.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import home.stanislavpoliakov.meet19_weather.domain.Weather;

@Dao
public interface WeatherDAO {

    @Query("SELECT * FROM weather")
    Weather getWeather();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Weather weather);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(Weather weather);

}
