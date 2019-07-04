package Terraria.src.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

// import Terraria.src.items.acessories.*;
import Terraria.src.sprite.Player;
import Terraria.src.sprite.Sprite;
import Terraria.src.world.World;

public class Model {
    public final int CAMERA_X_OFFSET = 950;
    public final int CAMERA_Y_OFFSET = 750;

    public World world;
    public Player player;
    public ArrayList<Sprite> sprites;
    public static BufferedImage backgroundImage = null;
    public int backgroundX;
    public int backgroundY;
    public int cameraPos;
    public int cameraPosY;

    public Model() {
        sprites = new ArrayList<Sprite>();
        sprites.add(this.player = new Player(this));
        this.world = new World(this);
        this.world.generate(this.sprites);

        lazyLoadBackgroundImage();
        backgroundX = 0;
        cameraPos = 10;
        cameraPosY = 0;
    }

    public void update() {
        cameraPos = player.xPos - CAMERA_X_OFFSET;
        cameraPosY = player.yPos - CAMERA_Y_OFFSET;
        backgroundX = -(cameraPos / 3) - 500;
        backgroundY = -(cameraPosY / 7) - 200;

        for (int i = 0; i < sprites.size(); i++) {
            Sprite tempSprite = sprites.get(i);
            tempSprite.update(sprites);
        }
    }

    private void lazyLoadBackgroundImage() {
        if (backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("Terraria/images/background.png"));
            } catch (IOException e) {
                System.out.println("Failed to load background image // " + e);
            }
        }
    }

} // end model class
