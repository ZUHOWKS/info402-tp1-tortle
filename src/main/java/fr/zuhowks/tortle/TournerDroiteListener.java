package fr.zuhowks.tortle.listener;
import fr.zuhowks.tortle.Tortue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TournerDroiteListener implements ActionListener {
    private Tortue tortue;

    public TournerDroiteListener(Tortue tortue) {
        this.tortue = tortue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tortue.tournerDroite();
    }
}

