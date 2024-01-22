package fr.zuhowks.tortle;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DessinTortue extends JPanel {

        private final Tortue tortue;
        public DessinTortue(Tortue tortue) {
            this.tortue = tortue;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = tortue.getX();
            int y = tortue.getY();


            g.setColor(Color.GREEN);
            g.fillOval(0, y, 50, 50);  // You can adjust the size
            g.setColor(Color.BLACK);
            g.drawOval(x, y, 50, 50);


            g.setColor(Color.GREEN);
            g.fillOval(x + 100, y + 40, 25, 25);
            g.setColor(Color.BLACK);
            g.drawOval(x + 100, y + 40, 25, 25);
        }

}