package MVC.model.DAO;

import MVC.model.DataAccesLayer;
import MVC.model.entity.Option;

import java.util.ArrayList;

public class DAO_Options implements DataAccesLayer<Option>{
    private ArrayList<Option> options;
    public Option dej =new Option(8965,"Petit dejeuner", 60);
    public Option lie=new Option(1234,"Lit Enfant", 88);
    public Option fu=new Option(1234,"Fumeur", 105);
    public Option anni=new Option(1234,"Annimaux", 50);

    public DAO_Options() {
        options = new ArrayList<Option>();
        //options.add(new Option());

    }

    @Override
    public int addItem(Option option) {
        if(option!=null) {
            if(options.contains(option)){
                deleteItem(option);
                return 0;
            }
            options.add(option);
            return option.getCode();
        }
        return 0;
    }

    @Override
    public boolean updateItem(Option option) {
        if (option instanceof Option) {
            Option updateItem = (Option) option;
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i) != null &&
                        ((Option) options.get(i)).getCode() == updateItem.getCode()) {
                    options.set(i, updateItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return options.removeIf(a -> a != null && ((Option) a).getCode() == id);
    }

    @Override
    public boolean deleteItem(Option option) {
        return options.remove(option);
    }

    @Override
    public Option getItemById(int id) {
        for (Option option : options) {
            if (option.getCode() == id) {
                return option;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Option> getList() {
        return new ArrayList<>(options);
    }

    @Override
    public String toString() {
        return "DAO_Options{" +
                "options=" + options.toString() +
                '}';
    }

    public Option getItemsByName(String name) {
        if (dej.getType().equals(name)) {
            return dej;
        }
        else {
            if(lie.getType().equals(name)){
                return lie;
            }
            else{
                if(fu.getType().equals(name)){
                    return fu;
                }
                else {
                    return anni;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        DataAccesLayer dao = new DAO_Options();
        dao.addItem(new Option());
        dao.addItem(new Option(8965,"chien", 153.3f));
        dao.addItem(new Option(1234,"lit enfant", 88.65f));
        dao.addItem(new Option());
        System.out.println(dao);
        Option a = (Option) dao.getItemById(1);
        System.out.println("Option ayant l'id 1 = " + a);
        a.setPrix(62.65f);
        dao.updateItem(a);
        System.out.println(dao);
        dao.deleteItem(3);
        System.out.println(dao);


    }

}
