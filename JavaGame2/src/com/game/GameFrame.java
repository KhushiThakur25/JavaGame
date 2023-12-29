package com.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("JAVA GAME");
        add(new GameBoard());
        setVisible(true);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }
}