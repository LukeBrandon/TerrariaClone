package Terraria.src.tools;

import Terraria.src.game.*;

public class Pickaxe extends Tool {

    public Pickaxe(Model m) {
        super(m);
    }

    public boolean isPickaxe() {
        return true;
    }

    public void use(int x, int y) {
        if (isWithinReach(x, y)) {
            System.out.println("break stone");
        }
    }
}