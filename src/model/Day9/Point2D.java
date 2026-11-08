package model.Day9;

import java.util.Arrays;

public class Point2D {
    
    private final int x;
    private final int y;
    
    public Point2D(String s) {
        String[] data = s.split(",");
        this.x = Integer.parseInt(data[0]);
        this.y = Integer.parseInt(data[1]);
    }
    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int[] getCoordinates() {
        return new int[]{x, y};
    }
    
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    public double computeDistance(Point2D p) {

        long firstBraket = p.getCoordinates()[0] - this.getCoordinates()[0];
        long secondBraket = p.getCoordinates()[1] - this.getCoordinates()[1];

        firstBraket *= firstBraket;
        secondBraket *= secondBraket;

        return Math.sqrt(firstBraket + secondBraket);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Point2D) {
            return this.x == ((Point2D)o).x && this.y == ((Point2D)o).y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.toString().toCharArray());
    }
}
