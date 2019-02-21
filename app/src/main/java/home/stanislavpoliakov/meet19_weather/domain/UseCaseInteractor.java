package home.stanislavpoliakov.meet19_weather.domain;

import android.support.annotation.WorkerThread;

import javax.inject.Inject;
import home.stanislavpoliakov.meet19_weather.WeatherApplication;
import io.reactivex.Observable;

public class UseCaseInteractor implements DomainContract.UseCase {
    private static final String TAG = "meet19_logs";
    @Inject DomainContract.NetworkOperations networkGateway;
    @Inject DomainContract.DatabaseOperations databaseGateway;

    /**
     * В конструкторе просим dagger инъектировать зависимости из компонента (который создается на
     * уровне приложения)
     */
    public UseCaseInteractor() {
        WeatherApplication.getInteractorComponent().inject(this);
    }

    /** RxJava
     * Callback из Presenter.
     *
     * @param cityLocation координаты города в формате String
     */
    @WorkerThread
    @Override
    public Observable<Weather> getData(String cityLocation) {
        return networkGateway.fetchData(cityLocation)
                .doOnNext(databaseGateway::saveData)
                .map(w -> databaseGateway.loadData());
    }
}
