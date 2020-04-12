import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private int x = 100;
    private int y = 100;
    public static final int SPEED = 5;

    public TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    x -= SPEED;
                    break;
                case KeyEvent.VK_UP:
                    y -= SPEED;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += SPEED;
                    break;
                case KeyEvent.VK_DOWN:
                    y += SPEED;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
