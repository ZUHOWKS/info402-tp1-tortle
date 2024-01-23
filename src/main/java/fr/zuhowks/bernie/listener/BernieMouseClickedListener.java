package fr.zuhowks.bernie.listener;

import fr.zuhowks.bernie.Bernie;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class BernieMouseClickedListener implements MouseInputListener {

    private Bernie bernie;

    public BernieMouseClickedListener(Bernie bernie) {
        this.bernie = bernie;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.bernie.avancer();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
