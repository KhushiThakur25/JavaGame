package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sprites.Enemy;
import com.sprites.Player;

public class GameBoard extends JPanel {
    Timer timer;
    Player player;
    BufferedImage bgImage;
    Enemy enemies[] = new Enemy[4];

    public GameBoard() {
        showGameBgImage();
        player = new Player();
        loadEnemies();
        gameLoop();
        setFocusable(true);
        bindEvents();
    }

    private void bindEvents() {
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                player.speed = 0;
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.speed = 3;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.speed = -3;
                }
            }
        });
    }

    private void loadEnemies() {
        int initialLocation = 600;
        int gap = 300;
        int speed = 3;
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(initialLocation, speed);
            initialLocation += gap;
            speed += 3;
        }
    }

    private void paintEnemies(Graphics brush) {
        for (Enemy enemy : enemies) {
            enemy.draw(brush);
            enemy.movement();
        }
    }

    private void gameLoop() {
        timer = new Timer(30, (e) -> repaint());
        timer.start();
    }

    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        brush.drawImage(bgImage, 0, 0, 1500, 800, null);
        player.draw(brush);
        player.movement();
        paintEnemies(brush);
        gameOver(brush);
    }

    public void showGameBgImage() {
        URL imageUrl = GameBoard.class.getResource("game_bg.png");
        try {
            bgImage = ImageIO.read((imageUrl));
        } catch (IOException e) {
            System.out.println("Image not found..");
        }
    }

    private void gameOver(Graphics brush) {
        for (Enemy enemy : enemies) {
            if (isCollide(enemy)) {
                brush.setFont(new Font("times", Font.BOLD, 50));
                brush.setColor(Color.RED);
                brush.drawString("GAME OVER!!", 1500 / 3, 800 / 4);
                timer.stop();
            }
        }
    }

    private boolean isCollide(Enemy enemy) {
        int xDist = Math.abs(player.x - enemy.x);
        int yDist = Math.abs(player.y - enemy.y);
        int maxH = Math.max(player.h, enemy.h);
        int maxW = Math.max(player.w, enemy.w);

        return xDist <= maxH && yDist <= maxW;
    }

    public static void main(String[] args) {

    }
}
