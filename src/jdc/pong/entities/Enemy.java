package jdc.pong.entities;

import jdc.pong.PongGame;

import java.awt.*;

public class Enemy {

    private int x,y;
    private int width, height;

    private Ball ball;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 5;
        this.height = 40;
    }

    public void tick() {
        y += (ball.getY() - y - 6) * 0.07;

        if (y + height > PongGame.HEIGHT) y = PongGame.HEIGHT - height;
        else if (y < 0) y = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
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

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
