package com.lab6.compulsory;

import com.lab6.compulsory.helpers.Line;
import com.lab6.compulsory.helpers.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Game {
    public int pointsCount;
    public boolean isNextRed = true;
    private List<Line> lines = new ArrayList<>();

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    public boolean isNextRed() {
        return isNextRed;
    }

    public void setNextRed(boolean nextRed) {
        isNextRed = nextRed;
    }
}
