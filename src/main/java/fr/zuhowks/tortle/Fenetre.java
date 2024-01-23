package fr.zuhowks.tortle;

import fr.zuhowks.tortle.listener.AvancerListener;
import fr.zuhowks.tortle.listener.TournerDroiteListener;
import fr.zuhowks.tortle.listener.TournerGaucheListener;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    public final int width;
    public final int height;

    private Tortue tortue;

    public Fenetre() {
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.width = screenDim.width;
        this.height = screenDim.height;

        this.tortue = new Tortue();
        this.setSize(width, height);
        this.setMaximumSize(screenDim);
        this.setExtendedState(this.MAXIMIZED_BOTH);
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
        bouton_avancer.addActionListener(new AvancerListener(tortue));
        bouton_droite.addActionListener(new TournerDroiteListener(tortue));
        bouton_gauche.addActionListener(new TournerGaucheListener(tortue));




    }
}