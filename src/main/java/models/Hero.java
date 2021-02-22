package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weaknesses;
    private static List<Hero> instances = new ArrayList<>();


    public Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weaknesses = weaknesses;
        instances.add(this);
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public String getPower() {

        return power;
    }

    public String getWeaknesses() {

        return weaknesses;
    }

    public static List<Hero> getAll() {

        return instances;
    }
}
