package fr.zuhowks.tortle;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame f = new Fenetre();
        f.setVisible(true);
        Tortue tortue = new Tortue();
        System.out.println(tortue.getY());
    }
}