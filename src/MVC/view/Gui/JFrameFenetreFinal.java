package MVC.view.Gui;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

import MVC.controller.Controller;
import MVC.model.entity.Appartement;
import MVC.model.entity.Client;
import MVC.model.entity.Employe;
import MVC.model.entity.Option;
import MVC.view.*;

public class JFrameFenetreFinal extends JFrame implements ViewItems, ViewClient,Viewlistemplo
{
    private JPanel MainPanel;
    private JPanel JpanelPhoto;
    private JComboBox comboBoxListAppart;
    private JTextField textFieldNum;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldNbPersonne;
    private JTextField textFieldDateDebut;
    private JSpinner spinnerNbNuits;
    private JLabel LabelNbNuits;
    private JCheckBox checkBoxDej;
    private JCheckBox checkBoxEnf;
    private JCheckBox checkBoxFumeur;
    private JCheckBox checkBoxAnnimaux;
    private JLabel LabelClient;
    private JButton ButtonEnregistrer;
    private JButton nouveauButton;
    private JButton supprimerButton;
    private JButton factureButton;
    private JLabel LabelNumClient;
    private JLabel LabelNom;
    private JLabel LabelPrenom;
    private JLabel LabelTotal;
    private JLabel LabelNomAppart;
    private JLabel LabelDimension;
    private JLabel LabelCapacite;
    private JLabel LabelPrix;
    private JLabel LabelAppart;

    private JTable table1;

    private JPanel PhotoAppart;
    private JList list1;
    private JTable table2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton viderButton;
    private JTable table3;


    private JMenuItem Cli, Emp,dec,app;
    private JMenu connexion,addNewAppart;

