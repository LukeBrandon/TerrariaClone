package Terraria.src.ui.inventory;

import Terraria.src.items.Item;

public class Inventory {
    private final int INVENTORY_WIDTH = 10;
    private final int INVENTORY_HEIGHT = 5;

    public String[][] inventory;

    public Inventory() {
        this.inventory = new String[INVENTORY_WIDTH][INVENTORY_WIDTH];
    }

    public void doSomething() {

    }

    public void add(int x, int y, Item item) {
        this.inventory[x][y] = item.name;
    }

    public void remove(int x, int y) {

    }

    public void print() {
        System.out.println("This is your inventory\n--------------------------");
        for (int i = 0; i < this.INVENTORY_HEIGHT; i++) {
            for (int j = 0; j < this.INVENTORY_WIDTH; j++) {
                System.out.print(this.inventory[j][i] + " / ");
            }
            System.out.println();
        }
    }
}