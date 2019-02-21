package home.stanislavpoliakov.meet19_weather.dagger2;

import dagger.Module;
import dagger.Provides;
import home.stanislavpoliakov.meet19_weather.domain.DomainContract;
import home.stanislavpoliakov.meet19_weather.presentation.ViewContract;
import home.stanislavpoliakov.meet19_weather.presentation.presenter.Presenter;

@Module
public class ViewModule {
    private ViewContract view;

    /**
     * Через конструктор (то есть через Component.builder) предоставляем информацию о View (которая
     * передается в конструктор Presenter'-а)
     * @param view
     */
    public ViewModule(ViewContract view) {
        this.view = view;
    }

    @ApplicationScope
    @Provides
    public DomainContract.Presenter providePresenter() {
        return new Presenter(view);
    }
}
