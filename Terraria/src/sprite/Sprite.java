package Terraria.src.sprite;

import Terraria.src.game.*;

import java.awt.Graphics;
import java.util.ArrayList;

//types of sprite classes inheret this class

public abstract class Sprite {
    // member variables
    public int xPos;
    public int yPos;
    int prevX;
    int prevY;
    int width;
    int height;
    public int lastTouchCounter;
    public double vertVel;

    Sprite() {
    }

    public abstract void draw(Graphics g, Model model);

    public abstract void update(ArrayList<Sprite> sprites);

    // -------------Identity Methods-----------------
    public boolean isABlock() {
        return false;
    }

    boolean isPlayer() {
        return false;
    }

    boolean isACoin() {
        return false;
    }

    boolean isACoinBlock() {
        return false;
    }

    // Setter methods
    void setX(int x) {
        xPos = x;
    }

    void setY(int y) {
        yPos = y;
    }

    void setW(int w) {
        width = w;
    }

    void setH(int h) {
        height = h;
    }

    // getter methods
    int getX() {
        return xPos;
    }

    int getY() {
        return yPos;
    }

    int getW() {
        return width;
    }

    int getH() {
        return height;
    }

    // remembers where sprite was, called right before sprite is moved in the
    // controller
    public void oldPosition() {
        prevX = xPos;
        prevY = yPos;
    }

    // collision detection method
    boolean collides(Sprite that) {
        if (this.yPos + this.height <= that.getY()) { // above
            return false;
        }
        if (this.xPos + this.width <= that.getX()) { // right side of mario
            return false;
        }
        if (this.xPos >= that.getX() + that.getW()) { // left side of mario
            return false;
        }
        if (this.yPos >= that.getY() + that.getH()) { // below
            return false;
        }
        return true;
    }

    boolean collidesBottom(Sprite that) {
        if (yPos <= that.getY() + that.getH() && !(prevY < that.getY() + that.getH()))
            return true;
        return false;
    }

    // return type that tells which side it collided on
    void pushOut(Sprite that) {

        // entering from top
        if (yPos + height >= that.getY() && !(prevY + height > that.getY())) {
            this.vertVel = 0.0;
            this.lastTouchCounter = 0; // not fall through and allow jump
            this.yPos = that.getY() - this.height;

            // entering from bottom
        } else if (yPos <= that.getY() + that.getH() && !(prevY < that.getY() + that.getH())) {
            this.vertVel = 0.0;
            this.yPos = that.getY() + that.getH() + 3;

            // entering from left
        } else if (xPos + width >= that.getX() && !(prevX + width > that.getX())) {
            this.xPos = that.getX() - this.width;

            // entering from right
        } else if (xPos <= (that.getX() + that.getW()) && !(prevX < (that.getX() + that.getW()))) {
            this.xPos = that.getX() + that.getW();

        } else {
            System.out.println("Didn't meet any of the directional conditions");
        }
    }// end of push out method

}// end of sprite class