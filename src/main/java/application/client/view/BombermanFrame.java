package application.client.view;

import javax.swing.*;

public class BombermanFrame extends JFrame {

    public BombermanFrame(BombermanPanel panel) {
        setTitle("Bomberman");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
