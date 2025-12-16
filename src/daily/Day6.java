package daily;

import model.Day6.Column;
import model.Day6.ProblemConverter;
import model.Day6.ProblemSolver;
import util.FileReader;

import java.util.List;

public class Day6 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("problems");

        ProblemSolver problemSolver = new ProblemSolver(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));

        System.out.println("The result of all the problems is " + problemSolver.computeProblems());

        ProblemConverter problemConverter = new ProblemConverter(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
        problemSolver = new ProblemSolver();

        while (problemConverter.hasNextColumn()) {
            problemConverter.readNextColumn();
        }

        List<Column> columns = problemConverter.getColumns();

        for(Column column : columns) {
            problemSolver.addNewProblem(column.convertToProblem());
        }

        System.out.println("The result of all the problems computed by column is " + problemSolver.computeProblems());

    }
}
