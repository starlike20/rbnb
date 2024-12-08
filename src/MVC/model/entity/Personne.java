package MVC.model.entity;

import java.time.LocalDate;

public class Personne implements EstIdentifiable {
    private String Nom;
    private String Prenom;
    private LocalDate dateNaissance;

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
    public LocalDate getDateNaissance(){
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Personne() {
        this.Nom = "inconnu";
        this.Prenom = "inconnu";
        this.dateNaissance = LocalDate.of(2000, 1, 1);
    }

    public Personne(String nom, String prenom,LocalDate ddn) throws PersonneException {
        if (nom.length() < 3) throw new PersonneException("Le nom doit contenir au moins 3 caractères!");
        if (prenom.length() < 3) throw new PersonneException("Le prenom doit contenir au moins 3 caractères!");
        if (ddn.isAfter(LocalDate.now())) throw new PersonneException("la date de naissance ne peut etre apres la date du jour!");
        if (ddn.isAfter(LocalDate.of(2006,12,31))) throw new PersonneException("Il faut avoir au moins 18 ans a l'année en cours!");
        this.Nom = nom;
        this.Prenom = prenom;
        this.dateNaissance = ddn;
    }

    public Personne(String nom, String prenom) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.dateNaissance = LocalDate.of(2000, 1, 1);
    }

    @Override
    public int getNumero() {
        return 0;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "Nom = '" + Nom + '\'' +
                ", Prenom = '" + Prenom + '\'' +
                ", dateNaissance = " + dateNaissance +
                '}';
    }

    public static void main(String[] args) {
        Personne personne = new Personne();
        Personne p1 = new Personne("l","p");
        System.out.println("p1 = " + personne);
        System.out.println("p1 = " + p1);
    }
}
