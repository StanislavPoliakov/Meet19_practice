package home.stanislavpoliakov.meet19_weather.dagger2;

import dagger.Component;
import home.stanislavpoliakov.meet19_weather.presentation.presenter.Presenter;

/**
 * Компонент зависимостей Presenter-уровня
 */
@ApplicationScope
@Component(modules = {PresenterModule.class, ContextModule.class})
public interface PresenterComponent {

    void inject(Presenter presenter);
}
