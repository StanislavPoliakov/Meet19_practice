package home.stanislavpoliakov.meet19_weather.presentation.presenter;

import android.support.test.rule.ActivityTestRule;

import org.checkerframework.checker.units.qual.A;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import home.stanislavpoliakov.meet19_weather.MainActivity;
import home.stanislavpoliakov.meet19_weather.dagger2.ApplicationScope;
import home.stanislavpoliakov.meet19_weather.dagger2.PresenterComponent;
import home.stanislavpoliakov.meet19_weather.domain.DomainContract;
import home.stanislavpoliakov.meet19_weather.domain.UseCaseInteractor;
import home.stanislavpoliakov.meet19_weather.presentation.ViewContract;
import home.stanislavpoliakov.meet19_weather.presentation.view.ViewActivity;

import static org.junit.Assert.*;

public class PresenterTest {



    @Test
    public void show() {
        //MainActivity mainActivity = mainActivityActivityTestRule.getActivity();
        ViewContract mActivity = Mockito.mock(ViewActivity.class);
        //ViewActivity viewActivity = viewActivityActivityTestRule.getActivity();

    }
}