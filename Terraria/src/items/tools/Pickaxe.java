package Terraria.src.items.tools;

import Terraria.src.game.*;
import Terraria.src.sprite.blocks.*;

public class Pickaxe extends Tool {

    public Pickaxe(Model m) {
        super(m);
    }

    public Pickaxe(String name, Model m) {
        super(name, m);
    }

    public boolean isPickaxe() {
        return true;
    }

    public void use(int x, int y) {
        Block thisBlock = this.model.world.world[x][y];

        if (thisBlock == null) {
            System.out.println("This is not a block");
            return;
        }

        if (isWithinReach(x, y) && thisBlock.pickaxeMine()) {
            this.model.world.breakBlock(x, y);
        }
    }
}