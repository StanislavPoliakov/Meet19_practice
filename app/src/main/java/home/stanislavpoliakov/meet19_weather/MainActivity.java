package home.stanislavpoliakov.meet19_weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import home.stanislavpoliakov.meet19_weather.presentation.view.ViewActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "meet18_logs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);

        execute(setLocations());
    }

    /**
     * Инициализация используемых локаций (можно сделать через окно настроек и SharedPref)
     * @return
     */
    private ArrayList<String> setLocations() {
        return new ArrayList<>(Arrays.asList("Москва", "Владивосток", "Бангкок",
                "Бали", "Дубай", "Санта-Крус-де-Тенерифе", "Нью-Йорк"));
    }

    /**
     * Поскольку MainActivity - это точка входа в приложение, однако View - это другая активити,
     * то мы просто запускаем View отсюда
     * @param locationList список локаций
     */
    private void execute(ArrayList<String> locationList) {
        Intent intent = ViewActivity.newIntent(this);
        intent.putStringArrayListExtra("cities", locationList);
        startActivity(intent);
    }
}
