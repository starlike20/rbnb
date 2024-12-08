package MVC.controller;
import MVC.model.DataAccesLayer;
import MVC.model.entity.Appartement;
import MVC.view.ViewAppart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public final class Controlleur implements ActionListener {
    private DataAccesLayer model;
    private ViewAppart view;
    public Controlleur(DataAccesLayer model, ViewAppart view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public void run() {
        // Convertir Object en Appartement pour affichage
        ArrayList<Appartement> appartements = (ArrayList<Appartement>) model.getList().stream()
                .filter(Appartement.class::isInstance)
                .map(Appartement.class::cast)
                .collect(Collectors.toList());
        view.displayListAppart(appartements);
        view.run();
    }
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (ControlleurActions.ADD.equals(action)) {
            Appartement a = view.promptForNewAppart();
            if (a != null) {
                model.addItem(a);
                run();  // Réutilisation de run pour rafraîchir la vue
                view.showMessage("Ajout effectué avec succès !");
            }
        } else if (ControlleurActions.DELETE.equals(action)) {
            Integer id = view.promptForAppartById();
            if (id != null && model.deleteItem(id)) {
                run();  // Réutilisation de run pour rafraîchir la vue
                view.showMessage("Suppression effectuée avec succès !");
            } else {
                view.showErroMessage("Erreur de suppression ou ID invalide.");
            }
        } else if (ControlleurActions.UPDATE.equals(action)) {
            Integer id = view.promptForAppartById();
            if (id != null) {
                Appartement a = (Appartement) model.getItemById(id);
                if (a != null) {
                    Appartement updatedA = view.promptForUpdateAppart(a);
                    if (updatedA != null && model.updateItem(updatedA)) {
                        run();  // Réutilisation de run pour rafraîchir la vue
                        view.showMessage("Modification effectuée avec succès !");
                    } else {
                        view.showErroMessage("Erreur de modification.");
                    }
                } else {
                    view.showErroMessage("Appartement non trouvé.");
                }
            } else {
                view.showErroMessage("Vous devez sélectionner un article !");
            }
        }
    }

}
