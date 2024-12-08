package MVC.view.Gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;


public class JDialogNouvelAppart extends JDialog {
    private JPanel contentPane;
    private JButton buttonAjouter;
    private JButton buttonAnnuler;
    private JLabel JLabelNom;
    private JLabel JLabelAdresse;
    private JLabel JLabelSuperficie;
    private JLabel JLabelNbChambre;
    private JLabel JLabelPrix;
    private JLabel JLabelImage;
    private JTextField textFieldNom;
    private JTextField textFieldAdresse;
    private JTextField textFieldSuperficie;
    private JSpinner spinnerNbChambre;
    private JTextField textFieldPrix;
    private JButton chargerImageButton;

    private String Nom;
    private String Adresse;
    private double Superficie;
    private int NbChambre;
    private double prixLocation;
    private String[] images = new String[3]; // Correction ici

    public JDialogNouvelAppart() {
        super();
        JDialogConnexion formconnection=new JDialogConnexion();
        if(!formconnection.getconnecte()){
            formconnection.pack();
            formconnection.setVisible(true);
        }
        if(formconnection.getconnecte()) {
            setContentPane(contentPane);
            setModal(true);
            getRootPane().setDefaultButton(buttonAjouter);
            setTitle("----| Nouvel Appart |----");
            SpinnerModel model = new SpinnerNumberModel(1, 1, 4, 1);
            spinnerNbChambre.setModel(model);

            chargerImageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(true); // Permet de sélectionner plusieurs fichiers
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG Images", "png", "jpg");
                    fileChooser.setFileFilter(filter);
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File[] selectedFiles = fileChooser.getSelectedFiles();
                        for (int i = 0; i < selectedFiles.length && i < images.length; i++) {
                            images[i] = selectedFiles[i].getAbsolutePath();
                        }
                    }
                }
            });

            buttonAjouter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Nom = textFieldNom.getText();
                    Adresse = textFieldAdresse.getText();
                    try {
                        Superficie = Double.parseDouble(textFieldSuperficie.getText());
                        prixLocation = Double.parseDouble(textFieldPrix.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Superficie et prix doivent être des nombres.");
                        return;
                    }
                    NbChambre = (int) spinnerNbChambre.getValue();
                }
            });

            buttonAnnuler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                    setVisible(false);
                }
            });

            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            contentPane.registerKeyboardAction(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        }
        else{
            System.exit(0);
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        JDialogNouvelAppart dialog = new JDialogNouvelAppart();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

    // Getters
    public String[] getImages() {
        return Arrays.copyOf(images, images.length);
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public int getNbChambre() {
        return NbChambre;
    }

    public double getSuperficie() {
        return Superficie;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNom() {
        return Nom;
    }
}
