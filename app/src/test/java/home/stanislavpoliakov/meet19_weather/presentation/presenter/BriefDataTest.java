package home.stanislavpoliakov.meet19_weather.presentation.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.util.Calendar;

import static org.junit.Assert.*;

public class BriefDataTest {
    private double temperatureMin;
    private double temperatureMax;
    private long time;
    private BriefData briefData;


    @Before
    public void setUp() throws Exception {
        briefData = new BriefData();
    }

    @After
    public void tearDown() throws Exception {
        briefData = null;
    }

    @Test
    public void setTemperatureMin() {
        temperatureMin = 0; // Берем любое значение
        briefData.setTemperatureMin(temperatureMin); // Устанавливаем это значение в поле данных

        Class briefClass = briefData.getClass();
        try {
            Field temperatureMinField = briefClass.getDeclaredField("temperatureMin");
            temperatureMinField.setAccessible(true);
            double actualTemperatureMin = (double) temperatureMinField.get(briefData);
            temperatureMinField.setAccessible(false);
            assertEquals(temperatureMin, actualTemperatureMin, 0.1); // Правильно отработал Setter?
            assertEquals(temperatureMin, briefData.getTemperatureMin(), 0.1); // А Getter?
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void setTemperatureMax() {
        temperatureMax = 80;
        briefData.setTemperatureMax(temperatureMax);

        Class briefClass = briefData.getClass();
        try {
            Field temperatureMaxField = briefClass.getDeclaredField("temperatureMax");
            temperatureMaxField.setAccessible(true);
            double actualTemperatureMax = (double) temperatureMaxField.get(briefData);
            temperatureMaxField.setAccessible(false);
            assertEquals(temperatureMax, actualTemperatureMax, 0.1);
            assertEquals(temperatureMax, briefData.getTemperatureMax(), 0.1);
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void setTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 15);
        time = calendar.getTimeInMillis() / 1000;
        briefData.setTime(time);

        Class briefClass = briefData.getClass();
        try {
            Field timeField = briefClass.getDeclaredField("time");
            timeField.setAccessible(true);
            long actualTime = (long) timeField.get(briefData);
            timeField.setAccessible(false);
            assertEquals(time, actualTime);
            assertEquals(time, briefData.getTime());
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}