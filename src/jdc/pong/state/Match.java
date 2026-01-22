package jdc.pong.state;

import jdc.pong.PongGame;
import jdc.pong.entities.Ball;
import jdc.pong.entities.Enemy;
import jdc.pong.entities.Player;

import java.awt.*;

public class Match {

    private Player player;
    private Enemy enemy;
    private Ball ball;

    public Match() {
        player = new Player(0, PongGame.HEIGHT / 2);
        enemy = new Enemy(PongGame.WIDTH - 5, PongGame.HEIGHT / 2);
        ball = new Ball(100, PongGame.HEIGHT/2 -1, enemy, player);
        enemy.setBall(ball);
        PongGame.getInstance().getKeyboardCommands().setPlayer(player);
    }

    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }

    public void render(Graphics g) {
        player.render(g);
        enemy.render(g);
        ball.render(g);
    }
}
