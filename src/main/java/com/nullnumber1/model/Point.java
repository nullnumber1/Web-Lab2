package com.nullnumber1.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Point implements Comparable<Point> {
    private final double x;
    private final double y;
    private final double r;
    private boolean result;
    private boolean valid;
    private String time;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.valid = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }
    public void setTime(){
        this.time = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public int compareTo(Point o) {
        return o.getTime().compareTo(time);
    }
}
