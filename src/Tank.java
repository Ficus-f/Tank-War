import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    public static final int SPEED = 5;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                x -= Tank.SPEED;
                break;
            case KeyEvent.VK_UP:
                y -= Tank.SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                x += SPEED;
                break;
            case KeyEvent.VK_DOWN:
                y += SPEED;
                break;
        }
    }
}
