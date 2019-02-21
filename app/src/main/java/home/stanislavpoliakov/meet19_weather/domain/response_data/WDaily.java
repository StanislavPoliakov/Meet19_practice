package home.stanislavpoliakov.meet19_weather.domain.response_data;

import android.arch.persistence.room.TypeConverters;

/**
 * Один из объектов структуры данных
 */
public class WDaily {
    public String summary;
    public String icon;

    // Конвертируем массив в JSON-строку, чтобы сохранить в SQLite
    @TypeConverters(WDailyDataConverter.class)
    public WDailyData[] data;
}
