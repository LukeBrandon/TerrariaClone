package Terraria.src.items.tools;

import Terraria.src.game.*;
import Terraria.src.items.Item;

public abstract class Tool extends Item {
    Model model;
    String type;

    Tool(Model m) {
        super();
        this.model = m;
    }

    Tool(String name, Model m) {
        super(name);
        this.model = m;
    }

    boolean isPickaxe() {
        return false;
    }

    boolean isHammer() {
        return false;
    }

    boolean isAxe() {
        return false;
    }

    public void use(int x, int y) {
        System.out.println("This tool has no use");
    }

    public void stopUse() {
    }

    boolean isWithinReach(int x, int y) {
        // +25 us for half of mario width

        // convert to pixels for distance formula
        int xPix = (x * this.model.world.BLOCK_WIDTH) - (model.world.HALF_WORLD_WIDTH * model.world.BLOCK_WIDTH)
                - model.cameraPos;
        int yPix = (y * this.model.world.BLOCK_HEIGHT) - model.cameraPosY;
        double distanceFrom = Math.sqrt(
                (Math.pow(Math.abs(this.model.CAMERA_X_OFFSET + 25 - xPix), 2)) + (Math.pow(Math.abs(450 - yPix), 2)));

        if (distanceFrom <= 700)
            return true;
        return false;
    }

}