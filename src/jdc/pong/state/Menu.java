package jdc.pong.state;

import jdc.pong.PongGame;

import java.awt.*;

public class Menu {

    private String[] options = {"Novo Jogo", "Sair"};

    private int currentOption = 0;
    private int maxOptions = options.length - 1;

    private boolean up, down, enter;

    public void tick() {

        if (up) {
            up = false;
            currentOption--;
            if (currentOption < 0) currentOption = maxOptions;
        }

        if (down) {
            down = false;
            currentOption++;
            if (currentOption > maxOptions) currentOption = 0;
        }

        if (enter) {
            enter = false;
            if (options[currentOption].equals("Novo Jogo")) {
                PongGame.GAME_STATE = GameState.MATCH;
                PongGame.getInstance().setMatch(new Match());
            }
            else if (options[currentOption].equals("Sair")) System.exit(0);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 18));
        g.drawString("Pong", PongGame.WIDTH / 2 - 20, 45);

        g.setFont(new Font("arial", Font.BOLD, 10));
        g.drawString("Novo Jogo", PongGame.WIDTH / 2 - 20, 65);
        g.drawString("Sair", PongGame.WIDTH / 2 - 20, 80);

        if (options[currentOption].equals("Novo Jogo")) {
            g.drawString(">", PongGame.WIDTH / 2 - 30, 65);
        } else if (options[currentOption].equals("Sair")) {
            g.drawString(">", PongGame.WIDTH / 2 - 30, 80);
        }
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

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }
}
