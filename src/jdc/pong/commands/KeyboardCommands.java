package jdc.pong.commands;

import jdc.pong.PongGame;
import jdc.pong.entities.Player;
import jdc.pong.state.GameState;
import jdc.pong.state.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardCommands implements KeyListener {

    private Player player;
    private Menu menu;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (PongGame.GAME_STATE.equals(GameState.MENU)) {
            if (e.getKeyCode() == KeyEvent.VK_UP) menu.setUp(true);
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) menu.setDown(true);
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) menu.setEnter(true);
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP) player.setUp(true);
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) player.setDown(true);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (PongGame.GAME_STATE.equals(GameState.MENU)) {
            if (e.getKeyCode() == KeyEvent.VK_UP) menu.setUp(false);
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) menu.setDown(false);
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) menu.setEnter(false);
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP) player.setUp(false);
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) player.setDown(false);
        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
