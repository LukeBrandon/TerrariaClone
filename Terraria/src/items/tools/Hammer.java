package Terraria.src.items.tools;

import Terraria.src.game.*;

public class Hammer extends Tool {

    public Hammer(Model m) {
        super(m);
    }

    @Override
    public boolean isHammer() {
        return true;
    }

    @Override
    public void use(int x, int y) {
        if (isWithinReach(x, y)) {
            System.out.println("break wall");
        }
    }
}