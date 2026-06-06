package tests;

import model.Day9.DistanceComputer;
import model.Day9.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Day9Tests {
    
    static List<String> data = new ArrayList<>();
    
    @BeforeAll
    static void beforeAll() {
        data.add("7,1");
        data.add("11,1");
        data.add("11,7");
        data.add("9,7");
        data.add("9,5");
        data.add("2,5");
        data.add("2,3");
        data.add("7,3");
    }
    
    @Test
    void testPoint2DGetCoordinates() {
        Point2D point = new Point2D("7,1");

        Assertions.assertEquals(2, point.getCoordinates().length);
        Assertions.assertEquals(7, point.getCoordinates()[0]);
        Assertions.assertEquals(1, point.getCoordinates()[1]);
    }
    
    @Test
    void testPoint2DComputeDistance() {
        Point2D point = new Point2D("7,1");
        Point2D point2 = new Point2D("11,1");
        
        double result = point.computeDistance(point2);
        
        Assertions.assertEquals(4, result);
    }
    
    @Test
    void testDistanceComputerConstructor() {
        DistanceComputer distanceComputer = new DistanceComputer(data);
        
        Assertions.assertEquals(8, distanceComputer.getPoints().size());
        Assertions.assertEquals(2, distanceComputer.getPoints().getFirst().getCoordinates().length);
        Assertions.assertEquals(7, distanceComputer.getPoints().getFirst().getCoordinates()[0]);
        Assertions.assertEquals(1, distanceComputer.getPoints().getFirst().getCoordinates()[1]);
    }
    
    @Test
    void testDistanceComputerConstructor2() {
        DistanceComputer distanceComputer = new DistanceComputer(data);
        
        long distance = distanceComputer.getBiggestDistance();
        
        Assertions.assertEquals(50, distance);
    }
}
