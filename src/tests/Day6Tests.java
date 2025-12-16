package tests;

import model.Day6.Column;
import model.Day6.Problem;
import model.Day6.ProblemConverter;
import model.Day6.ProblemSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day6Tests {

    final String[] values = {"123", "45", "6", "1"};
    final String[] values2 = {"328", "64", "98", "0"};

    @Test
    void testProblemConstructor() {
        Problem problem = new Problem(values, "*");

        Assertions.assertEquals(4, problem.getValues().length);
        Assertions.assertEquals(123, problem.getValues()[0]);
        Assertions.assertEquals(45, problem.getValues()[1]);
        Assertions.assertEquals(6, problem.getValues()[2]);
        Assertions.assertEquals(1, problem.getValues()[3]);
        Assertions.assertEquals("*", problem.getOperator());
    }

    @Test
    void testProblemCompute() {
        Problem problem = new Problem(values, "*");

        Assertions.assertEquals(33210, problem.compute());

        problem = new Problem(values2, "+");

        Assertions.assertEquals(490, problem.compute());
    }

    @Test
    void testProblemSolverConstructor() {
        ProblemSolver problemSolver = new ProblemSolver("123 328  51 64", " 45 64  387 23 ", "  6 98  215 314", "1 0 1 0", "*   +   *   +  ");

        Assertions.assertEquals(4, problemSolver.getProblems().size());
        Assertions.assertEquals(33210, problemSolver.getProblems().getFirst().compute());
        Assertions.assertEquals(4277556, problemSolver.computeProblems());
    }

    @Test
    void testColumnConversion() {
        Column column = new Column(List.of("123", " 45", "  6", "  1"), "*");

        List<String> newColumn = column.columnToList();

        Assertions.assertEquals(3, newColumn.size());
        Assertions.assertEquals("1   ", newColumn.get(0));
        Assertions.assertEquals("24  ", newColumn.get(1));
        Assertions.assertEquals("3561", newColumn.get(2));
    }

    @Test
    void testColumnConversionToProblem() {
        Column column = new Column(List.of("123", " 45", "  6", "  1"), "*");

        Problem problem = column.convertToProblem();

        Assertions.assertEquals(1, problem.getValues()[0]);
        Assertions.assertEquals(24, problem.getValues()[1]);
        Assertions.assertEquals(3561, problem.getValues()[2]);
    }

    @Test
    void testReadColumn() {
        ProblemConverter problemConverter = new ProblemConverter(v1, v2, v3, v4, o);

        List<String> value = problemConverter.readNextColumn();

        Assertions.assertEquals(4, value.size());
        Assertions.assertEquals("123", value.get(0));
        Assertions.assertEquals(" 45", value.get(1));
        Assertions.assertEquals("  6", value.get(2));
        Assertions.assertEquals("  1", value.get(3));

        value = problemConverter.readNextColumn();

        Assertions.assertEquals(4, value.size());
        Assertions.assertEquals("328", value.get(0));
        Assertions.assertEquals("64 ", value.get(1));
        Assertions.assertEquals("98 ", value.get(2));
        Assertions.assertEquals("0  ", value.get(3));

        value = problemConverter.readNextColumn();

        Assertions.assertEquals(4, value.size());
        Assertions.assertEquals(" 51", value.get(0));
        Assertions.assertEquals("387", value.get(1));
        Assertions.assertEquals("215", value.get(2));
        Assertions.assertEquals("  1", value.get(3));
        Assertions.assertTrue(problemConverter.hasNextColumn());

        value = problemConverter.readNextColumn();

        Assertions.assertEquals(4, value.size());
        Assertions.assertEquals("64 ", value.get(0));
        Assertions.assertEquals("23 ", value.get(1));
        Assertions.assertEquals("314", value.get(2));
        Assertions.assertEquals("0  ", value.get(3));
        Assertions.assertFalse(problemConverter.hasNextColumn());

    }

    final String v1 = "123 328  51 64 ";
    final String v2 = " 45 64  387 23 ";
    final String v3 = "  6 98  215 314";
    final String v4 = "  1 0     1 0  ";
    final String o =  "*   +   *   +  ";

    @Test
    void testConstructorWithColumnValue() {
        ProblemConverter problemConverter = new ProblemConverter(v1, v2, v3, v4, o);
        ProblemSolver problemSolver = new ProblemSolver();

        while (problemConverter.hasNextColumn()) {
            problemConverter.readNextColumn();
        }

        List<Column> columns = problemConverter.getColumns();

        for(Column column : columns) {
            problemSolver.addNewProblem(column.convertToProblem());
        }

        Assertions.assertEquals(4, problemSolver.getProblems().size());
        Assertions.assertEquals(85464, problemSolver.getProblems().get(0).compute());
        Assertions.assertEquals(3946, problemSolver.getProblems().get(1).compute());
        Assertions.assertEquals(32554592, problemSolver.getProblems().get(2).compute());
        Assertions.assertEquals(6665, problemSolver.getProblems().get(3).compute());
        Assertions.assertEquals(32650667, problemSolver.computeProblems());
    }
}
