package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //task1//
        ArrayList<String> numbers = Validator.reedNumbers("src/main/java/org/example/file.txt");
        for(String num: numbers){
            System.out.println(num);
        }
        ArrayList<String> Vnumbers = Validator.validateNumbers(numbers);
        System.out.println("Valid phone numbers");
        for(String num: Vnumbers){
            System.out.println(num);
        }
        //task2//
        try {
            ArrayList<User> users = User.readUsers("src/main/java/org/example/file2.txt");
            User.Serialise("user.json", users);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nusers are serialised");
        //task3//
        System.out.println("\nwords:");
        try {
            Map<String, Integer> words = Counter.count("src/main/java/org/example/file3.txt");
            for(String key: words.keySet()){
                System.out.println(key+" - "+words.get(key));
            }
            Map<String, Integer> sorted = Counter.sortByValue((HashMap<String, Integer>) words);
            System.out.println("\nsorted words");
            for(String key: sorted.keySet()){
                System.out.println(key+" - "+sorted.get(key));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}