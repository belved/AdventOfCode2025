package tests;

import model.Day8.Edge;
import model.Day8.Kruskal;
import model.Day8.Point3D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Day8Tests {

    static List<String> list = new ArrayList<>();
    
    @BeforeAll
    static void createDataSetForTest() {
        list.add("162,817,812");
        list.add("57,618,57");
        list.add("906,360,560");
        list.add("592,479,940");
        list.add("352,342,300");
        list.add("466,668,158");
        list.add("542,29,236");
        list.add("431,825,988");
        list.add("739,650,466");
        list.add("52,470,668");
        list.add("216,146,977");
        list.add("819,987,18");
        list.add("117,168,530");
        list.add("805,96,715");
        list.add("346,949,466");
        list.add("970,615,88");
        list.add("941,993,340");
        list.add("862,61,35");
        list.add("984,92,344");
        list.add("425,690,689");
    }
    
    @Test
    void testPoint3D() {
        Point3D point = new Point3D("162,817,812");
        
        Assertions.assertEquals("162,817,812", point.getLabel());
        Assertions.assertEquals(3, point.getPosition().length);
        Assertions.assertEquals(162, point.getPosition()[0]);
        Assertions.assertEquals(817, point.getPosition()[1]);
        Assertions.assertEquals(812, point.getPosition()[2]);
    }

    @Test
    void testComputeDistance() {
        Point3D point = new Point3D("162,817,812");
        Point3D point2 = new Point3D("57,618,57");

        Assertions.assertEquals(787.814, Math.round(point2.computeDistance(point)), 1);
        Assertions.assertEquals(0, Math.round(point.computeDistance(point)));
    }
    
    @Test
    void testEdge() {
        Point3D point = new Point3D("162,817,812");
        Point3D point2 = new Point3D("57,618,57");
        
        Edge edge = new Edge(1, 2, point.computeDistance(point2));
        
        Assertions.assertEquals(787.814, Math.round(edge.getWeight()), 1);
        Assertions.assertEquals(1, edge.getI());
        Assertions.assertEquals(2, edge.getJ());
    }
    
    @Test
    void testKruskalPoints() {
        Kruskal k = new Kruskal(list);
        
        Assertions.assertEquals(list.size(), k.getPoints().size());
    }
    
    @Test
    void testKruskalEdge() {
        Kruskal k = new Kruskal(list);
        
        Assertions.assertEquals(190, k.getEdges().size());
        Assertions.assertEquals(787.814, Math.round(k.getEdges().getFirst().getWeight()), 1);
    }
    
    @Test
    void testKruskalSort() {
        Kruskal k = new Kruskal(list);
        
        k.computeKruskal(10);

        Assertions.assertEquals(316.902193, Math.round(k.getEdges().getFirst().getWeight()), 1);
        Assertions.assertEquals(0, k.getEdges().getFirst().getI());
        Assertions.assertEquals(19, k.getEdges().getFirst().getJ());
        
        Assertions.assertEquals(321.560259, Math.round(k.getEdges().get(1).getWeight()), 1);
        Assertions.assertEquals(0, k.getEdges().get(1).getI());
        Assertions.assertEquals(7, k.getEdges().get(1).getJ());
    }
    
    @Test
    void testKruskalCompute() {
        Kruskal k = new Kruskal(list);
        
        int i = k.computeKruskal(10);
        
        Assertions.assertEquals(11, k.getMst().size());
        Assertions.assertEquals(5, k.getMst().get(0));
        Assertions.assertEquals(4, k.getMst().get(1));
        Assertions.assertEquals(2, k.getMst().get(2));
        
        Assertions.assertEquals(40, i);
    }
    
    @Test
    void testLastPointKruskal() {
        Kruskal k = new Kruskal(list);
        
        int i = k.computeLastKruskal();
        
        Assertions.assertEquals(25272, i);
    }
}