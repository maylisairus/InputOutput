package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static ArrayList<User> readUsers(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<User> users = new ArrayList<>();
        Scanner sc = new Scanner(file);
        String [] cols = sc.nextLine().split(" ");
        while (sc.hasNext()){
            String name = "";
            int age = 0;
            for(String col: cols){
                if(col.equals("name")){
                    name = sc.next();
                } else if (col.equals("age")) {
                    age = sc.nextInt();
                }
            }
            User user = new User(name, age);
            users.add(user);
        }
        sc.close();
        return users;
    }
    public static void Serialise(String fileName, ArrayList<User> users) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file, false);
        writer.write(json);
        writer.close();

    }
}
