package ru.vsu.cs.Game;

// Демонстрация работы цветов в Java

import java.awt.*;


public class Colors{

    public static Color c2;
    public static Color c4;
    public static Color c8;
    public static Color c16;
    public static Color c32;
    public static Color c64;
    public static Color c128;
    public static Color c256;
    public static Color c512;
    public static Color c1024;
    public static Color c2048;

    public static Color getC2(){
        return new Color(238, 201, 165);
    }
    public static Color getC4(){
        return new Color(229, 175, 121);
    }
    public static Color getC8(){
        return new Color(221, 152, 83);
    }
    public static Color getC16(){
        return new Color(214, 132, 50);
    }
    public static Color getC32(){
        return new Color(192, 115, 38);
    }
    public static Color getC64(){
        return new Color(167, 100, 33);
    }

    public static Color getC128(){
        return new Color(142, 85, 28);
    }
    public static Color getC256(){
        return new Color(121, 72, 24);
    }
    public static Color getC512(){
        return new Color(103, 61, 20);
    }
    public static Color getC1024(){
        return new Color(88, 52, 17);
    }
    public static Color getC2048(){
        return new Color(75, 44, 14);
    }

    public void paint(Graphics g) {
        Color c2 = new Color(238, 201, 165);
        Color c4 = new Color(229, 175, 121);
        Color c8 = new Color(221, 152, 83);
        Color c16 = new Color(214, 132, 50);
        Color c32 = new Color(192, 115, 38);
        Color c64 = new Color(167, 100, 33);
        Color c128 = new Color(142, 85, 28);
        Color c256 = new Color(121, 72, 24);
        Color c512 = new Color(103, 61, 20);
        Color c1024 = new Color(88, 52, 17);
        Color c2048 = new Color(75, 44, 14);

    }

}
