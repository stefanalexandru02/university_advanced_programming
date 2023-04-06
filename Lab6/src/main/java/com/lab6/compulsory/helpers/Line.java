package com.lab6.compulsory.helpers;

/**
 * @author Virna Stefan Alexandru
 */
public class Line {
    private Point p1;
    private Point p2;

    private boolean isColored = false;
    private boolean isRed;

    public Line() { }
    public Line(Point _p1, Point _p2){
        p1 = _p1;
        p2 = _p2;
    }

    public boolean HasPoint(Point p)
    {
        if(p1.getY() == p.getY() && p1.getX() == p.getX()) return true;
        if(p2.getY() == p.getY() && p2.getX() == p.getX()) return true;
        return false;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColored(boolean colored) {
        isColored = colored;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
