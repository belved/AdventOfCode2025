import daily.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final ArrayList<IDay> daysList = new ArrayList<>(
            Arrays.asList(
                    new Day1(),
                    new Day2(),
                    new Day3(),
                    new Day4()
            )
    );

    public static void main(String[] args) {
        System.out.println("-----------------------------");
        System.out.println("|Starting Advent Of Code 2025|");
        System.out.println("-----------------------------\n");

        long begining = System.currentTimeMillis();

        for(int i = 0; i < daysList.size(); i++) {
            System.out.println("DAY : " + (i+1));
            long start = System.currentTimeMillis();
            daysList.get(i).displayResult();
            long end = System.currentTimeMillis();
            System.out.println("The result was computed in " + (end - start) + " ms.");
            System.out.print("------------------------------------------------------------\n");
        }

        long ending = System.currentTimeMillis();
        long ms = ending - begining;
        long minutes = ms / 60000;
        long seconds = (ms - (minutes*60000)) / 1000;
        System.out.println("All the days were computed in " + (ending - begining) + " ms. ("+ minutes +" minutes "+seconds+")");
    }
}