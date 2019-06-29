package Terraria.src;

import Terraria.src.game.View;
import Terraria.src.game.Controller;
import Terraria.src.game.Model;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

public class Game extends JFrame {
    private static final long serialVersionUID = 351682190217952631L;
    Model model;
    View view;
    Controller controller;

    public Game() {
        model = new Model();
        controller = new Controller(model);
        view = new View(controller, model);

        this.setTitle("Terraria 1.4");
        this.setSize(2000, 1800);
        this.setFocusable(true);
        this.getContentPane().add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.black);
        view.addMouseListener(controller);
        this.addKeyListener(controller);
    }

    public void run() {
        while (true) {

            model.update();
            controller.update();
            view.repaint();
            Toolkit.getDefaultToolkit().sync(); // updates the screen

            // sleep for 40 miliseconds or 25 fps
            // sleep for 20 ms or 50 fps
            // sleep for 16ms for 60 fps
            try {
                Thread.sleep(30);
                // Thread.sleep(250);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    // Main Method
    public static void main(String[] args) {
        Game g = new Game();
        g.run();
    }
}
