package home.stanislavpoliakov.meet19_weather.dagger2;

import dagger.Module;
import dagger.Provides;
import home.stanislavpoliakov.meet19_weather.domain.DomainContract;
import home.stanislavpoliakov.meet19_weather.domain.UseCaseInteractor;

@Module
public class PresenterModule {

    /**
     * Обещаем предоставить в Presenter элемент Domain-уровня
     * @return
     */
    @ApplicationScope
    @Provides
    public DomainContract.UseCase provideUseCaseInteractor() {
        return new UseCaseInteractor();
    }

}
