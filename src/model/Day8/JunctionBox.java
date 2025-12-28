package model.Day8;

public class JunctionBox {
    
    private final int[] position = new int[3];
    private int circuitNumber = -1;
    
    private boolean isConnected = false;
    
    public JunctionBox(String position) {
        String[] positionString = position.split(",");
        
        this.position[0] = Integer.parseInt(positionString[0]);
        this.position[1] = Integer.parseInt(positionString[1]);
        this.position[2] = Integer.parseInt(positionString[2]);
    }
    
    public int[] getPosition() {
        return position;
    }
    
    public double computeDistance(JunctionBox junctionBox) {
        long firstBraket = junctionBox.getPosition()[0] - this.getPosition()[0];
        long secondBraket = junctionBox.getPosition()[1] - this.getPosition()[1];
        long thirdBraket = junctionBox.getPosition()[2] - this.getPosition()[2];
        
        firstBraket *= firstBraket;
        secondBraket *= secondBraket;
        thirdBraket *= thirdBraket;
        
        return Math.sqrt(firstBraket + secondBraket + thirdBraket);
    }

    public int getCircuitNumber() {
        return circuitNumber;
    }

    public void setCircuitNumber(int circuitNumber) {
        this.circuitNumber = circuitNumber;
    }
    
    public boolean isConnected() {
        return isConnected;
    }
    
    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
