package home.stanislavpoliakov.meet19_weather.presentation.presenter;

import org.mockito.Mockito;
import org.mockito.internal.exceptions.MockitoLimitations;

import home.stanislavpoliakov.meet19_weather.dagger2.PresenterModule;
import home.stanislavpoliakov.meet19_weather.domain.DomainContract;
import home.stanislavpoliakov.meet19_weather.domain.UseCaseInteractor;

public class TestPresenterModule extends PresenterModule {

    @Override
    public DomainContract.UseCase provideUseCaseInteractor() {
        return Mockito.mock(UseCaseInteractor.class);
    }
}
