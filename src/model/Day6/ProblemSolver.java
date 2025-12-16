package model.Day6;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolver {

    List<Problem> problems = new ArrayList<>();

    public ProblemSolver(String v1, String v2, String v3, String v4, String o) {
        String[] data1 = v1.trim().replaceAll(" +", " ").split(" ");
        String[] data2 = v2.trim().replaceAll(" +", " ").split(" ");
        String[] data3 = v3.trim().replaceAll(" +", " ").split(" ");
        String[] data4 = v4.trim().replaceAll(" +", " ").split(" ");
        String[] operator = o.trim().replaceAll(" +", " ").split(" ");
        for(int i = 0; i < data1.length; i++) {
            problems.add(new Problem(new String[]{data1[i], data2[i], data3[i], data4[i]}, operator[i]));
        }
    }

    public ProblemSolver() {
        problems = new ArrayList<>();
    }

    public void addNewProblem(Problem p) {
        problems.add(p);
    }

    public long computeProblems() {
        long value = 0;
        for(Problem problem: problems){
            value += problem.compute();
        }
        return value;
    }


    public List<Problem> getProblems() {
        return problems;
    }
}
