package com.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Sprites {
 public int x,y,w,h,speed;
 ImageIcon imageIcon;
 public void draw(Graphics brush){
    brush.drawImage(imageIcon.getImage(), x, y,w,h, null);
 }
}
