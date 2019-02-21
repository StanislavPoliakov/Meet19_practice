package home.stanislavpoliakov.meet19_weather.presentation.presenter;

import android.location.Address;
import android.location.Geocoder;
import android.test.mock.MockContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import home.stanislavpoliakov.meet19_weather.WeatherApplication;
import home.stanislavpoliakov.meet19_weather.dagger2.ContextModule;
import home.stanislavpoliakov.meet19_weather.dagger2.DaggerPresenterComponent;
import home.stanislavpoliakov.meet19_weather.dagger2.PresenterComponent;
import home.stanislavpoliakov.meet19_weather.data.database.DatabaseGateway;
import home.stanislavpoliakov.meet19_weather.presentation.ViewContract;
import home.stanislavpoliakov.meet19_weather.presentation.view.ViewActivity;

public class PresenterTest2 {
    private MockContext context;
    private ViewContract mView;
    private PresenterComponent originalComponent;
    private Presenter mPresenter;
    private Geocoder geocoder;

    @Before
    public void setUp() throws Exception {
        context = new MockContext();

        mView = Mockito.mock(ViewActivity.class);

        PresenterComponent testPresenterComponent = DaggerPresenterComponent.builder()
                .contextModule(new ContextModule(context))
                .presenterModule(new TestPresenterModule())
                .build();
        originalComponent = WeatherApplication.getPresenterComponent();
        WeatherApplication.setPresenterComponent(testPresenterComponent);
        mPresenter = new Presenter(mView);


    }

    @After
    public void tearDown() throws Exception {
        WeatherApplication.setPresenterComponent(originalComponent);
    }

    @Test
    public void show() {
        mPresenter.onSpinnerSelected("Moscow");
        geocoder = Mockito.mock(Geocoder.class);
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(Locale.getDefault()));
        try {
            Mockito.when(geocoder.getFromLocationName("Moscow", 1))
                    .thenReturn(addressList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}