package Terraria.src.world;

import java.awt.Graphics;
import java.util.ArrayList;

import Terraria.src.game.*;
import Terraria.src.sprite.*;
import Terraria.src.sprite.blocks.*;

public class World {
    public final int WORLD_WIDTH = 1000;
    public final int WORLD_DEPTH = 100;
    public final int HALF_WORLD_WIDTH = WORLD_WIDTH / 2;
    public final int HALF_WORLD_DEPTH = WORLD_DEPTH / 2;

    public final int BLOCK_WIDTH = 50;
    public final int BLOCK_HEIGHT = 50;

    public final int Y_OFFSET = 700; // deprecated
    public final int X_OFFSET = 1000;

    public Block[][] world;

    private Model model;

    public World(Model m) {
        this.model = m;
        this.world = new Block[WORLD_WIDTH][WORLD_DEPTH];
    }

    public void generate(ArrayList<Sprite> sprites) {
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_DEPTH; y++) {
                int xToDraw = (x * BLOCK_WIDTH) - (HALF_WORLD_WIDTH * BLOCK_WIDTH);
                int yToDraw = (y * BLOCK_HEIGHT);

                double rand = Math.random();
                if (y > 18 && rand > .5)
                    world[x][y] = new WoodBlock(xToDraw, yToDraw, BLOCK_WIDTH, BLOCK_HEIGHT, this.model);
                else if (y > 18 && rand < .5)
                    world[x][y] = new StoneBlock(xToDraw, yToDraw, BLOCK_WIDTH, BLOCK_HEIGHT, this.model);
                else
                    world[x][y] = null;
            }
        }
    }

    public void draw(Graphics g) {
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_DEPTH; y++) {
                if (world[x][y] != null) {
                    world[x][y].draw(g, model);
                }
            }
        }
    }

    public void breakBlock(int x, int y) {
        world[x][y] = null;
    }

}