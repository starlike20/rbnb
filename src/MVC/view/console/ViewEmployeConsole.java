package MVC.view.console;

import MVC.controller.Controlleur;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewEmployeConsole //implements viewItem
{
    private Controlleur controlleur;
    private Scanner scanner;

    public ViewEmployeConsole()
    {
        scanner = new Scanner(System.in);
    }
/*
    @Override
    public Object promptForNewItem() {
        /*
        try {
            System.out.println("----- Nouvel Employe -----");
            System.out.print("Nom = ");
            String nom = promptConsoleForString() ;
            System.out.print("Prenom = ");
            String prenom = promptConsoleForString() ;
            System.out.print("Date de Naissance = ");
            //LocalDate ddn = promptConsoleForString() ;
            System.out.print("Fonction = ");
            //String fonction = promptConsoleForString();
            System.out.print("Quantité de chambres = ");
            int quantite = promptConsoleForInt();
            System.out.print("Adresse = ");
            String adresse = promptConsoleForString();
            System.out.print("Superficie = ");
            float superficie = promptConsoleForFloat();
            return new Employe(nom,new ArrayList<Image>(),adresse,superficie,quantite);
        } catch (AppartementException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public Object promptForUpdateItem(Object item) {
        return null;
    }

    @Override
    public Integer promptForItemById() {
        return null;
    }

    @Override
    public void showErroMessage(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void displayListItem(ArrayList<Object> item) {

    }

    @Override
    public void run() {

    }

    @Override
    public void setController(Controlleur c) {

    }
*/

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
