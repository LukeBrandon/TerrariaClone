package Terraria.src.items;

public class Item {
    public String name;

    public Item() {
        this.name = "Error: no name";
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void use(int x, int y) {
        System.out.println("use " + this.name);
    }

    public void stopUse() {
        System.out.println("stop use of " + this.name);
    }

}
