package com.lab6.compulsory.helpers;

import javafx.util.Pair;

/**
 * @author Virna Stefan Alexandru
 */
public class Point {
    private double X;
    private double Y;

    private int pointIndex;

    public Point() { }

    public Point(double _x, double _y, int _index)
    {
        X = _x;
        Y = _y;
        pointIndex = _index;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setPointIndex(int pointIndex) {
        this.pointIndex = pointIndex;
    }

    public int getPointIndex() {
        return pointIndex;
    }

    public Pair<Double, Double> asPair(){
        return new Pair<>(X, Y);
    }
}
