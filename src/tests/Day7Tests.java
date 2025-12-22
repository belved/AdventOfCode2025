package tests;

import model.Day7.Beam;
import model.Day7.QuantumTachyonDiagram;
import model.Day7.TachyonDiagram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Day7Tests {

    private List<String> data;
    private List<String> data2;
    
    @BeforeEach
    public void setup() {
        data = new ArrayList<>();
        
        data.add(".......S.......");
        data.add("...............");
        data.add(".......^.......");
        data.add("...............");
        data.add("......^.^......");
        data.add("...............");
        data.add(".....^.^.^.....");
        data.add("...............");
        data.add("....^.^...^....");
        data.add("...............");
        data.add("...^.^...^.^...");
        data.add("...............");
        data.add("..^...^.....^..");
        data.add("...............");
        data.add(".^.^.^.^.^...^.");
        data.add("...............");

        data2 = new ArrayList<>();

        data2.add(".......S.......");
        data2.add("...............");
        data2.add(".......^.......");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
        data2.add("...............");
    }
    
    @Test
    void testTachyonDiagramConstructor() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        Assertions.assertEquals(data.size(), tachyonDiagram.getGrid().size());
        Assertions.assertEquals(".......S.......", tachyonDiagram.getData().getFirst());
        Assertions.assertEquals("...............", tachyonDiagram.getData().getLast());
        Assertions.assertEquals('S', tachyonDiagram.getGrid().get(0).get(7));
        Assertions.assertEquals('.', tachyonDiagram.getGrid().get(1).get(7));
        Assertions.assertEquals('^', tachyonDiagram.getGrid().get(2).get(7));
    }
    
    @Test
    void testFindStartPosition() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        Assertions.assertEquals(7, tachyonDiagram.getStart());
    }
    
    @Test
    void testSetBeam() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        tachyonDiagram.setBeam(1, 7);
        
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(1).get(7));
        
        tachyonDiagram.setBeam(2, 7);
        Assertions.assertEquals('^',  tachyonDiagram.getGrid().get(2).get(7));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(2).get(6));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(2).get(8));
    }
    
    @Test
    void testNavigateThroughPlaceAtStart() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        tachyonDiagram.navigateThrough();

        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(1).get(7));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(1).get(6));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(1).get(8));
    }

    @Test
    void testNavigateThroughFirstSplitterLine() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        tachyonDiagram.navigateThrough();

        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(0));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(1));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(2));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(3));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(4));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(5));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(2).get(6));
        Assertions.assertEquals('^',  tachyonDiagram.getGrid().get(2).get(7));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().get(2).get(8));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(9));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(10));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(11));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(12));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(13));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().get(2).get(14));
    }
    
    @Test
    void testNavigateThroughLastLine() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        tachyonDiagram.navigateThrough();
        
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(0));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(1));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(2));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(3));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(4));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(5));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(6));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(7));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(8));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(9));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(10));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(11));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(12));
        Assertions.assertEquals('.',  tachyonDiagram.getGrid().getLast().get(13));
        Assertions.assertEquals('|',  tachyonDiagram.getGrid().getLast().get(14));
    }

    @Test
    void testGetCountAfterNavigateThrough() {
        
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        tachyonDiagram.navigateThrough();
        
        Assertions.assertEquals(21,  tachyonDiagram.getCount());
    }
    
    @Test
    void testBeamConstructor() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        Beam beam = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        
        Assertions.assertEquals("0000000", beam.getSeed());
        Assertions.assertEquals("", beam.getPath());
    }

    @Test
    void testBeamUpdatePosition() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        Beam beam = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        beam.updatePath(1, 7);
        beam.updatePath(2, 7);
        Assertions.assertEquals("l", beam.getPath());
        Assertions.assertEquals('|', beam.getGrid().get(2).get(6));
        Assertions.assertEquals('.', beam.getGrid().get(2).get(8));
    }

    @Test
    void testBeamNavigateThrough() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        Beam beam = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        beam.navigateThroughWithNoRecursion();
        
        Assertions.assertEquals("lllllll", beam.getPath());
    }

    @Test
    void testBeamNavigateThrough2() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        Beam beam = new Beam("0000001", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        beam.navigateThroughWithNoRecursion();

        Assertions.assertEquals("rllll", beam.getPath());
        
        beam = new Beam("0010000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        beam.navigateThroughWithNoRecursion();

        Assertions.assertEquals("llllr", beam.getPath());
    }
    
    @Test
    void testBeamComparisonEqual() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        Beam beam1 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam2 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        
        beam1.navigateThroughWithNoRecursion();
        beam2.navigateThroughWithNoRecursion();

        Assertions.assertEquals(beam1, beam2);
    }

    @Test
    void testBeamComparisonNotEqual() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        Beam beam1 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam2 = new Beam("0000001", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        beam1.navigateThroughWithNoRecursion();
        beam2.navigateThroughWithNoRecursion();

        Assertions.assertNotEquals(beam1, beam2);
    }
    
    @Test
    void testCountInHashSet() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        Beam beam1 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam2 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam3 = new Beam("0000001", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        HashSet<Beam> beams = new HashSet<>();
        
        beams.add(beam1);
        beams.add(beam2);
        
        beam1.navigateThroughWithNoRecursion();
        beam2.navigateThroughWithNoRecursion();

        Assertions.assertEquals(1, beams.size());

        beams.add(beam3);
        beam3.navigateThroughWithNoRecursion();
        
        Assertions.assertEquals(2, beams.size());
    }

    @Test
    void testCountInHashSet2() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        Beam beam1 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam2 = new Beam("0000001", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        List<Beam> beams = new ArrayList<>();

        beams.add(beam1);
        beams.add(beam2);

        beam1.navigateThroughWithNoRecursion();
        beam2.navigateThroughWithNoRecursion();
        
        HashSet<Beam> beams2 = new HashSet<>();
        beams2.add(beam1);
        beams2.add(beam2);

        Assertions.assertEquals(2, beams2.size());
    }

    @Test
    void testCountInHashSet3() {
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);

        Beam beam1 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());
        Beam beam2 = new Beam("0000000", tachyonDiagram.getGrid(), tachyonDiagram.getStart());

        List<Beam> beams = new ArrayList<>();

        beams.add(beam1);
        beams.add(beam2);

        beam1.navigateThroughWithNoRecursion();
        beam2.navigateThroughWithNoRecursion();

        HashSet<Beam> beams2 = new HashSet<>();
        beams2.add(beam1);
        beams2.add(beam2);

        Assertions.assertEquals(1, beams2.size());
    }
    
    @Test
    void testComputeQuantumPathCount() {
        QuantumTachyonDiagram tachyonDiagram = new QuantumTachyonDiagram(data2);
        
        Assertions.assertEquals(2, tachyonDiagram.getPathCount(0,7));
    }

    @Test
    void testComputeQuantumPathCountWithRealData() {
        QuantumTachyonDiagram tachyonDiagram = new QuantumTachyonDiagram(data);

        Assertions.assertEquals(40, tachyonDiagram.getPathCount(0,7));
    }
}
