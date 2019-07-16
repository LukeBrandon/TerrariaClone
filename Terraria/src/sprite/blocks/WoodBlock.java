package Terraria.src.sprite.blocks;

import java.awt.Color;
import java.awt.Graphics;

import Terraria.src.game.Model;

public class WoodBlock extends Block {

    public WoodBlock(int x, int y, int w, int h, Model m) {
        super(x, y, w, h, m);
    }

    public boolean axeMine() {
        return true;
    }

    @Override
    public void draw(Graphics g, Model model) {
        Color brown = new Color(106, 67, 33); // brown
        g.setColor(brown);
        super.draw(g, model);
    }

}