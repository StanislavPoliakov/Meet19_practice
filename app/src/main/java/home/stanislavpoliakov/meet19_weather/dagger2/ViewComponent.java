package home.stanislavpoliakov.meet19_weather.dagger2;

import dagger.Component;
import home.stanislavpoliakov.meet19_weather.presentation.view.ViewActivity;

/**
 * Компонент View-уровня
 */
@ApplicationScope
@Component(modules = {ViewModule.class})
public interface ViewComponent {

    void inject(ViewActivity activity);
}
