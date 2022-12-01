package ru.vsu.cs.rmv;


import java.util.Scanner;

public class Main {

    public static double input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextDouble();
    }

    public static final Circle C1 = new Circle(2, 2, 5);
    public static final HorizontalParabola P1 = new HorizontalParabola(0, 3, -1);
    public static final HorizontalParabola P2 = new HorizontalParabola(3 , 1, -0.125);
    public static final ParabolaInverted P3 = new ParabolaInverted(-0.125, 0.25, -3.125);
    public static SimpleColor getColor(double x, double y){

        if (C1.isPointInCircle(x, y)){ // если в кругу
            if (P1.isPointInHorizontParabolaL(x, y)){ // в левой параболе
                return SimpleColor.GREEN;
            }
            if (P2.isPointInHorizontParabolaR(x, y)){ // в правой параболе
                return SimpleColor.YELLOW;
            }
            if (!P1.isPointInHorizontParabolaL(x, y) && !P2.isPointInHorizontParabolaR(x, y)){ // в кругу без парабол
                return SimpleColor.WHITE;
            }
        }

        else{ // если не в кругу
            if (P2.isPointInHorizontParabolaR(x, y) && P3.isPointInParabola(x, y)){ //в правой или перевернутой  параболе
                return SimpleColor.BLUE;
            }
            if (P1.isPointInHorizontParabolaL(x, y)){
                return SimpleColor.ORANGE;
            }
            if (P2.isPointInHorizontParabolaR(x, y) && y > 5.5){
                return SimpleColor.ORANGE;
            }
            if (P3.isPointInParabola(x, y)){
                return SimpleColor.BLUE;
            }
            if (!P1.isPointInHorizontParabolaL(x, y) && !P3.isPointInParabola(x, y) && (y < 1.1) && (x < 1.5)){
                return SimpleColor.GREEN;
            }
            if ((!P2.isPointInHorizontParabolaR(x,y)) && (!P3.isPointInParabola(x, y)) && (y < -2.2) && (x > 1.5)) {
                return SimpleColor.BLUE;
            }
            if((!P1.isPointInHorizontParabolaL(x, y)) && !P2.isPointInHorizontParabolaR(x, y) && y > 4.5){
                return SimpleColor.ORANGE;
            }
        }
        return SimpleColor.BLUE;
    }
    public static void tests(){
        System.out.println(getColor(-2, 3));// green
        System.out.println(getColor(-4, 2));// orange
        System.out.println(getColor(6, 8)); // orange
        System.out.println(getColor(4, 0)); // yellow
        System.out.println(getColor(0, 0)); // white
        System.out.println(getColor(8, 2)); // blue
        System.out.println(getColor(6, -5));//blue
        System.out.println(getColor(-2, -5));//blue
        System.out.println(getColor(0, -3)); //green

    }
    public static void main(String[] args){
        //tests();
        double x = input("x: ");
        double y = input("y: ");
        System.out.println(getColor(x, y));
    }
}
