package daily;

import model.Locker;
import util.FileReader;

import java.util.List;

public class Day1 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("lock");

        Locker locker = new Locker(data);

        locker.unlock(false);

        System.out.println("The combination of the locker stop "+ locker.getNumberOfZero()+" time on the 0");

        locker = new Locker(data);
        locker.unlock(true);

        System.out.println("The combination of the locker pass "+ locker.getNumberOfZero()+" time on the 0");

    }
}
