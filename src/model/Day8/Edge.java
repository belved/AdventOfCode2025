package model.Day8;

public class Edge implements Comparable<Edge> {

    private final double weight;
    private final int i;
    private final int j;
    
    public Edge(int i, int j, double weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }

    public int getI() {
        return i;
    }
    
    public int getJ() {
        return j;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.getWeight());
    }
}
