package Terraria.src.items.tools;

import Terraria.src.game.*;
import Terraria.src.sprite.blocks.*;

public class Axe extends Tool {

    public Axe(Model m) {
        super(m);
    }

    public Axe(String name, Model m) {
        super(name, m);
    }

    public boolean isAxe() {
        return true;
    }

    public void use(int x, int y) {
        Block thisBlock = this.model.world.world[x][y];

        if (thisBlock == null) {
            System.out.println("This is not a block");
            return;
        }

        if (isWithinReach(x, y) && thisBlock.axeMine()) {
            this.model.world.breakBlock(x, y);
        }
    }
}