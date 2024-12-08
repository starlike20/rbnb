package MVC.model;

import java.util.ArrayList;
import java.lang.Object;
public interface DataAccesLayer<T> {
    int addItem(T appart);
    boolean updateItem(T appart);
    boolean deleteItem(int id);
    boolean deleteItem(T appart);
    T getItemById(int id);
    ArrayList<T> getList();

}
