package Terraria.src.game;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Controller implements ActionListener, MouseListener, KeyListener {

    View view;
    Model model;

    // variables used for the key listener
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;
    boolean keyE;
    boolean keySpace;

    // used to make so mario cant fail a jump in between updates
    ArrayList<String> hasBeenPressed = new ArrayList<String>();

    public Controller(Model m) {
        model = m;
    }

    public void actionPerformed(ActionEvent e) {
    }

    void setView(View v) {
        view = v;
    }

    // Key listener implementation
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
            keyRight = true;
            break;
        case KeyEvent.VK_LEFT:
            keyLeft = true;
            break;
        case KeyEvent.VK_UP:
            keyUp = true;
            break;
        case KeyEvent.VK_DOWN:
            keyDown = true;
            break;
        case KeyEvent.VK_SPACE:
            keySpace = true;
            hasBeenPressed.add("space");
            break;
        case KeyEvent.VK_E:
            keyE = true;
            break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
            keyRight = false;
            break;
        case KeyEvent.VK_LEFT:
            keyLeft = false;
            break;
        case KeyEvent.VK_UP:
            keyUp = false;
            break;
        case KeyEvent.VK_DOWN:
            keyDown = false;
            break;
        case KeyEvent.VK_SPACE:
            keySpace = false;
            break;
        case KeyEvent.VK_E:
            keyE = false;
            break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    // MouseListener implementation
    public void mousePressed(MouseEvent e) {
        // if left mouse button presed, then place regular brick
        if (e.getButton() == MouseEvent.BUTTON1) {
            model.equipped.use(e.getX(), e.getY());
            // if righ tmouse button pressed, place coin block
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            // placeCoinBlock(e.getX(), e.getY());
        } else
            System.out.println("other mouse button pressed");
    }

    public void mouseReleased(MouseEvent e) {
        // if its the left mouse button then regular brick
        if (e.getButton() == MouseEvent.BUTTON1)
            model.equipped.stopUse();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    // void placeCoinBlock(int x, int y) {
    // // add coin block to sprites
    // model.sprites.add(new CoinBlock(x + model.cameraPos, y, model));
    // }

    // -----------------UPDATE---------------------------
    public void update() {
        model.player.oldPosition();

        if (keyRight) {
            model.player.moveMarioRight();
            model.player.animateMario("right");
        }
        if (keyLeft) {
            model.player.moveMarioLeft();
            model.player.animateMario("left");
        }
        if (keySpace) {
            hasBeenPressed.add(hasBeenPressed.size(), "space");
        }

        // checking and executing jumping buffer
        if (hasBeenPressed.size() >= 1) {
            for (int i = 0; i < hasBeenPressed.size(); i++) {
                if (hasBeenPressed.get(i) == "space" && model.player.lastTouchCounter < 6)
                    model.player.vertVel -= 3.5;
            }
            while (hasBeenPressed.size() > 0) {
                hasBeenPressed.remove(0);
            }
        }

    }// end of update method

}