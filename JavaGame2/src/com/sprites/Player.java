package com.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprites{
    public Player(){
        w = 200;
        h = 200;
        x = 100;
        y = 500;
        imageIcon = new ImageIcon(Player.class.getResource("dude.png"));
    }
    

    public void movement() {
        x = x + speed;
    }
    
}
