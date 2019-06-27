package Terraria.src.tools;

import Terraria.src.game.*;

public abstract class Tool {
    Model model;
    String type;

    Tool(Model m) {
        model = m;
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
        double distanceFrom = Math.sqrt((Math.pow(Math.abs(980 - x), 2)) + (Math.pow(Math.abs(450 - y), 2)));
        if (distanceFrom <= 400)
            return true;
        return false;
    }

}