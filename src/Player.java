import java.awt.*;

public class Player {

    public boolean right, left;
    public int x,y;
    public int width, height;
    public int speed = 2;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    public void tick() {
        if (right) x+=speed;
        else if (left) x-=speed;

        if (x + width > PongGame.WIDTH) x = PongGame.WIDTH - width;
        else if (x < 0) x = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 10);
    }
}
