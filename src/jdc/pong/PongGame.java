package jdc.pong;

import jdc.pong.commands.KeyboardCommands;
import jdc.pong.sound.Sound;
import jdc.pong.state.GameState;
import jdc.pong.state.Match;
import jdc.pong.state.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PongGame extends Canvas implements Runnable {

    public static final int WIDTH = 230;
    public static final int HEIGHT = 130;
    public static final int SCALE = 3;

    public static GameState GAME_STATE = GameState.MENU;
    public static Random random = new Random();

    private static PongGame instance = null;
    private BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final KeyboardCommands keyboardCommands = new KeyboardCommands();
    private Menu menu;
    private Match match;

    private PongGame() {
        menu = new Menu();
        this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        keyboardCommands.setMenu(menu);
        this.addKeyListener(keyboardCommands);
    }

    public static PongGame getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        //Sound.menu.play();
        instance = new PongGame();
        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(instance);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        new Thread(instance).start();

    }

    public void tick() {
        if (GAME_STATE.equals(GameState.MENU)) {
            menu.tick();
        } else if (match != null) {
            match.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (GAME_STATE.equals(GameState.MENU)) {
            menu.render(g);
        } else if (match != null) {
            match.render(g);
        }

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
        while(true) {
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public KeyboardCommands getKeyboardCommands() {
        return keyboardCommands;
    }
}