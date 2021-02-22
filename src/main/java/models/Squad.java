package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String name;
    private int size;
    private String cause;
    private List<Hero> hero = new ArrayList<>();
    private static List<Object> members = new ArrayList<>();

    public Squad(String name, int size, String cause){
        this.name = name;
        this.size = size;
        this.cause = cause;
        members.add(this);
    }

    public static List<Object> getMembers() {
        return members;
    }

    public static void add(Hero hero) {
        members.add(hero);
    }
}
