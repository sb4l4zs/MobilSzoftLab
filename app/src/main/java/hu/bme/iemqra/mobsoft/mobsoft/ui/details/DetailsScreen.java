package hu.bme.iemqra.mobsoft.mobsoft.ui.details;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public interface DetailsScreen {
    void getDetailsByID(int id);

    void modifyDetailsByID(int id, String title, String date, String place, String pageUrl, boolean global);

    void deleteDetailsByID(int id);
}
