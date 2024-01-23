package fr.zuhowks.bernie;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;


public class BernieCanvas extends JPanel implements PropertyChangeListener {

    private final Bernie bernie;
    private final int carapaceWitdh;
    private final int carapaceHeight;
    private final Color skin;

    public BernieCanvas(Bernie bernie) {
        this.bernie = bernie;

        this.carapaceWitdh = (int) (this.bernie.getItBoxInX() * 0.9);
        this.carapaceHeight = (int) (this.bernie.getItBoxInY() * 0.9);
        
        this.skin = Color.GREEN;

        this.bernie.addPropertyChangeListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        double direction = bernie.getDirection();
        int x = bernie.getX() + (this.bernie.getItBoxInX() - this.carapaceWitdh)/2;
        int y = bernie.getY() + (this.bernie.getItBoxInY() - this.carapaceHeight)/2;

        g2D.rotate(direction, (double) x + this.bernie.getItBoxInX() * 0.5,  y + this.bernie.getItBoxInX() * 0.5);

        leftArm(x, y, direction, g2D);
        rightArm(x, y, direction, g2D);
        leftLeg(x, y, direction, g2D);
        rightLeg(x, y, direction, g2D);
        tete(x, y, direction, g2D);
        carapace(x, y, direction, g2D);
        g.setColor(Color.RED);
        g.drawRect(x - (this.bernie.getItBoxInX() - this.carapaceWitdh)/2, y -( this.bernie.getItBoxInY() - this.carapaceHeight)/2, this.bernie.getItBoxInX(), this.bernie.getItBoxInY());

    }

    private void carapace(int x, int y, double direction, Graphics2D g) {

        // Forme de la carapace
        g.setColor(this.skin);
        g.fillOval(x, y, this.carapaceWitdh, this.carapaceHeight);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, this.carapaceWitdh, this.carapaceHeight);
    }

    private void tete(int x, int y, double direction, Graphics2D g) {
        int width = (int) (this.bernie.getItBoxInX() * 0.325);
        int height = (int) (this.bernie.getItBoxInY() * 0.3);
        int posX = x + this.carapaceHeight;
        int posY = (int) (y + (carapaceHeight - height) * 0.5);

        // Visage
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);

        // Oeils
        g.setColor(Color.WHITE);
        g.fillOval((int) (posX + width * 0.5), (int) (posY + height * 0.125), (int) (width * 0.25), (int) (height * 0.25));
        g.fillOval((int) (posX + width * 0.5), (int) (posY + height * 0.875) - (int) (height * 0.25), (int) (width * 0.25), (int) (height * 0.25));
        g.setColor(Color.CYAN);
        g.fillOval((int) (posX + width * 0.575), (int) (posY + height * 0.145), (int) (width * 0.15), (int) (height * 0.15));
        g.fillOval((int) (posX + width * 0.575), (int) (posY + height * 0.855) - (int) (height * 0.15), (int) (width * 0.15), (int) (height * 0.15));

        // Bouche
        g.setColor(Color.BLACK);
        g.drawArc((int) (posX + (width * 0.25)), (int) (posY + (height * 0.1)), (int) (width * 0.65), (int) (height * 0.85), 35, -70);
        g.drawArc((int) (posX + (width * 0.25)) + 1, (int) (posY + (height * 0.1)), (int) (width * 0.65), (int) (height * 0.85), 35, -70);

    }

    private void leftMember(int y, Graphics2D g, int width, int height, int posX) {
        int posY = (int) (y + (this.bernie.getItBoxInY() - carapaceHeight * 0.7) * 0.5) - height;
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }

    private void rightMember(int y, Graphics2D g, int width, int height, int posX) {
        int posY = (int) (y + (this.bernie.getItBoxInY() + carapaceHeight * 0.45) * 0.5);
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }

    private void leftArm(int x, int y, double direction, Graphics2D g) {
        int width = (int) (this.bernie.getItBoxInX() * 0.225);
        int height = (int) (this.bernie.getItBoxInY() * 0.225);
        int posX = (int) (x + this.bernie.getItBoxInX() * 0.7);
        leftMember(y, g, width, height, posX);
    }

    private void rightArm(int x, int y, double direction, Graphics2D g) {
        int width = (int) (this.bernie.getItBoxInX() * 0.225);
        int height = (int) (this.bernie.getItBoxInY() * 0.225);
        int posX = (int) (x + this.bernie.getItBoxInX() * 0.7);
        rightMember(y, g, width, height, posX);
    }

    private void leftLeg(int x, int y, double direction, Graphics2D g) {
        int width = (int) (this.bernie.getItBoxInX() * 0.2);
        int height = (int) (this.bernie.getItBoxInY() * 0.2);
        int posX = (int) (x + this.bernie.getItBoxInX() * 0.05);
        leftMember(y, g, width, height, posX);
    }


    private void rightLeg(int x, int y, double direction, Graphics2D g) {
        int width = (int) (this.bernie.getItBoxInX() * 0.2);
        int height = (int) (this.bernie.getItBoxInY() * 0.2);
        int posX = (int) (x + this.bernie.getItBoxInX() * 0.05);
        rightMember(y, g, width, height, posX);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}