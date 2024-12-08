import MVC.controller.*;
import MVC.model.DAO.DAOAppartements;
import MVC.model.DAO.DAOClients;
import MVC.model.DAO.DAOEmployes;

import MVC.model.DAO.DAO_Options;
import MVC.model.entity.AppartementException;
import MVC.model.entity.PersonneException;
import MVC.view.Gui.JDialogConnexion;

import MVC.view.Gui.JDialogNouveauEmploye;
import MVC.view.Gui.JFrameFenetreFinal;

import MVC.view.Gui.JdialogNouveauClient;
import MVC.view.console.ViewAppartConsole;

public class Main {
    public static void main(String[] args)  {
        //System.out.println("Hello world!");

        try {
            Controller controller = new Controller(new DAOEmployes(),new DAOClients(),new DAOAppartements(),
                new DAO_Options(),new JDialogConnexion(),new JFrameFenetreFinal(),new JdialogNouveauClient(),
                new JDialogNouveauEmploye());
            controller.run();
        } catch (PersonneException e) {
            throw new RuntimeException(e);
        } catch (AppartementException e) {
            throw new RuntimeException(e);
        }

    }
}