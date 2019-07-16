package Terraria.src.sprite.blocks;

import java.awt.Color;
import java.awt.Graphics;

import Terraria.src.game.Model;

public class StoneBlock extends Block {

    public StoneBlock(int x, int y, int w, int h, Model m) {
        super(x, y, w, h, m);
    }

    public boolean pickaxeMine() {
        return true;
    }

    @Override
    public void draw(Graphics g, Model model) {
        g.setColor(Color.gray);
        super.draw(g, model);
    }

}