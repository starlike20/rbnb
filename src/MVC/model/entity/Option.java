package MVC.model.entity;

import MVC.model.DAO.DAO_Options;
import MVC.model.DataAccesLayer;

import java.util.Objects;

public class Option implements EstIdentifiable {
    private int code;
    private String type;
    private float prix;

    // Constructeur par défaut
    public Option() {
        this.code = 0;
        this.type = "option0";
        this.prix = 0.0f;
    }

    // Constructeur avec paramètres
    public Option(int code, String type, float prix) {
        this.code = code;
        this.type = type;
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public int getNumero() {
        return code;
    }

    @Override
    public String toString() {
        return "Option{" +
                "Code = '" + getCode() + '\'' +
                "Type = '" + getType() + '\'' +
                ", Prix = " + getPrix() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Float.compare(option.prix, prix) == 0 && Objects.equals(type, option.type);
    }
    public Option clone(){
        Option copy = new Option();
        copy.setCode(this.getCode());
        copy.setType(this.getType());
        copy.setPrix(this.getPrix());

        return copy;
    }
    public static void main(String[] args) {
        DataAccesLayer dao = new DAO_Options();
        dao.addItem(new Option(0, "option0", 0.0f));
        dao.addItem(new Option(8965, "chien", 153.3f));
        dao.addItem(new Option(1234, "lit enfant", 88.65f));
        dao.addItem(new Option(2, "option2", 0.0f));
        System.out.println(dao);
        Option a = (Option) dao.getItemById(1234);
        System.out.println("Option ayant l'id 1234 = " + a);
        if (a != null) {
            a.setPrix(62.65f);
            dao.updateItem(a);
        }
        System.out.println(dao);
        dao.deleteItem(8965);
        System.out.println(dao);
    }

}
