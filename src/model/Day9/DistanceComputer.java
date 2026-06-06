package model.Day9;

import java.util.ArrayList;
import java.util.List;

public class DistanceComputer {
    
    private final List<Point2D> points = new ArrayList<>();
    
    public DistanceComputer(List<String> point) {
        for(String p : point) {
            this.points.add(new Point2D(p));
        }
    }
    
    public long computeSize(Point2D p1, Point2D p2) {
        
        long width = Math.abs(p1.getCoordinates()[0] - p2.getCoordinates()[0])+1;
        
        long height = Math.abs(p1.getCoordinates()[1] - p2.getCoordinates()[1])+1;
        
        return width*height;
    }
    
    public long getBiggestDistance() {
        long biggestSize = 0;
        
        for(int i = 0; i < points.size(); i++) {
            for(int j = i + 1; j < points.size(); j++) {
                long size = computeSize(points.get(i), points.get(j));
                if(size > biggestSize) {
                    biggestSize = size;
                }
            }
        }
        
        return biggestSize;
    }
    
    public List<Point2D> getPoints() {
        return points;
    }
}
