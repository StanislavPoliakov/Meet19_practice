package home.stanislavpoliakov.meet19_weather.presentation.presenter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class ConvertTest {
    private ZoneId timeZone;

    @Before
    public void setUp() throws Exception {
        //setCorrectZoneId();
        Convert.setZoneId("Europe/Moscow");
    }

    @After
    public void tearDown() throws Exception {
        timeZone = null;
    }

    private void setTimeZone(String timeZoneString) {
        Convert.setZoneId(timeZoneString);
        try {
            Field timeZoneField = Convert.class.getDeclaredField("timeZone"); // получаем поле по имени
            timeZoneField.setAccessible(true); // Открываем доступ private-поля
            timeZone = (ZoneId) timeZoneField.get(null); // Считываем поле, Object = null, потому что Static поле
            timeZoneField.setAccessible(false); // Закрываем доступ private-поля
            assertEquals("Europe/Moscow", timeZone.toString());
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void setCorrectZoneId() {
        String timeZoneString = "Europe/Moscow";
        setTimeZone(timeZoneString);
    }

    @Test (expected = ZoneRulesException.class)
    public void setInvalidZoneId() {
        String timeZoneString = "Moscow";
        setTimeZone(timeZoneString);
    }

    @Test
    public void toFormattedZoneDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1983,  11, 24);
        long birthday = calendar.getTimeInMillis() / 1000;
        assertEquals("24.12.1983", Convert.toFormattedZoneDate(birthday));
    }

    @Test
    public void toFormattedZoneTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 17);
        assertEquals("23:17", Convert.toFormattedZoneTime(calendar.getTimeInMillis() / 1000));
    }

    @Test
    public void toPercent() {
        double value = 0.134;
        assertEquals("13%", Convert.toPercent(value));
    }

    @Test
    public void toIntensity() {
        double value = 0.1;
        assertEquals("2,54 мм/ч", Convert.toIntensity(value));
    }

    @Test
    public void toCelsius() {
        double value = 0;
        assertEquals("-18˚С", Convert.toCelsius(value));
    }

    @Test
    public void toMercury() {
        double value = 3333;
        assertEquals("2500 мм.рт.ст.", Convert.toMercury(value));
    }

    @Test //0 - 360
    public void toDirection() {
        double value = 180;
        assertEquals("Ю", Convert.toDirection(value));
    }

    @Test
    public void toMeterPerSecond() {
        double value = 1000;
        assertEquals("447,0 м/с", Convert.toMeterPerSecond(value));
    }

    @Test
    public void toPrecipInfo() {
        double v1 = 0.98;
        double v2 = 1.2;
        assertEquals("Вероятность осадков: 98%, интенсивность: 30,48 мм/ч", Convert.toPrecipInfo(v1, v2));
    }

    @Test
    public void toPrecipMax() {
        double value = 0.34;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 18);
        long time = calendar.getTimeInMillis() / 1000;
        assertEquals("Максимальное количестов осадков: 8,64 мм/ч, в 14:18", Convert.toPrecipMax(value, time));
    }

    @Test
    public void toHumidyAndDewPoint() {
        double value1 = 0.12;
        double value2 = 30.8;
        assertEquals("Влажность воздуха: 12%, точка росы при -1˚С", Convert.toHumidyAndDewPoint(value1, value2));
    }

    @Test
    public void toWindInfo() {
        double value1 = 300;
        double value2 = 3.4;
        double value3 = 45;
        assertEquals("Ветер: С-З, 1,5 м/с, порывы до: 20,1 м/с", Convert.toWindInfo(value1, value2, value3));
    }

    @Test
    public void toTempMaxInfo() {
        double value = 100;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 1);
        long time = calendar.getTimeInMillis() / 1000;
        assertEquals("Максимальная температура: +38˚С в 15:01", Convert.toTempMaxInfo(value, time));
    }

    @Test
    public void toTempMinInfo() {
        double value = -50;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 8);
        long time = calendar.getTimeInMillis() / 1000;
        assertEquals("Минимальная температура: -46˚С в 04:08", Convert.toTempMinInfo(value, time));
    }
}