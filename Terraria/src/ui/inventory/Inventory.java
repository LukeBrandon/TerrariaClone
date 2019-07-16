package Terraria.src.ui.inventory;

import java.awt.Color;
import java.awt.Graphics;

import Terraria.src.items.Item;

public class Inventory {
    private final int INVENTORY_WIDTH = 10;
    private final int INVENTORY_HEIGHT = 5;

    private final int INVENTORY_SQUARE_HEIGHT = 80;
    private final int INVENTORY_SQUARE_WIDTH = 80;
    private final int INVENTORY_PADDING = 10;

    public Boolean open;

    public Item[][] inventory;

    public int equippedX, equippedY;

    public Inventory() {
        this.inventory = new Item[INVENTORY_WIDTH][INVENTORY_WIDTH];
        this.open = false;
        this.equippedX = 0;
        this.equippedY = 0;
    }

    public void doSomething() {

    }

    public void add(int x, int y, Item item) {
        this.inventory[x][y] = item;
    }

    public void remove(int x, int y) {

    }

    public Item getItem(int x, int y) {
        return this.inventory[x][y];
    }

    public void setEquipped(int x, int y) {
        this.equippedX = x;
        this.equippedY = y;
    }

    public void toggleOpen() {
        if (this.open == true) {
            this.open = false;
        } else {
            this.open = true;
        }
    }

    public void draw(Graphics g) {
        if (this.open) {

            for (int y = 0; y < INVENTORY_HEIGHT; y++) {
                for (int x = 0; x < INVENTORY_WIDTH; x++) {
                    int xDraw = (INVENTORY_SQUARE_WIDTH * x) + (INVENTORY_PADDING * (x + 1)); // +1 side padding
                    int yDraw = (INVENTORY_SQUARE_HEIGHT * y) + (INVENTORY_PADDING * (y + 1));
                    if ((x == this.equippedX) && (y == this.equippedY))
                        g.setColor(Color.yellow);
                    else
                        g.setColor(Color.blue);
                    g.fillRect(xDraw, yDraw, INVENTORY_SQUARE_WIDTH, INVENTORY_SQUARE_HEIGHT);
                    // g.drawImage(image that is in inventory slot);
                }
            }

        } else {
            for (int x = 0; x < INVENTORY_WIDTH; x++) {
                int xDraw = (INVENTORY_SQUARE_WIDTH * x) + (INVENTORY_PADDING * (x + 1)); // +1 side padding
                if ((x == this.equippedX) && (0 == this.equippedY))
                    g.setColor(Color.yellow);
                else
                    g.setColor(Color.blue);
                g.fillRect(xDraw, INVENTORY_PADDING, INVENTORY_SQUARE_WIDTH, INVENTORY_SQUARE_HEIGHT);
                // g.drawImage(image that is in inventory slot);
            }
        }
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