package home.stanislavpoliakov.meet19_weather;

import android.app.Application;
import android.util.Log;
import home.stanislavpoliakov.meet19_weather.dagger2.ContextModule;
import home.stanislavpoliakov.meet19_weather.dagger2.DaggerInteractorComponent;
import home.stanislavpoliakov.meet19_weather.dagger2.DaggerPresenterComponent;
import home.stanislavpoliakov.meet19_weather.dagger2.InteractorComponent;
import home.stanislavpoliakov.meet19_weather.dagger2.PresenterComponent;

/**
 * Компоненты для dagger уровня приложения (для Presenter и для Model (UseCaseInteractor))
 * иницииализируем здесь.
 *
 * Помним, что Application нужно добавить в Manifest
 */
public class WeatherApplication extends Application {
    private static final String TAG = "meet19_logs";
    private static InteractorComponent interactorComponent;
    private static PresenterComponent presenterComponent;

    public static InteractorComponent getInteractorComponent() {
        //Log.d(TAG, "getInteractorComponent: =" + interactorComponent);
        return interactorComponent;
    }

    public static PresenterComponent getPresenterComponent() {
        //Log.d(TAG, "getPresenterComponent: =" + presenterComponent);
        return presenterComponent;
    }

    public static void setPresenterComponent(PresenterComponent component) {
        WeatherApplication.presenterComponent = component;
    }

    public static void setInteractorComponent(InteractorComponent component) {
        WeatherApplication.interactorComponent = component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        interactorComponent = buildInteractorComponent();
        presenterComponent = buildPresenterComponent();
    }

    public void destroyComponents() {
        interactorComponent = null;
        presenterComponent = null;
    }

    protected InteractorComponent buildInteractorComponent() {
        return DaggerInteractorComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    protected PresenterComponent buildPresenterComponent() {
        return DaggerPresenterComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
}
