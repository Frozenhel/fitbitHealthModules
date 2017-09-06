package com.anext.fitbitmodule.model.food;

/**
 * Created by Jiri on 26/07/17.
 */

public class Unit {
    private int id;
    private String name;
    private String plural;

    public Unit(int id, String name, String plural) {
        this.id = id;
        this.name = name;
        this.plural = plural;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlural() {
        return plural;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plural='" + plural + '\'' +
                '}';
    }
}
