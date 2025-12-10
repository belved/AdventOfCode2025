package tests;

import model.Day6.Problem;
import model.Day6.ProblemSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day6Tests {

    String[] values = {"123", "45", "6", "1"};
    String[] values2 = {"328", "64", "98", "0"};

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
}
