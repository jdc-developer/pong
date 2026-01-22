package jdc.pong.entities;

import jdc.pong.PongGame;

import java.awt.*;

public class Player {

    private boolean up, down;
    private int x,y;
    private int width, height;
    private int speed = 2;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 40;
    }

    public void tick() {
        if (up) y-=speed;
        else if (down) y+=speed;

        if (y + height > PongGame.HEIGHT) y = PongGame.HEIGHT - height;
        else if (y < 0) y = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
