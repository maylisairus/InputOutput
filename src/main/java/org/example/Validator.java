package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Validator {
    public static ArrayList<String> validateNumbers(ArrayList<String> numbers) {
        ArrayList<String> Vnums = new ArrayList<>();
        for (String num : numbers) {
            if (num.matches("\\d{3}-\\d{3}-\\d{4}") || num.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) {
                Vnums.add(num);


            }
        }
        return Vnums;
    }
    public static ArrayList<String> reedNumbers(String fileName){
        ArrayList<String> numbers = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                numbers.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}