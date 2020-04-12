import java.awt.*;

public class TankFrame extends Frame {
    private int x = 100;
    private int y = 100;

    public TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        x++;
    }
}
