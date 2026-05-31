package model.Day8;

import java.util.*;

public class Kruskal {
    
    private final List<Point3D> points = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();
    private final List<Integer> mst = new ArrayList<>();
    
    public Kruskal(List<String> data) {
        for(String str : data){
            points.add(new Point3D(str));
        }
        computeAllEdges();
    }
    
    public int computeKruskal(int numberOfIterations) {
        sortEdges();
        
        UnionFind uf = new UnionFind(points.size());
        
        for(int i = 0; i < numberOfIterations; i++){
            uf.union(edges.get(i).getI(), edges.get(i).getJ());
        }
        
        Map<Integer, Integer> circuitSize = new HashMap<>();
        for(int i = 0; i < points.size(); i++){
            int parent = uf.find(i);
            circuitSize.put(parent, uf.getSize(parent));
        }

        mst.addAll(circuitSize.values());

        mst.sort(Collections.reverseOrder());
        
        return mst.get(0) * mst.get(1) * mst.get(2);
    }
    
    public List<Integer> getMst(){
        return mst;
    }
    
    private void sortEdges(){
        Collections.sort(edges);
    }
    
    private void computeAllEdges() {
        for(int i = 0; i < points.size(); i++){
            for(int j = i + 1; j < points.size(); j++){
                if(points.get(i) != points.get(j)){
                    edges.add(new Edge(i, j, points.get(i).computeDistance(points.get(j))));
                }
            }
        }
    }
    
    public List<Point3D> getPoints() {
        return points;
    }
    
    public List<Edge> getEdges() {
        return edges;
    }
}
