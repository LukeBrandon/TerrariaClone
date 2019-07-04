package Terraria.src.sprite;

import Terraria.src.game.Model;
import Terraria.src.sprite.*;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Block extends Sprite {
    // make variables for position and dimensions of brick
    Model model;

    public Block(int xtemp, int ytemp, int wtemp, int htemp, Model m) {
        xPos = xtemp;
        yPos = ytemp;
        width = wtemp;
        height = htemp;
        model = m;
    }

    @Override
    public void draw(Graphics g, Model model) {
        g.setColor(Color.green);
        g.fillRect(xPos - model.cameraPos, yPos - model.cameraPosY, width, height); // drawing bricks while subtracting
                                                                                    // camera position
    }

    // update method
    @Override
    public void update(ArrayList<Sprite> sprites) {
    }

    public boolean isABlock() {
        return true;
    }

}
