package fr.zuhowks.bernie.listener;
import fr.zuhowks.bernie.Bernie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BernieRightDragListener implements ActionListener {
    private Bernie bernie;

    public BernieRightDragListener(Bernie bernie) {
        this.bernie = bernie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bernie.tournerDroite();
    }
}

