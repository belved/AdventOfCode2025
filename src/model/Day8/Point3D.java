package model.Day8;

public class Point3D {
    
    private final int[] position = new int[3];
    private final String label;
    
    public Point3D(String position) {
        label = position;
        
        String[] positionString = position.split(",");

        this.position[0] = Integer.parseInt(positionString[0]);
        this.position[1] = Integer.parseInt(positionString[1]);
        this.position[2] = Integer.parseInt(positionString[2]);
    }

    public String getLabel() {
        return label;
    }
    
    public int[] getPosition() {
        return position;
    }

    public double computeDistance(Point3D point) {
        long firstBraket = point.getPosition()[0] - this.position[0];
        long secondBraket = point.getPosition()[1] - this.position[1];
        long thirdBraket = point.getPosition()[2] - this.position[2];

        firstBraket *= firstBraket;
        secondBraket *= secondBraket;
        thirdBraket *= thirdBraket;

        return Math.sqrt(firstBraket + secondBraket + thirdBraket);
    }
}
