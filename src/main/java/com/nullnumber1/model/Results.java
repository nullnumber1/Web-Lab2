package com.nullnumber1.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final Deque<Point> pointDeque;

    public Results() {
        pointDeque = new ArrayDeque<>();
    }

    public void add(Point point) {
        int MAX_SIZE = 10;
        if (pointDeque.size() > MAX_SIZE)
            pointDeque.pollFirst();
        pointDeque.addLast(point);
    }

    public List<Point> getPoints() {
        return pointDeque.stream().sorted(Point::compareTo).collect(Collectors.toList());
    }
}

