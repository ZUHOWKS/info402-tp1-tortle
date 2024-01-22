package fr.zuhowks.tortle;

import java.awt.*;
import javax.swing.JPanel;


public class DessinTortue extends JPanel {

    private final Tortue tortue;
    private final int xBox;
    private final int yBox;
    private final int carapaceWitdh;
    private final int carapaceHeight;
    private final Color skin;

    public DessinTortue(Tortue tortue) {
        this.tortue = tortue;
        this.xBox = 250;
        this.yBox = 225;

        this.carapaceWitdh = (int) (this.xBox * 0.9);
        this.carapaceHeight = (int) (this.yBox * 0.9);
        
        this.skin = Color.GREEN;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int direction = tortue.getDirection();
        int x = tortue.getX();
        int y = tortue.getY();

        g2D.rotate(direction, (double) (x + xBox) / 2, (double) (y + xBox) / 2);
        leftArm(x, y, direction, g2D);
        rightArm(x, y, direction, g2D);
        leftLeg(x, y, direction, g2D);
        rightLeg(x, y, direction, g2D);
        tete(x, y, direction, g2D);
        carapace(x, y, direction, g2D);


    }

    private void carapace(int x, int y, int direction, Graphics2D g) {

        // Forme de la carapace
        g.setColor(this.skin);
        g.fillOval(x, y, this.carapaceWitdh, this.carapaceHeight);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, this.carapaceWitdh, this.carapaceHeight);
    }

    private void tete(int x, int y, int direction, Graphics2D g) {
        int width = (int) (this.xBox * 0.325);
        int height = (int) (this.yBox * 0.3);
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

    private void leftArm(int x, int y, int direction, Graphics2D g) {
        int width = (int) (this.xBox * 0.225);
        int height = (int) (this.yBox * 0.225);
        int posX = (int) (x + xBox * 0.7);
        int posY = (int) (y + (yBox - carapaceHeight * 0.7) * 0.5) - height;
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }

    private void rightArm(int x, int y, int direction, Graphics2D g) {
        int width = (int) (this.xBox * 0.225);
        int height = (int) (this.yBox * 0.225);
        int posX = (int) (x + xBox * 0.7);
        int posY = (int) (y + (yBox + carapaceHeight * 0.45) * 0.5);
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }

    private void leftLeg(int x, int y, int direction, Graphics2D g) {
        int width = (int) (this.xBox * 0.2);
        int height = (int) (this.yBox * 0.2);
        int posX = (int) (x + xBox * 0.05);
        int posY = (int) (y + (yBox - carapaceHeight * 0.7) * 0.5) - height;
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }

    private void rightLeg(int x, int y, int direction, Graphics2D g) {
        int width = (int) (this.xBox * 0.2);
        int height = (int) (this.yBox * 0.2);
        int posX = (int) (x + xBox * 0.05);
        int posY = (int) (y + (yBox + carapaceHeight * 0.45) * 0.5);
        g.setColor(this.skin);
        g.fillOval(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, width, height);
    }



}