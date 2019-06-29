package Terraria.src.game;

import static Terraria.src.game.Model.backgroundImage;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class View extends JPanel {
    private static final long serialVersionUID = 5646627726797324929L;
    Model model;
    int marioCounter;

    public View(Controller c, Model m) {
        model = m;
        c.setView(this);
    }// end of constructor

    // --------------------Paint Component------------------------------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(-5000, -5000, 10000, 10000);
        g.drawImage(backgroundImage, model.backgroundX, -326, null);

        // draw all sprites
        for (int i = 0; i < model.sprites.size(); i++) {
            model.sprites.get(i).draw(g, model);
        }

    }
}
