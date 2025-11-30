package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

    public static List<List<Character>> readDataAsCharMatrix(String fileName) {

        List<List<Character>> matrix = new ArrayList<>();

        try {
            File myObj = new File("src/data/"+fileName+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                List<Character> temp = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    temp.add(line.charAt(i));
                }
                matrix.add(temp);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return matrix;
    }
}
