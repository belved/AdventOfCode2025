package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

    public static List<String> readDataAsListString(String fileName) {

        List<String> data = new ArrayList<>();

        try {
            File myObj = new File("src/data/"+fileName+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                data.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
