package Terraria.src.game;

import Terraria.src.tools.*;
import Terraria.src.sprite.*;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class Model {
    Player player; // only instance of mario, instantiated in the unmarshall from JSON file
    Tool equipped;
    static BufferedImage backgroundImage = null;

    ArrayList<Sprite> sprites;

    int backgroundX;
    public int cameraPos;

    public Model() {
        sprites = new ArrayList<Sprite>();
        sprites.add(player = new Player(this));
        equipped = new Pickaxe(this);
        generateFloor();

        // lazy load background image
        if (backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("Terraria/src/images/background.png"));
            } catch (IOException e) {
                System.out.println("Failed to load background image // " + e);
            }
        }

        sprites.add(new Block(0, 0, 10, 10, this));
        backgroundX = 0;
        cameraPos = 10;
    }// end of model constuctor

    public void update() {
        cameraPos = player.xPos - 950;
        backgroundX = -cameraPos / 3;

        for (int i = 0; i < sprites.size(); i++) {
            Sprite tempSprite = sprites.get(i);
            tempSprite.update(sprites);
        }
    }

    // void createBrick(int x1, int y1, int x2, int y2) {
    // int x = Math.min(x1, x2) + cameraPos;
    // int y = Math.min(y1, y2);
    // int w = Math.max(x1, x2) - Math.min(x1, x2);
    // int h = Math.max(y1, y2) - y;

    // Block b1 = new Block(x, y, w, h, this); // this makes the new brick
    // sprites.add(b1); // adds the new brick to the array list of bricks
    // }

    void undo() {
        // undoes the last brick drawing
        int lastIndex = sprites.size() - 1;
        boolean looking = true;

        // looks to delete the last added brick from sprites
        while (lastIndex >= 0 && looking) {
            if (sprites.get(lastIndex).isABrick()) {
                sprites.remove(lastIndex);
                looking = false;
            } else
                lastIndex--;
        }
        if (lastIndex == 0)
            System.out.println("There is nothing left to be undone");
    }

    void generateFloor() {
        for (int i = -100; i < 100; i++) {
            Block block = new Block(i * 40, 500, 40, 40, this);
            sprites.add(block);
        }
    }

}
