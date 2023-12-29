package com.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprites{

    public Enemy(int x,int speed){
        w = 200;
        h = 200;
        this.x = x;
        y = 80;
        this.speed = speed;
        imageIcon = new ImageIcon(Player.class.getResource("Flying_bat.webp"));
    }

    public void movement() {
        if(y > 800){
            y = 0;
        }
        y = y + speed;
    }
    
}
