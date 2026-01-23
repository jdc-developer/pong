package jdc.pong.entities;

import jdc.pong.PongGame;
import jdc.pong.sound.Sound;

import java.awt.*;
import java.util.Random;

public class Ball {

    private double x,y;
    private int width, height;

    private double dx, dy;
    private double speed = 2.5;

    private Player player;
    private Enemy enemy;

    public Ball(Enemy enemy, Player player) {
        this.width = 4;
        this.height = 4;
        this.enemy = enemy;
        this.player = player;
        reset();
    }

    public void tick() {
        if (y + (dy * speed) + height >= PongGame.HEIGHT) dy*=-1;
        else if (y + (dy * speed) < 0) dy*=-1;

        Rectangle bounds = new Rectangle((int)(x + (dx*speed)), (int)(y + (dy*speed)), width, height);
        Rectangle boundsPlayer = new Rectangle(player.getX(), player.getY(),
                player.getWidth(), player.getHeight());
        Rectangle boundsEnemy = new Rectangle(enemy.getX(), enemy.getY(),
                enemy.getWidth(), enemy.getHeight());

        if (bounds.intersects(boundsPlayer)) {
            Sound.hitEff.play();
            int angle = new Random().nextInt(50);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dx < 0) dx *= -1;
        }
        else if (bounds.intersects(boundsEnemy)) {
            Sound.hitEff.play();
            int angle = new Random().nextInt(50);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dx > 0) dx *= -1;
        }

        x += dx*speed;
        y += dy*speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, width, height);
    }

    public void reset() {
        int angle = new Random().nextInt((120 - 45) + 46);
        int angle2 = new Random().nextInt(360);
        x = PongGame.WIDTH / 2;
        y = PongGame.HEIGHT / 2;
        dx = Math.cos(angle);
        dy = Math.sin(angle2);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
}
