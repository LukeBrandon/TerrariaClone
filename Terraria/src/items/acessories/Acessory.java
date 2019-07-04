package Terraria.src.items.acessories;

import Terraria.src.items.Item;

public class Acessory extends Item {
    String benefit;

    public Acessory() {
        super();
    }

    public Acessory(String benefit) {
        super();
        this.benefit = benefit;
    }

    public Acessory(String benefit, String name) {
        super(name);
        this.benefit = benefit;
    }
}