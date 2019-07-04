package Terraria.src.items.tools;

import Terraria.src.game.*;

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
        if (isWithinReach(x, y)) {
            // if the block is a pickaxe break kinda block
            System.out.println(model.cameraPos);
            System.out.println(model.cameraPosY);
            this.model.world.breakBlock((x + model.cameraPos + (model.world.HALF_WORLD_WIDTH * model.world.BLOCK_WIDTH))
                    / this.model.world.BLOCK_WIDTH, (y + model.cameraPosY) / this.model.world.BLOCK_HEIGHT);
        }
    }
}