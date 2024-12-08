package MVC.view;
import MVC.model.entity.Appartement;
import MVC.controller.Controlleur;

import java.util.ArrayList;

public interface ViewAppart {
    Appartement promptForNewAppart();
    Appartement promptForUpdateAppart(Appartement appart);
    Integer promptForAppartById();
    void showErroMessage(String message);
    void showMessage(String message);
    void displayListAppart(ArrayList<Appartement> appart);
    void run();
    void setController(Controlleur c);
}
