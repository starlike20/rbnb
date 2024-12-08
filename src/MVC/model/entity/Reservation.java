package MVC.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static int dernierNumReservation = 0;
    private int numReservation;
    private int nbPersonne;
    private int nbNuits;
    private LocalDate dateDebut;
    private List<Option> tabOption;
    private Client client;
    private Employe employe;
    private Appartement appart;


    // Constructeur

    public Reservation(){

    }
    public Reservation(int nbPersonne, int nbNuits, LocalDate dateDebut, List<Option> tabOption, Client client, Employe employe, Appartement appart) {
        this.numReservation = ++dernierNumReservation;
        this.nbPersonne = nbPersonne;
        this.nbNuits = nbNuits;
        this.dateDebut = dateDebut;
        this.tabOption = tabOption;
        this.client = client;
        this.employe = employe;
        this.appart = appart;
    }

    // Getters et Setters

    public int getNumReservation() {
        return numReservation;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public void setNbNuits(int nbNuits) {
        this.nbNuits = nbNuits;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public List<Option> getTabOption() {
        return tabOption;
    }

    public void setTabOption(List<Option> tabOption) {
        this.tabOption = tabOption;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Appartement getAppart() {
        return appart;
    }

    public void setAppart(Appartement appart) {
        this.appart = appart;
    }
    // Méthode toString pour afficher les informations de la réservation
    @Override
    public String toString() {
        return "Reservation{" +
                "Numero de reservation =" + numReservation +
                ", Nombre de personne =" + nbPersonne +
                ", Nombre de nuit =" + nbNuits +
                ", Date de debut =" + dateDebut +
                ", Options =" + tabOption.toString() +
                ", Client =" + client.toString() +
                ", Employe =" + employe.toString() +
                ", Appartement =" + appart.toString() +
                '}';
    }

    public Reservation clone(){
        Reservation copy = new Reservation();
        copy.numReservation = this.getNumReservation();
        copy.setNbPersonne(this.getNbPersonne());
        copy.setNbNuits(this.getNbNuits());
        copy.setDateDebut(this.getDateDebut());
        copy.setTabOption(this.getTabOption());
        copy.setClient(this.getClient());
        copy.setEmploye(this.getEmploye());
        copy.setAppart(this.getAppart());

        return copy;
    }

    // Méthode main pour tester
    public static void main(String[] args) {
        // Exemple de création d'une liste d'options
        List<Option> options = new ArrayList<Option>();
        // Ajoutez des options ici, exemple : options.add(new Option("NomOption", prix));
        // Note : La classe Option doit être correctement définie dans votre projet
        Client cli = new Client();
        Employe emp = new Employe();
        Appartement appart = new Appartement();

        // Création d'une réservation pour tester
        Reservation reservationTest = new Reservation(1, 3, LocalDate.of(2024, 3, 29), options,cli,emp,appart);

        // Affichage de la réservation
        System.out.println(reservationTest);
    }



}
