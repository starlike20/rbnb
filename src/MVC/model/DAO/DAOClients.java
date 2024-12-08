package MVC.model.DAO;

import MVC.model.DataAccesLayer;
import MVC.model.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DAOClients implements DataAccesLayer<Client> {
    private ArrayList<Client> clients;
    private int idcourant = 1;

    public DAOClients() throws PersonneException {
        clients = new ArrayList<>();
        clients.add(new Client("appart1","ffgtd", LocalDate.of(1998,2,17),"5005008"));
        clients.add(new Client("cerises","ihhffgcvxd",LocalDate.of(2002,7,31),"04985620"));
    }

    public Client getItemByNP(String n,String p){
        for (Client a : clients) {
            if (a.getNom().equals(n) && a.getPrenom().equals(p)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public int addItem(Client client) {
        if (client instanceof Client) {
            ((Client) client).setNClient(idcourant++);
            clients.add((Client) client);
            return ((Client) client).getNClient();
        }
        return -1;
    }

    @Override
    public boolean updateItem(Client client) {
        if (client instanceof Client) {
            Client updateItem = (Client) client;
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i) != null &&
                        ((Client) clients.get(i)).getNClient() == updateItem.getNClient()) {
                    clients.set(i, updateItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return clients.removeIf(a -> a != null && ((Client) a).getNClient() == id);
    }

    @Override
    public boolean deleteItem(Client client) {
        return clients.remove(client);
    }

    @Override
    public Client getItemById(int id) {
        for (Client a : clients) {
            if (a instanceof Client && ((Client) a).getNClient() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Client> getList() {
        ArrayList<Client> copy = new ArrayList<>();
        for (Client a : clients) {
            if (a instanceof Client) {
                copy.add(((Client)a).clone());
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        return "DAOClients{" +
                "clients=" + clients +
                '}';
    }

    public static void main(String[] args)
    {
        try {
            DataAccesLayer dao = new DAOClients();
            dao.addItem(new Client());
            dao.addItem(new Client("appart1","ffgtd", LocalDate.of(1998,2,17),"5005008"));
            dao.addItem(new Client("cerises","ihhffgcvxd",LocalDate.of(2002,7,31),"04985620"));
            dao.addItem(new Client());
            System.out.println(dao);
            Client a = (Client) dao.getItemById(1);
            System.out.println("Client ayant l'id 1 = " + a);
            a.setNumTel("111111");
            dao.updateItem(a);
            System.out.println(dao);
            dao.deleteItem(3);
            System.out.println(dao);
        } catch (PersonneException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }
}
