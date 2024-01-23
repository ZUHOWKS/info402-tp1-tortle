package fr.zuhowks.tortle.listener;

import fr.zuhowks.tortle.Tortue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BernieFollowMouseListener implements MouseMotionListener {

    private final Tortue bernie;

    public BernieFollowMouseListener(Tortue bernie) {
        this.bernie = bernie;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double bernieX = this.bernie.getX() + this.bernie.getItBoxInX()/2;
        double bernieY = this.bernie.getY() + this.bernie.getItBoxInY()/2;

        double mouseX = e.getX();
        double mouseY = e.getY();

        double xMouseOnCircle = mouseX - bernieX;
        double yMouseOnCircle = mouseY - bernieY;

        double r = Math.sqrt(xMouseOnCircle*xMouseOnCircle + yMouseOnCircle*yMouseOnCircle);
        double angle = Math.atan(yMouseOnCircle / xMouseOnCircle);




        if (bernieX > mouseX && bernieY < mouseY ) {
           angle+=Math.PI;
        }

        if (bernieY == mouseY && bernieX > mouseX) {
            angle=Math.PI;
        }

        if (bernieX > mouseX && bernieY > mouseY ) {
            angle+=Math.PI;
        }



        this.bernie.setDirection(angle);
        System.out.println(angle);
    }
}
