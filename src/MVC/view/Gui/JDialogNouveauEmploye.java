package MVC.view.Gui;

import MVC.controller.Controller;
import MVC.model.entity.Employe;
import MVC.view.ViewItems;

import javax.swing.*;
import java.awt.event.*;

public class JDialogNouveauEmploye extends JDialog implements ViewItems {
    private JPanel contentPane;
    private JButton buttonCreer;
    private JButton buttonAnnuler;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JPasswordField passwordFieldMDP;
    private JComboBox comboBoxFonction;
    private JLabel JLabelNom;
    private JLabel JLabelPrenom;
    private JLabel JLabelMDP;
    private JLabel JLabelFonction;


    private String nom;
    private String prenom;
    private String MDP;
    private String fonction;


    public JDialogNouveauEmploye() {
        super();
        JDialogConnexion formconnection=new JDialogConnexion();
        if(!formconnection.getconnecte()){
            formconnection.pack();
            formconnection.setVisible(true);
        }
        if(formconnection.getconnecte()) {
            setContentPane(contentPane);
            setModal(true);
            getRootPane().setDefaultButton(buttonCreer);
            setTitle("---- | Nouveau Employe |----");

            comboBoxFonction.addItem("Administrateur");
            comboBoxFonction.addItem("Employe");
            buttonCreer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOK();
                    nom = textFieldNom.getText();
                    prenom = textFieldPrenom.getText();
                    MDP = (String) passwordFieldMDP.getToolTipText();
                    fonction = comboBoxFonction.getToolTipText();
                    setVisible(false);
                }
            });

            buttonAnnuler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                    setVisible(false);
                }
            });

            // call onCancel() when cross is clicked
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            // call onCancel() on ESCAPE
            contentPane.registerKeyboardAction(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        JDialogNouveauEmploye dialog = new JDialogNouveauEmploye();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        System.out.println("Employee: " + dialog.getNom() + " - " + dialog.getPrenom() + " - " + dialog.getMDP() + " - " + dialog.getFonction());
    }
    public Employe getitems(){
        Employe employe=new Employe();
        employe.setNom( getNom());
        employe.setPrenom(getPrenom());
        employe.setMdp(getMDP());
        employe.setFonction(getFonction());
        return  employe;

    }
    public String getNom() {
        return textFieldNom.getText();
    }

    public String getPrenom() {
        return textFieldPrenom.getText();
    }

    public String getMDP() {
        return passwordFieldMDP.getToolTipText();
    }

    public String getFonction() {
        return (String) comboBoxFonction.getSelectedItem();
    }

    @Override
    public void showErroMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Pour votre information...",
                JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void run() {
        setVisible(true);
    }

    @Override
    public void setController(Controller c) {
        buttonCreer.setActionCommand("creeremp");
        buttonCreer.addActionListener(c);
    }
}
