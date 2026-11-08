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

    public long getBiggestDistancePart2() {
        long biggestSize = 0;

        for(int i = 0; i < points.size(); i++) {
            for(int j = i + 1; j < points.size(); j++) {
                if(rectangleIsValid(points.get(i), points.get(j))) {
                    long size = computeSize(points.get(i), points.get(j));
                    if(size > biggestSize) {
                        biggestSize = size;
                    }
                }
            }
        }

        return biggestSize;
    }
    
    /*
    * A valid rectangle is a rectangle without no other point inside
    * If a point is INSIDE de rectangle then the rectangle isn't valid.
    * If a point is on the same row/line... Here start de troubles...
    * 
    * The method works ! Ans you know what ? It's too slow for real input...
    * Should check this : https://www.reddit.com/r/adventofcode/comments/1pi3hff/2025_day_9_part_2_a_simple_method_spoiler/
    */
    public boolean rectangleIsValid(Point2D p1, Point2D p2) {
        int minX = Math.min(p1.getCoordinates()[0], p2.getCoordinates()[0]);
        int minY = Math.min(p1.getCoordinates()[1], p2.getCoordinates()[1]);

        int maxX = Math.max(p1.getCoordinates()[0], p2.getCoordinates()[0]);
        int maxY = Math.max(p1.getCoordinates()[1], p2.getCoordinates()[1]);
        
        for(int x = minX; x <= maxX; x++) {
            for(int y = minY; y <= maxY; y++) {
                Point2D p = new Point2D(x-1, y-1);
                if(points.contains(p) && !p.equals(p1) && !p.equals(p2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public List<Point2D> getPoints() {
        return points;
    }
}
