package home.stanislavpoliakov.meet19_weather.dagger2;

import dagger.Component;
import home.stanislavpoliakov.meet19_weather.domain.UseCaseInteractor;

/**
 * Компонент Domain-уровня. В нем мы установим NetworkGateway и DatabaseGateway
 */
@ApplicationScope
@Component(modules = InteractorModule.class)
public interface InteractorComponent {

    void inject(UseCaseInteractor useCaseInteractor);
}
