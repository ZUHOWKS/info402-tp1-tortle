package fr.zuhowks.tortle;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Fenetre extends JFrame {

    public static final int HAUTEUR = 500;
    public static final int LARGEUR = 500;

    private Tortue tortue;

    public Fenetre() {
        this.tortue = new Tortue();
        this.setSize(LARGEUR, HAUTEUR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setLayout(new BorderLayout());
        DessinTortue tortuePanel = new DessinTortue(this.tortue);
        this.add(tortuePanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        JButton bouton_gauche = new JButton("Gauche");
        panel.add(bouton_gauche);

        JButton bouton_avancer = new JButton("Avancer");
        panel.add(bouton_avancer);

        JButton bouton_droite = new JButton("Droite");
        panel.add(bouton_droite);

        this.getContentPane().add(panel, BorderLayout.SOUTH);
    }
}