package MVC.model.DAO;

import MVC.model.DataAccesLayer;
import MVC.model.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DAOReservation implements DataAccesLayer{
    private ArrayList<Reservation> reservations;
    private int idcourant = 1;

    public DAOReservation() {
        reservations = new ArrayList<>();
    }

    @Override
    public int addItem(Object reservation) {
        if (reservation instanceof Reservation)
        {
            //((Reservation) reservation).set(idcourant++);
            reservations.add((Reservation) reservation);
            return ((Reservation) reservation).getNumReservation();
        }
        return -1;
    }

    @Override
    public boolean updateItem(Object reservation) {
        if (reservation instanceof Reservation updateItem) {
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i) != null && ((Reservation) reservations.get(i)).getNumReservation() == updateItem.getNumReservation())
                {
                    reservations.set(i, updateItem);
                    return true;
                }
            }
        }
        return false;
    }
    /*
    public boolean updateItem(Object reservation) {
        if (reservation instanceof Reservation) {
            Reservation updateItem = (Reservation) reservation;
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i) != null && ((Reservation) reservations.get(i)).getNumReservation() == updateItem.getNumReservation())
                {
                    reservations.set(i, updateItem);
                    return true;
                }
            }
        }
        return false;
    }*/
    @Override
    public boolean deleteItem(int id) {
        return reservations.removeIf(a -> a != null && ((Reservation) a).getNumReservation() == id);
    }

    @Override
    public boolean deleteItem(Object reservation) {
        return reservations.remove(reservation);
    }

    @Override
    public Object getItemById(int id) {
        for (Object a : reservations) {
            if (a instanceof Reservation && ((Reservation) a).getNumReservation() == id)
            {
                return a;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Object> getList() {
        ArrayList<Object> copy = new ArrayList<>();
        for (Object a : reservations) {
            if (a instanceof Reservation) {
                copy.add(((Reservation)a).clone());
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        return "DAOReservation{" +
                "reservation=" + reservations +
                '}';
    }

    public static void main(String[] args)
    {
        DataAccesLayer dao = new DAOReservation();

        try {
            try {
                dao.addItem(new Reservation());
                ArrayList<Image> img = new ArrayList<Image>();
                dao.addItem(new Reservation (2,5, LocalDate.of(2024,6,17),new ArrayList<Option>(),new Client("appart1","ffgtd", LocalDate.of(1998,2,17),"5005008"),new Employe("pierre","ffgtd", LocalDate.of(1998,2,17),508,"fonction1","mdp"),new Appartement("111111jhhy",img,"8888888888",1000.0,2,600)));

                dao.addItem(new Reservation());

                dao.addItem(new Reservation (2,5, LocalDate.of(2024,6,17),new ArrayList<Option>(),new Client("appart2","gafhjuk", LocalDate.of(1998,2,17),"5005008"),new Employe("pierre","ffgtd", LocalDate.of(1998,2,17),508,"fonction1","mdp"),new Appartement("111111jhhy",img,"8888888888",1000.0,2,600)));
                System.out.println(dao);
                Reservation a = (Reservation) dao.getItemById(1);
                System.out.println("la reservation ayant l'id 1 = " + a);
                a.setNbNuits(3);
                dao.updateItem(a);
                System.out.println(dao);
                dao.deleteItem(0);
                System.out.println(dao);
            } catch (PersonneException e) {
                throw new RuntimeException(e);
            }
        } catch (AppartementException e) {
            throw new RuntimeException(e);
        }

    }
}
