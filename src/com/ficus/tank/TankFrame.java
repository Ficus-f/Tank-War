package com.ficus.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();

    private Tank myTank;
    private Tank enemy;
    private Bullet bullet;

    private List<Bullet> bullets;

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    private TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);

        this.addKeyListener(new TankKeyListener());

        myTank = new Tank(100, 100, Dir.R, Group.GOOD);
        enemy = new Tank(200, 200, Dir.D, Group.BAD);
        bullets = new ArrayList<Bullet>();
    }

    public void add(Bullet bullet) {
        bullets.add(bullet);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        enemy.paint(g);

        for (int i=0; i<bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }
}
