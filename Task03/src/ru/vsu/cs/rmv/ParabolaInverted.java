package ru.vsu.cs.rmv;

/*
    y = ax^2 + bx + c
 */
public class ParabolaInverted {
    public double a;
    public double b;
    public double c;

    public ParabolaInverted(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointInParabola(double x, double y) {
        return y < a * Math.pow(x, 2) + b * x + c;
    }
}
