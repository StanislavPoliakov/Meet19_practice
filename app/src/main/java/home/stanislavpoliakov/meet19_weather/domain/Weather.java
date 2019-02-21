package home.stanislavpoliakov.meet19_weather.domain;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import home.stanislavpoliakov.meet19_weather.domain.response_data.WCurrently;
import home.stanislavpoliakov.meet19_weather.domain.response_data.WDaily;
import home.stanislavpoliakov.meet19_weather.domain.response_data.WFlags;
import home.stanislavpoliakov.meet19_weather.domain.response_data.WHourly;


/**
 * Сущность данных уровня бизнес-логики.
 * Надо сказать, что текущее объявление сущности данных некорректно, потому что через аннотации
 * привязано к конкретной реализации базы данных. Нужно клонировать!
 */
@Entity (tableName = "weather")
public class Weather {
    @PrimaryKey (autoGenerate = true)
    public int id;

    public double latitude;
    public double longitude;
    public String timezone;

    @Embedded (prefix = "currently")
    public WCurrently currently;

    @Embedded (prefix = "hourly")
    public WHourly hourly;

    @Embedded (prefix = "daily")
    public WDaily daily;

    @Embedded (prefix = "flags")
    public WFlags flags;
    public double offset;
}
