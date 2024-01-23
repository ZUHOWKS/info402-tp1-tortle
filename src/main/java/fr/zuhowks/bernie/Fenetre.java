package fr.zuhowks.bernie;

import fr.zuhowks.bernie.listener.*;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    public final int width;
    public final int height;

    private Bernie bernie;

    public Fenetre() {
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.width = screenDim.width;
        this.height = screenDim.height;

        this.bernie = new Bernie();
        this.setSize(width, height);
        this.setMaximumSize(screenDim);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setLayout(new BorderLayout());
        BernieCanvas tortuePanel = new BernieCanvas(this.bernie);
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

        this.addMouseMotionListener(new BernieFollowMouseListener(this.bernie));
        this.addMouseListener(new BernieMouseClickedListener(this.bernie));

        bouton_avancer.addActionListener(new BernieForwardListener(bernie));
        bouton_droite.addActionListener(new BernieRightDragListener(bernie));
        bouton_gauche.addActionListener(new BernieLeftDragListener(bernie));

    }
}