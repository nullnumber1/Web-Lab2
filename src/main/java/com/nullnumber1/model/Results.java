package com.nullnumber1.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private ArrayDeque<Point> pointDeque;

    public Results() {
        pointDeque = new ArrayDeque<>();
    }

    public void add(Point point) {
        pointDeque.addLast(point);
    }

    public void nullResults() {
        pointDeque = null;
    }

    public List<Point> getPoints() {
        return pointDeque.stream().sorted(Point::compareTo).collect(Collectors.toList());
    }
}

