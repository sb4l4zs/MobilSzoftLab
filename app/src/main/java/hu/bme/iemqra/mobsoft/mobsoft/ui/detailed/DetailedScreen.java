package hu.bme.iemqra.mobsoft.mobsoft.ui.detailed;

public interface DetailedScreen {
    void showDetails();

    void showError(String text);

    void addedOk(String text);

    void removedOk(String text);

    void modifiedOk(String text);
}
