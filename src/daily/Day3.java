package daily;

import model.Day3.Bank;
import util.FileReader;

import java.util.List;

public class Day3 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("bank");

        long sum = 0;
        Bank bank;

        for(String s : data) {
            bank = new Bank(s);
            sum += bank.getMaxJoltageValue(2);
        }

        System.out.println("The sum of max joltage for all the bank is : "+sum);

        sum = 0;

        for(String s : data) {
            bank = new Bank(s);
            sum += bank.getMaxJoltageValue(12);
        }

        System.out.println("The sum of max joltage for all the bank with 12 battery is : "+sum);

    }
}
