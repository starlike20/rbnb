package MVC.view.console;

import MVC.controller.*;
import MVC.model.entity.*;
import MVC.view.ViewAppart;
import java.awt.event.ActionEvent;
import java.util.*;

public class ViewAppartConsole implements ViewAppart {
    private Controlleur controlleur;
    private Scanner scanner;

    public ViewAppartConsole()
    {
        scanner = new Scanner(System.in);
    }

    @Override
    public Appartement promptForNewAppart() {
        try {
            System.out.println("----- Nouvel Appartement -----");
            System.out.print("Intitulé = ");
            String intitule = promptConsoleForString() ;
            System.out.print("Prix = ");
            float prix = promptConsoleForFloat();
            System.out.print("Quantité de chambres = ");
            int quantite = promptConsoleForInt();
            System.out.print("Adresse = ");
            String adresse = promptConsoleForString();
            System.out.print("Superficie = ");
            float superficie = promptConsoleForFloat();
            return new Appartement(intitule,new ArrayList<Image>(),adresse,superficie,quantite,(double) prix);
        } catch (AppartementException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public Appartement promptForUpdateAppart(Appartement appart) {
        try {
            System.out.println("----- Modification d'un article -----");
            System.out.println("Article à modifier = " + appart);
            System.out.println(" 1) intitulé");
            System.out.println(" 2) prix");
            System.out.println(" 3) quantité");
            System.out.print("Que voulez-vous modifier ? ");
            int choix = promptConsoleForInt();
            Appartement appartement = appart.clone();
            switch (choix) {
                case 1 :
                    System.out.println("Ancien intitulé = " + appart.getNom());
                    System.out.print("Nouvel intitulé = ");
                    String intitule = promptConsoleForString();
                    appartement.setNom(intitule);
                    break;
                case 2 :
                    System.out.println("Ancien prix = " + appart.getPrixLocation());
                    System.out.print("Nouveau prix = ");
                    float prix = promptConsoleForFloat();
                    appartement.setPrixLocation(prix);
                    break;
                case 3 :
                    System.out.println("Ancienne quantité chambres = " +
                            appart.getNbChambres());
                    System.out.print("Nouvelle quantité = ");
                    int quantite = promptConsoleForInt();
                    appartement.setNbChambres(quantite);
                    break;
            }
            return appartement;
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public Integer promptForAppartById() {
        try {
            System.out.println("----- Sélection d'un article -----");
            System.out.print("Id de l'article = ");
            int id = promptConsoleForInt();
            return id;
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;

    }

    @Override
    public void showErroMessage(String message) {
        System.out.println(message);
        System.out.println("Erreur : " + message);

    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayListAppart(ArrayList<Appartement> appart) {
        System.out.println("----- Liste des articles -----");
        for (Appartement a:appart)
            System.out.println(a);

    }

    @Override
    public void run() {
        while (true)
            promptForAction();
    }

    @Override
    public void setController(Controlleur c) {
        controlleur = c;
    }

    public void promptForAction() {
        try {
            System.out.println("----- MENU -----");
            System.out.println(" 1. Ajouter un article");
            System.out.println(" 2. Modifier un article");
            System.out.println(" 3. Supprimer un article");
            System.out.println(" 4. Quitter");
            System.out.print("Que voulez-vous faire ? ");
            int choix = promptConsoleForInt();
            switch (choix) {
                case 1:
                    controlleur.actionPerformed(new ActionEvent(this, 0, ControlleurActions.ADD));
                    break;
                case 2:
                    controlleur.actionPerformed(new ActionEvent(this, 0, ControlleurActions.UPDATE));
                    break;
                case 3:
                    controlleur.actionPerformed(new ActionEvent(this, 0, ControlleurActions.DELETE));
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
    }

    private String promptConsoleForString() {
        return scanner.nextLine();
    }
    private float promptConsoleForFloat() {
        String txt = scanner.nextLine();
        float nb = Float.parseFloat(txt); // !!!
        return nb;
    }

    private int promptConsoleForInt() {
        String txt = scanner.nextLine();
        int nb = Integer.parseInt(txt); // !!!
        return nb;
    }
    private boolean promptConsoleForBoolean() {
        String txt = scanner.nextLine();
        boolean b = Boolean.parseBoolean(txt); // !!!
        return b;
    }

}
