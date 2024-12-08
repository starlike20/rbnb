package MVC.model.entity;

import javax.swing.*;
import java.util.ArrayList;

public class Appartement {
    private int id;
    private static int idAppart = 0;
    private String Nom;
    private ArrayList<Image> images;
    private String adresse;
    private double superficie;
    private int nbChambres;
    private double prixLocation;

    public Appartement() {
        id = ++idAppart;
    }

   public Appartement(String nom, ArrayList<Image> images, String adresse, double superficie, int nbChambres, double prixLocation) throws AppartementException
   {
        this.id = ++idAppart;
        if (nom.length() <5) throw new AppartementException("Le nom ne peut être inférieur à 5 caractères!");
        if (adresse.length() <5) throw new AppartementException("L'adresse ne peut être inférieure à 8 caractères!");
        if (prixLocation < 200 ) throw new AppartementException("Le prix ne peut être inférieur à 200 EURO!");
        if (nbChambres < 0 || nbChambres >10 ) throw new AppartementException("Le nombre de chambre ne peut être compris que entre 1 et 10!");
        if (superficie < 100) throw new AppartementException("La superficie ne peut être inférieur à 100m²!");

        this.Nom = nom;
        this.images = images;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbChambres = nbChambres;
        this.prixLocation = prixLocation;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getNbChambres() {
        return nbChambres;
    }

    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    @Override
    public String toString() {
        return "Appartement{" +
                "id=" + id +
                ", nom=" + Nom +
                ", images=" + (images != null ? images.toString() : 0) + " image(s)" +
                ", adresse='" + adresse + '\'' +
                ", superficie=" + superficie +
                ", nbChambres=" + nbChambres +
                ", prixLocation=" + prixLocation +
                '}';
    }

    @Override
    public Appartement clone(){
        Appartement copy = new Appartement();
        copy.id = this.id;
        copy.Nom = this.Nom;
        copy.adresse = this.adresse;
        copy.images = this.images;
        copy.nbChambres = this.nbChambres;
        copy.prixLocation = this.prixLocation;
        copy.superficie = this.superficie;

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appartement that = (Appartement) o;
        return id == that.id;
    }

    public static void main(String[] args) {
        // Création d'un tableau d'images pour l'exemple (les images doivent exister)
        ArrayList<Image> imagesPourApp1 = new ArrayList<Image>();
        imagesPourApp1.add(new Image("chemin/vers/image1.jpg","bateau"));
        imagesPourApp1.add(new Image("chemin/vers/image2.jpg","cabane"));


        Appartement app1 = null;
        try {
            app1 = new Appartement("Duplex", imagesPourApp1, "123 Rue de Paris", 100, 2, 1200.0);
        } catch (AppartementException e) {
            throw new RuntimeException(e);
        }

        System.out.println(app1);
    }

}
