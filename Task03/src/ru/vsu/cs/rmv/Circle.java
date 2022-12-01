package ru.vsu.cs.rmv;

/*
    График окружности
    (x - x0)^2 + (y - y0)^2 = r^2
 */


public class Circle {
    public double x0;
    public double y0;
    public double r;

    public Circle(double x0, double y0, double r){
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean isPointInCircle(double x, double y){ // точка внутри круга - true
        return Math.pow(x - x0, 2) + Math.pow(y - y0, 2) <= Math.pow(r, 2);
    }
}
