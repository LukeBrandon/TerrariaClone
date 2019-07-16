package Terraria.src.items.tools;

import Terraria.src.game.*;
import Terraria.src.sprite.blocks.*;

public class Hammer extends Tool {

    public Hammer(Model m) {
        super(m);
    }

    public Hammer(String name, Model m) {
        super(name, m);
    }

    @Override
    public boolean isHammer() {
        return true;
    }

    @Override
    public void use(int x, int y) {
        Block thisBlock = this.model.world.world[x][y];
        if (thisBlock == null) {
            System.out.println("This is not a block");
            return;
        }
        if (isWithinReach(x, y)) {
            System.out.println("break wall");
        }
    }
}