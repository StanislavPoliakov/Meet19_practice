package home.stanislavpoliakov.meet19_weather.domain.response_data;

import android.arch.persistence.room.TypeConverters;

public class WHourly {
    public String summary;
    public String icon;

    @TypeConverters(WHourlyDataConverter.class)
    public WHourlyData[] data;
}
