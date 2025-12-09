package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

    public static MultipleStringList readDataAsMultipleStringList(String fileName) {

        List<String> data1 = new ArrayList<>();
        List<String> data2 = new ArrayList<>();

        MultipleStringList value = null;

        boolean shouldAddFirstList = true;

        try {
            File myObj = new File("src/data/"+fileName+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line.isBlank()) {
                    shouldAddFirstList = false;
                } else {
                    if(shouldAddFirstList) {
                        data1.add(line);
                    } else {
                        data2.add(line);
                    }
                }
            }

            value = new MultipleStringList(data1, data2);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return value;
    }

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

    public static String readDataAsString(String fileName) {

        String line = "";

        try {
            File myObj = new File("src/data/"+fileName+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return line;
    }
}
