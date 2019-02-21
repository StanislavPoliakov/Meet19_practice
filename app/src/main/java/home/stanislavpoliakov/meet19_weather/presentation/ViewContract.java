package home.stanislavpoliakov.meet19_weather.presentation;

import android.os.Bundle;

import java.util.List;

import home.stanislavpoliakov.meet19_weather.presentation.presenter.BriefData;

public interface ViewContract {

    void setLabel(String label);

    void setUserChoice(List<String> cities);

    void displayBrief(List<BriefData> briefData);

    void showDetails(Bundle detailInfo);

    void initUIViews();
}

