package ru.vsu.cs.rmv;

/*
    Горизонтальная парабола вида x = a * (y - y0)^2 + x0
 */

public class HorizontalParabola {
    public double x0;
    public double y0;
    public double a;

    public HorizontalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    /*
    Проверяет, находится ли точка (x, y) справа
    (сверху, если повернуть изображение
    на 90 градусов против часовой стрелки) от параболы
     */

    public boolean isPointInHorizontParabolaL(double x, double y) {
        return x < a * Math.pow(y - y0, 2) + x0;
    }
    public boolean isPointInHorizontParabolaR(double x, double y) {
        return x > a * Math.pow(y - y0, 2) + x0;
    }
}