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

    boolean isWithinReach(double x, double y) {
        // +25 us for half of mario width
        double distanceFrom = Math
                .sqrt((Math.pow(Math.abs(this.model.CAMERA_X_OFFSET + 25 - x), 2)) + (Math.pow(Math.abs(450 - y), 2)));
        if (distanceFrom <= 700)
            return true;
        return false;
    }

}