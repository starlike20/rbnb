package MVC.view;

import MVC.controller.*;
import MVC.model.entity.Appartement;

import java.util.ArrayList;

public interface ViewItems{

    void showErroMessage(String message);
    void showMessage(String message);
    void run();
    void setController(Controller c);
}