    public JFrameFenetreFinal() {

        //FlatDarkLaf.setup();
        JDialogConnexion formconnection = new JDialogConnexion();
        if (!formconnection.getconnecte()) {
            formconnection.pack();
            formconnection.setVisible(true);
        }
        if (formconnection.getconnecte()) {

            add(MainPanel);
            setTitle("my first");
            setSize(1200, 600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //setVisible(true);

            JMenuBar Jmenubar = new JMenuBar();
            connexion = new JMenu("Deconnexion");
            dec = new JMenuItem("Deconnexion");
            connexion.add(dec);
            Jmenubar.add(connexion);

            JMenu addNewPersonne = new JMenu("Personne");
            Jmenubar.add(addNewPersonne);
            Cli = new JMenuItem("Ajouter Client");
            Emp = new JMenuItem("Ajouter Employé");
            addNewPersonne.add(Cli);
            addNewPersonne.add(Emp);

            addNewAppart = new JMenu("appartement");
            app = new JMenuItem("appartement");
            addNewAppart.add(app);
            Jmenubar.add(addNewAppart);

            setJMenuBar(Jmenubar);

            /*Cli.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JdialogNouveauClient fenetrecli = new JdialogNouveauClient();
                    fenetrecli.pack();
                    fenetrecli.setVisible(true);
                    fenetrecli.dispose();
                }
            });*/

            /*Emp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialogNouveauEmploye fenetreemp = new JDialogNouveauEmploye();
                    fenetreemp.pack();
                    fenetreemp.setVisible(true);
                    fenetreemp.dispose();
                }
            });*/

           /* addNewAppart.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JDialogNouvelAppart fenetreappart = new JDialogNouvelAppart();
                    fenetreappart.pack();
                    fenetreappart.setVisible(true);
                    fenetreappart.dispose();
                }
            });
            connexion.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JDialogmessage fenetrem = new JDialogmessage("Au revoir !");
                    fenetrem.pack();
                    fenetrem.setVisible(true);
                    fenetrem.dispose();
                    System.exit(0);
                }
            });*/

            add(MainPanel);
            setTitle("my first");
            setSize(1200, 600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //setVisible(true);

        /*JMenuBar Jmenubar = new JMenuBar();
        JMenu connexion = new JMenu("Connexion");
        Jmenubar.add(connexion);

        JMenu addNewPersonne = new JMenu("Personne");
        Jmenubar.add(addNewPersonne);
        Cli = new JMenuItem("Ajouter Client");
        Emp = new JMenuItem("Ajouter Employé");
        addNewPersonne.add(Cli);
        addNewPersonne.add(Emp);

        JMenu addNewAppart = new JMenu("appartement");
        Jmenubar.add(addNewAppart);


        setJMenuBar(Jmenubar);*/
            // Charger l'image et l'ajouter au panneau PhotoAppart
            // loadImage();
        }
    }
   /* private void loadImage() {
        // Utilisez getResource pour charger l'image depuis le classpath
        String imagePath = "/MVC/view/Gui/images/Bateau1.jpg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));

        if (imageIcon.getIconWidth() == -1) {
            System.out.println("L'image ne peut pas être chargée. Vérifiez le chemin de l'image.");
        } else {
            JLabel imageLabel = new JLabel(imageIcon);
            PhotoAppart.setLayout(new BorderLayout());
            PhotoAppart.add(imageLabel, BorderLayout.CENTER);
        }
    }*/



    public static void main(String[] args)
    {
        JFrameFenetreFinal monPanel = new JFrameFenetreFinal();
        monPanel.setVisible(true);


        //JListEmployes.add("dh","kn",1);
        //System.exit(0);

    }



    public void displayListEmploye(ArrayList<Employe> employes) {

        String[] columnNames = {"Nom", "Prénom"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Aucune cellule ne peut être modifiée
            }
        };


        for (Employe emp : employes) {
            model.addRow(new Object[]{emp.getNom(), emp.getPrenom()});
        }

        // Set the new model to the existing table
        table1.setModel(model);



        // Création du JTable avec le modèle

        /*String[] a= new String[employes.size()];
        for(int i=0;i<employes.size();i++){
            a[i]="Matricule"+employes.get(i).getMatricule()+ "NOM:"+employes.get(i).getNom()+"     PRENOM:"+employes.get(i).getPrenom();
        }
        // Utiliser setListData pour mettre à jour le JList
        JListEmployes.setListData(a);
        //JListEmployes.se*/
    }
    public void displayListClient(ArrayList<Client> clients){
        String[] columnNames = {"Nom", "Prénom"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Aucune cellule ne peut être modifiée
            }
        };


        for (Client cli : clients) {
            model.addRow(new Object[]{cli.getNom(), cli.getPrenom()});
        }

        // Set the new model to the existing table
        table2.setModel(model);
    }
    public  void displayListoption(ArrayList<Option> options){
        String[] a= new String[options.size()];
        list1.setListData(a);
        if(!options.isEmpty()){
            for(int i=0;i<options.size();i++){
                a[i]="NOM: "+options.get(i).getType()+ "    PRIX: "+options.get(i).getPrix();
            }
            // Utiliser setListData pour mettre à jour le JList
            list1.setListData(a);
        }

        //JListEmployes.se
    }
    public void displayapart(ArrayList<Appartement> a){

        for (Appartement appart : a) {
            comboBoxListAppart.addItem(appart.getNom());
        }
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
        comboBoxListAppart.addActionListener(c);
        checkBoxDej.addActionListener(c);
        checkBoxEnf.addActionListener(c);
        checkBoxAnnimaux.addActionListener(c);
        checkBoxFumeur.addActionListener(c);
        Cli.addActionListener(c);
        Emp.addActionListener(c);
        app.addActionListener(c);
        dec.addActionListener(c);

        addNewAppart.setActionCommand("Add appart");
        Emp.setActionCommand("Add Employe");
    }

    public void updateapart(ArrayList<Appartement> ap){
        Appartement a=ap.get(comboBoxListAppart.getSelectedIndex());
        label1.setText(a.getNom());
        label2.setText(""+a.getSuperficie());
        label3.setText(""+a.getNbChambres());
        label4.setText(""+a.getPrixLocation());
    }



}