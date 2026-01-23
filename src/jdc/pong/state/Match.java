package jdc.pong.state;

import jdc.pong.PongGame;
import jdc.pong.entities.Ball;
import jdc.pong.entities.Enemy;
import jdc.pong.entities.Player;
import jdc.pong.sound.Sound;

import java.awt.*;

public class Match {

    private Player player;
    private Enemy enemy;
    private Ball ball;

    private static int playerPoints;
    private static int enemyPoints;

    public Match() {
        //Sound.menu.stop();
        //Sound.match.loop();
        player = new Player(0, PongGame.HEIGHT / 2);
        enemy = new Enemy(PongGame.WIDTH - 5, PongGame.HEIGHT / 2);
        ball = new Ball(enemy, player);
        enemy.setBall(ball);
        PongGame.getInstance().getKeyboardCommands().setPlayer(player);
    }

    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();

        if (ball.getX() >= PongGame.WIDTH) {
            playerPoints++;
            ball.reset();
            Sound.bell.play();
        }
        else if (ball.getX() < 0) {
            enemyPoints++;
            ball.reset();
            Sound.bell.play();
        }
    }

    public void render(Graphics g) {
        player.render(g);
        enemy.render(g);
        ball.render(g);

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 15));
        g.drawString("P:" + playerPoints, PongGame.WIDTH / 2 - 30, 20);
        g.drawString("E:" + enemyPoints, PongGame.WIDTH / 2 + 10, 20);
    }
}
