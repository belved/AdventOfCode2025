package tests;

import model.Day8.JunctionBox;
import model.Day8.JunctionBoxComputer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8Tests {
    
    @Test
    void testJunctionBoxConstructor() {
        JunctionBox junctionBox = new JunctionBox("162,817,812");

        Assertions.assertEquals(162, junctionBox.getPosition()[0]);
        Assertions.assertEquals(817, junctionBox.getPosition()[1]);
        Assertions.assertEquals(812, junctionBox.getPosition()[2]);
    }

    @Test
    void testComputeDistance() {
        JunctionBox junctionBox = new JunctionBox("162,817,812");
        JunctionBox junctionBox2 = new JunctionBox("57,618,57");
        
        Assertions.assertEquals(787.814, Math.round(junctionBox2.computeDistance(junctionBox)), 1);
        Assertions.assertEquals(0, Math.round(junctionBox.computeDistance(junctionBox)));
    }

    @Test
    void testComputeDistance2() {
        JunctionBox junctionBox = new JunctionBox("162,817,812");
        JunctionBox junctionBox2 = new JunctionBox("431,825,988");

        Assertions.assertEquals(321.56, Math.round(junctionBox2.computeDistance(junctionBox)), 1);
    }
    
    @Test
    void testFindLowestDistance() {
        JunctionBox junctionBox = new JunctionBox("162,817,812");
        JunctionBox junctionBox2 = new JunctionBox("57,618,57");
        JunctionBox junctionBox3 = new JunctionBox("431,825,988");
        
        List<JunctionBox> boxes = new ArrayList<>();
        boxes.add(junctionBox);
        boxes.add(junctionBox2);
        boxes.add(junctionBox3);
        
        JunctionBox nearest = null;
        double nearestDistance =  Double.MAX_VALUE;
        
        for(int i = 0; i < boxes.size()-1; i++) {
            for(int j = i+1; j < boxes.size(); j++) {
                double distance = boxes.get(i).computeDistance(boxes.get(j));
                if(distance < nearestDistance) {
                    nearestDistance = distance;
                    nearest = boxes.get(j);
                }
            }
        }
        
        Assertions.assertEquals(321.56, nearestDistance, 1);
        Assertions.assertNotNull(nearest);
        Assertions.assertEquals(junctionBox3, nearest);
    }
    
    @Test
    void testJunctionBoxComputerConstructor() {
        List<String> list = Arrays.asList("162,817,812", "57,618,57", "431,825,988");

        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);
        
        Assertions.assertNotNull(junctionBoxComputer);
        Assertions.assertEquals(3, junctionBoxComputer.getJunctionBoxes().size());
        Assertions.assertEquals(162, junctionBoxComputer.getJunctionBoxes().getFirst().getPosition()[0]);
        Assertions.assertEquals(817, junctionBoxComputer.getJunctionBoxes().getFirst().getPosition()[1]);
        Assertions.assertEquals(812, junctionBoxComputer.getJunctionBoxes().getFirst().getPosition()[2]);
    }
    
    @Test
    void testFindLowestDistanceWithComputer() {
        List<String> list = Arrays.asList("162,817,812", "57,618,57", "431,825,988");
        
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);
        
        Assertions.assertEquals(junctionBoxComputer.getJunctionBoxes().get(2), junctionBoxComputer.getMinimalDistance(0));
    }
    
    @Test
    void testComputeJunctionBox() {
        List<String> list = Arrays.asList("162,817,812", "57,618,57", "431,825,988");

        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);
        junctionBoxComputer.computeJunctionBoxes(1);
        
        Assertions.assertEquals(1, junctionBoxComputer.getCircuits().size());
        Assertions.assertEquals(2, junctionBoxComputer.getCircuits().getFirst().size());
        
        JunctionBox junctionBox = junctionBoxComputer.getJunctionBoxes().get(0);
        JunctionBox junctionBox2 = junctionBoxComputer.getJunctionBoxes().get(2);
        
        Assertions.assertTrue(junctionBoxComputer.getCircuits().getFirst().contains(junctionBox));
        Assertions.assertTrue(junctionBoxComputer.getCircuits().getFirst().contains(junctionBox2));
    }

    @Test
    void testComputeJunctionBoxWithTwoValues() {
        List<String> list = Arrays.asList("162,817,812", "57,618,57", "431,825,988");

        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);
        junctionBoxComputer.computeJunctionBoxes(2);

        Assertions.assertEquals(1, junctionBoxComputer.getCircuits().size());
        Assertions.assertEquals(1, junctionBoxComputer.getNumberOfConnection());
        Assertions.assertEquals(3, junctionBoxComputer.getCircuits().getFirst().size());

        JunctionBox junctionBox0 = junctionBoxComputer.getJunctionBoxes().get(0);
        JunctionBox junctionBox1 = junctionBoxComputer.getJunctionBoxes().get(1);
        JunctionBox junctionBox2 = junctionBoxComputer.getJunctionBoxes().get(2);

        Assertions.assertTrue(junctionBoxComputer.getCircuits().getFirst().contains(junctionBox0));
        Assertions.assertTrue(junctionBoxComputer.getCircuits().getFirst().contains(junctionBox1));
        Assertions.assertTrue(junctionBoxComputer.getCircuits().getFirst().contains(junctionBox2));
    }

    static List<String> list = new ArrayList<>();
    static List<String> listSlightlyModified = new ArrayList<>();
    
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
        
        listSlightlyModified.add("57,618,57");
        listSlightlyModified.add("906,360,560");
        listSlightlyModified.add("592,479,940");
        listSlightlyModified.add("162,817,812");
        listSlightlyModified.add("352,342,300");
        listSlightlyModified.add("466,668,158");
        listSlightlyModified.add("542,29,236");
        listSlightlyModified.add("431,825,988");
        listSlightlyModified.add("739,650,466");
        listSlightlyModified.add("52,470,668");
        listSlightlyModified.add("216,146,977");
        listSlightlyModified.add("819,987,18");
        listSlightlyModified.add("117,168,530");
        listSlightlyModified.add("805,96,715");
        listSlightlyModified.add("346,949,466");
        listSlightlyModified.add("970,615,88");
        listSlightlyModified.add("941,993,340");
        listSlightlyModified.add("862,61,35");
        listSlightlyModified.add("984,92,344");
        listSlightlyModified.add("425,690,689");
    }
    
    @Test
    void tryToGetTheJunctionBoxWithLowestDistance() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(listSlightlyModified);
        
        JunctionBox[] values = junctionBoxComputer.getLowestDistances();
        
        Assertions.assertNotNull(values[0]);
        Assertions.assertNotNull(values[1]);
        
        Assertions.assertEquals(162, values[0].getPosition()[0]);
        Assertions.assertEquals(817, values[0].getPosition()[1]);
        Assertions.assertEquals(812, values[0].getPosition()[2]);

        Assertions.assertEquals(425, values[1].getPosition()[0]);
        Assertions.assertEquals(690, values[1].getPosition()[1]);
        Assertions.assertEquals(689, values[1].getPosition()[2]);
    }

    @Test
    void tryToGetTheSecondJunctionBoxWithLowestDistance() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(listSlightlyModified);

        JunctionBox[] values = junctionBoxComputer.getLowestDistances();
        
        values[0].setCircuitNumber(0);
        values[0].setConnected(true);
        values[1].setCircuitNumber(0);
        
        values = junctionBoxComputer.getLowestDistances();

        Assertions.assertNotNull(values[0]);
        Assertions.assertNotNull(values[1]);

        Assertions.assertEquals(162, values[1].getPosition()[0]);
        Assertions.assertEquals(817, values[1].getPosition()[1]);
        Assertions.assertEquals(812, values[1].getPosition()[2]);

        Assertions.assertEquals(431, values[0].getPosition()[0]);
        Assertions.assertEquals(825, values[0].getPosition()[1]);
        Assertions.assertEquals(988, values[0].getPosition()[2]);
    }

    @Test
    void tryToCheckTwoFirstElements() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);

        junctionBoxComputer.computeJunctionBoxes(1);

        Assertions.assertEquals(19, junctionBoxComputer.getNumberOfConnection());
    }

    @Test
    void tryToCheckThreeFirstElements() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);

        junctionBoxComputer.computeJunctionBoxes(2);

        Assertions.assertEquals(18, junctionBoxComputer.getNumberOfConnection());
    }

    @Test
    void tryToCheckFiveFirstElements() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);

        junctionBoxComputer.computeJunctionBoxes(3);

        Assertions.assertEquals(17, junctionBoxComputer.getNumberOfConnection());
        Assertions.assertEquals(2, junctionBoxComputer.getCircuits().size());
        Assertions.assertEquals(3, junctionBoxComputer.getCircuits().get(0).size());
        Assertions.assertEquals(2, junctionBoxComputer.getCircuits().get(1).size());
    }

    @Test
    void tryToCheckFourLoopElements() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);

        junctionBoxComputer.computeJunctionBoxes(4);

        Assertions.assertEquals(17, junctionBoxComputer.getNumberOfConnection());
        Assertions.assertEquals(2, junctionBoxComputer.getCircuits().size());
        Assertions.assertEquals(3, junctionBoxComputer.getCircuits().get(0).size());
        Assertions.assertEquals(2, junctionBoxComputer.getCircuits().get(1).size());
    }
    
    @Test
    void tryToCheckTenFirstElements() {
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);

        junctionBoxComputer.computeJunctionBoxes(10);
        
        Assertions.assertEquals(11, junctionBoxComputer.getNumberOfConnection());
    }
    
    @Test
    void test() {
        JunctionBox jb = new JunctionBox("425,690,689");
        
        JunctionBoxComputer junctionBoxComputer = new JunctionBoxComputer(list);
        
        List<JunctionBox> l = junctionBoxComputer.getJunctionBoxes();
        
        double min = Double.MAX_VALUE;
        int pos = 0;
        
        for(JunctionBox box : l) {
            double d = jb.computeDistance(box);
            if(d < min && d != 0) {
                min = d;
                pos = box.getPosition()[0];
            }
        }

        System.out.println(pos + " - " + min);
    }
}
