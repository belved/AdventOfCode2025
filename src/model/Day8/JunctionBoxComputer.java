package model.Day8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JunctionBoxComputer {
    
    List<JunctionBox> junctionBoxes = new ArrayList<>();
    List<Set<JunctionBox>> circuits = new ArrayList<>();
    
    public JunctionBoxComputer(List<String> junctionBoxes) {
        for(String junctionBox : junctionBoxes){
            this.junctionBoxes.add(new JunctionBox(junctionBox));
        }
    }
    
    private int counter = 0;

    public void computeJunctionBoxes(int count){
        for(int i = 0; i < count; i++ ){
            JunctionBox[] values = getLowestDistances();
            
            if(values[1].getCircuitNumber() != -1) {
                values[0].setCircuitNumber(values[1].getCircuitNumber());
                circuits.get(values[1].getCircuitNumber()).add(values[0]);
            } else {
                values[0].setCircuitNumber(counter);
                values[1].setCircuitNumber(counter);
                
                circuits.add(new HashSet<>());
                
                Set<JunctionBox> junctionBoxesSet = circuits.get(counter);
                
                junctionBoxesSet.add(values[0]);
                junctionBoxesSet.add(values[1]);
                
                counter++;
            }
        }
    }
    
    public JunctionBox[] getLowestDistances() {
        JunctionBox[] lowest = new JunctionBox[2];
        double nearestDistance = Double.MAX_VALUE;
        
        for(int i = 0; i < junctionBoxes.size(); i++) {
            if(!junctionBoxes.get(i).isConnected()){
                JunctionBox junctionBoxFound = getMinimalDistance(i);
                double distance = junctionBoxFound.computeDistance(junctionBoxes.get(i));
                if(distance < nearestDistance) {
                    lowest[0] = junctionBoxes.get(i);
                    lowest[1] = junctionBoxFound;

                    lowest[1].setConnected(true);
                    
                    nearestDistance = distance;
                }
            }
        }
        
        lowest[0].setConnected(true);
        
        return lowest;
    }
    
    public JunctionBox getMinimalDistance(int i) {
        JunctionBox nearest = null;
        JunctionBox currentJunctionBox = junctionBoxes.get(i);
        double nearestDistance =  Double.MAX_VALUE;

        for(int j = 0; j < junctionBoxes.size(); j++) {
            double distance = currentJunctionBox.computeDistance(junctionBoxes.get(j));
            if(distance < nearestDistance && distance != 0) {
                nearestDistance = distance;
                nearest = junctionBoxes.get(j);
            }
        }
        
        return nearest;
    }
    
    public List<JunctionBox> getJunctionBoxes() {
        return junctionBoxes;
    }
    
    public List<Set<JunctionBox>> getCircuits() {
        return circuits;
    }
    
    public int getNumberOfConnection() {
        int size = circuits.size();
        for(JunctionBox junctionBox : junctionBoxes){
            if(junctionBox.getCircuitNumber() == -1) size ++;
        }
        return size;
    }
}
