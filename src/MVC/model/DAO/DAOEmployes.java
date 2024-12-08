package MVC.model.DAO;

import MVC.model.DataAccesLayer;
import MVC.model.entity.Client;
import MVC.model.entity.Employe;
import MVC.model.entity.PersonneException;

import java.time.LocalDate;
import java.util.ArrayList;

public class DAOEmployes implements DataAccesLayer<Employe> {
    private ArrayList<Employe> employes;
    private int idcourant = 1;

    public DAOEmployes() throws PersonneException {
        employes = new ArrayList<>();
        employes.add(new Employe("Doe", "John", LocalDate.of(1980, 4, 15), 12345, "EMPLOYE", "password123"));
    }

    @Override
    public int addItem(Employe employe) {
        if (employe instanceof Employe) {
            ((Employe) employe).setMatricule(idcourant++);
            employes.add((Employe) employe);
            return ((Employe) employe).getMatricule();
        }
        return -1;
    }

    @Override
    public boolean updateItem(Employe employe) {
        if (employe instanceof Employe) {
            Employe updateItem = (Employe) employe;
            for (int i = 0; i < employes.size(); i++) {
                if (employes.get(i) != null && ((Employe) employes.get(i)).getMatricule() == updateItem.getMatricule())
                {
                    employes.set(i, updateItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return employes.removeIf(a -> a != null && ((Employe) a).getMatricule() == id);
    }

    @Override
    public boolean deleteItem(Employe employe) {
        return employes.remove(employe);
    }

    @Override
    public Employe getItemById(int id) {
        for (Employe a : employes) {
            if (a instanceof Employe && ((Employe) a).getMatricule() == id)
            {
                return a;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employe> getList() {
        ArrayList<Employe> copy = new ArrayList<>();
        for (Object a : employes) {
            if (a instanceof Employe) {
                copy.add(((Employe)a).clone());
            }
        }
        return copy;
    }

    public  boolean containt(String a,String b){
        for (int i = 0; i < employes.size(); i++) {
            if(employes.get(i).getNom().equals(a) && employes.get(i).getMdp().equals(b)){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "DAOEmploye{" +
                "employe=" + employes +
                '}';
    }

    public static void main(String[] args)
    {

        try {
            DataAccesLayer dao = new DAOEmployes();
            dao.addItem(new Employe());
            dao.addItem(new Employe("pierre","ffgtd", LocalDate.of(1998,2,17),508,"fonction1","mdp"));
            dao.addItem(new Employe("cerises","ihhffgcvxd",LocalDate.of(2002,7,31),040,"f2","xxx"));
            dao.addItem(new Employe());
            System.out.println(dao);
            Employe a = (Employe) dao.getItemById(1);
            System.out.println("Employe ayant l'id 1 = " + a);
            a.setFonction("manager");
            dao.updateItem(a);
            System.out.println(dao);
            dao.deleteItem(3);
            System.out.println(dao);
        } catch (PersonneException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }
}
