package Terraria.src.sprite;

import Terraria.src.game.*;
import Terraria.src.items.tools.*;
import Terraria.src.ui.inventory.Inventory;

import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Iterator;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Image;
import java.util.ArrayList;

public class Player extends Sprite {
    static Image[] rightPlayerImages = null;
    static Image[] leftPlayerImages = null;
    Image playerImage = null;
    int marioCounter;
    Model model;
    public Inventory inventory;
    public Tool equipped;

    public Player(Model m) {
        this.inventory = new Inventory();
        yPos = 300; // should drop onto the ground some
        xPos = 0;
        width = 60;
        height = 95;
        model = m;

        this.equipped = new Pickaxe("Demonite Pickaxe", this.model);
        this.inventory.add(0, 0, this.equipped);
        this.inventory.add(1, 0, this.equipped);

        lazyLoad();
    }

    @Override
    public void draw(Graphics g, Model model) {
        g.drawImage(playerImage, this.xPos - model.cameraPos, this.yPos, null);
    }

    @Override
    public void update(ArrayList<Sprite> sprites) {

        // accelerates downwards
        vertVel += 1.3;
        yPos += vertVel;
        lastTouchCounter++; // used for dynamic jumped heights

        checkCollideWithSprites(sprites);
        checkCollideWithBlocks();

    }// end of update method

    boolean isPlayer() { // mario identity
        return true;
    }

    public void moveMarioRight() { // mario move methods
        xPos += 8;
    }

    public void moveMarioLeft() {
        xPos -= 8;
    }

    // animates mario as he walks
    public void animateMario(String direction) {
        if (direction == "right") {
            playerImage = rightPlayerImages[marioCounter / 5]; // makes mario animate every 5 updates (looks better)
            marioCounter++;
            marioCounter %= 25;
        } else if (direction == "left") {
            playerImage = leftPlayerImages[marioCounter / 5];
            marioCounter++;
            marioCounter %= 25;
        } else {
            System.out.println("Animate mario failed.");
        }
    }

    void lazyLoad() {
        // lazy loading mario Images
        if (rightPlayerImages == null) {
            rightPlayerImages = new Image[5];
            try {
                rightPlayerImages[0] = ImageIO.read(new File("Terraria/images/mario1.png"));
                rightPlayerImages[1] = ImageIO.read(new File("Terraria/images/mario2.png"));
                rightPlayerImages[2] = ImageIO.read(new File("Terraria/images/mario3.png"));
                rightPlayerImages[3] = ImageIO.read(new File("Terraria/images/mario4.png"));
                rightPlayerImages[4] = ImageIO.read(new File("Terraria/images/mario5.png"));
            } catch (IOException e) {
                System.out.println("Failed to load player images // " + e);
            }
        }
        if (leftPlayerImages == null) {
            leftPlayerImages = new Image[5];
            try {
                leftPlayerImages[0] = ImageIO.read(new File("Terraria/images/leftMario1.png"));
                leftPlayerImages[1] = ImageIO.read(new File("Terraria/images/leftMario2.png"));
                leftPlayerImages[2] = ImageIO.read(new File("Terraria/images/leftMario3.png"));
                leftPlayerImages[3] = ImageIO.read(new File("Terraria/images/leftMario4.png"));
                leftPlayerImages[4] = ImageIO.read(new File("Terraria/images/leftMario5.png"));
            } catch (IOException e) {
                System.out.println("Failed to load player images // " + e);
            }
        } // end lazy loading

        playerImage = rightPlayerImages[0]; // makes mario appear on startup
    }

    void checkCollideWithBlocks() {
        for (int x = 0; x < model.world.WORLD_WIDTH; x++) {
            for (int y = 0; y < model.world.WORLD_DEPTH; y++) {
                if (model.world.world[x][y] != null) {
                    Block b = model.world.world[x][y];

                    if (this.collides(b)) {
                        this.pushOut(b);
                    }
                }
            }
        }
    }

    void checkCollideWithSprites(ArrayList<Sprite> sprites) {
        // Using iterator to determine operations upon collision
        Iterator<Sprite> iterator = sprites.iterator();
        while (iterator.hasNext()) {
            Sprite s = iterator.next();

            // only push out when colliding with a brick
            // if (s.isABlock()) {
            // if (s != this && this.collides(s)) {
            // this.pushOut(s);
            // }
            // }

        } // end while loop
    }

}// end of class