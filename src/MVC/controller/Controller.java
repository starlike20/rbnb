package MVC.controller;

import MVC.model.DAO.*;
import MVC.model.*;
import MVC.model.entity.Appartement;
import MVC.model.entity.Employe;
import MVC.view.Gui.*;
import MVC.view.ViewAppart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private DAOEmployes model1;
    private DAOClients model2;
    private DAOAppartements model3;
    private DAO_Options model4;
    private JDialogConnexion view1;
    private  JFrameFenetreFinal view2;
    private  JdialogNouveauClient view3;
    private JDialogNouveauEmploye view4;


    public Controller(DAOEmployes m,DAOClients m1,DAOAppartements m2 ,DAO_Options o,JDialogConnexion v,JFrameFenetreFinal f,JdialogNouveauClient N,JDialogNouveauEmploye E){
        this.model1=m;
        this.model2=m1;
        this.model3=m2;
        this.model4=o;
        this.view1=v;
        this.view1.setController(this);
        this.view2=f;
        this.view2.setController(this);
        this.view3=N;
        this.view3.setController(this);
        this.view4=E;
        this.view4.setController(this);
    }
    public void run(){
        view1.run();
    }
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "connexion":
            {
                if(((DAOEmployes)model1).containt(view1.getitems().getNom(),view1.getitems().getMdp())){
                    view1.showMessage("bienvenu");
                    view1.setConnecte(true);
                    view1.dispose();
                    view2.run();
                    view2.displayListEmploye(model1.getList());
                    view2.displayListClient(model2.getList());
                    view2.displayListoption(model4.getList());
                    view2.displayapart(model3.getList());
                    view2.updateapart(model3.getList());
                }
                else{
                    view1.showErroMessage("mon ou mot de passe erroner");
                }
                break;
            }
            case "comboBoxChanged":
            {
                view2.updateapart(model3.getList());
                break;
            }
            case "Petit dejeuner":
            {
                model4.addItem(model4.getItemsByName("Petit dejeuner"));
                view2.displayListoption(model4.getList());
                break;

            }
            case "Lit Enfant":
            {
                model4.addItem(model4.getItemsByName("Lit Enfant"));
                view2.displayListoption(model4.getList());
                break;
            }
            case "Fumeur":
            {
                model4.addItem(model4.getItemsByName("Fumeur"));
                view2.displayListoption(model4.getList());
                break;
            }
            case  "Annimaux":
            {
                model4.addItem(model4.getItemsByName("Annimaux"));
                view2.displayListoption(model4.getList());
                break;
            }
            case "Ajouter Client":
            {

                view3.pack();
                view3.run();
                view3.dispose();
                break;
            }
            case  "Add Employe":
            {
                view4.pack();
                view4.run();
                view4.dispose();
                break;
            }
            case "appartement":
            {
                break;
            }
            case  "Deconnexion":
            {
                break;
            }
            case "Creer":
            {
                if(model2.getItemByNP(view3.getNom(),view3.getPrenom())==null){
                    model2.addItem(view3.getitems());
                    view3.showMessage("ajout reussi");
                    view2.displayListClient(model2.getList());
                }
                else {
                    view3.showErroMessage("l'utilsateur existe dans le bd");
                }
                break;
            }
            case "creeremp":
            {

            }




        }
        System.out.println(model4.getList());

    }
}
