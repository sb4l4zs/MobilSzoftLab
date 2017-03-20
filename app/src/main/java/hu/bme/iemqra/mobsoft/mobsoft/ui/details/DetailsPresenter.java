package hu.bme.iemqra.mobsoft.mobsoft.ui.details;

import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {
    public DetailsPresenter() {
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    void getDetailsByID(int id){}

    void modifyDetailsByID(int id, String title, String date, String place, String pageUrl, boolean global){}

    void deleteDetailsByID(int id){}
}
