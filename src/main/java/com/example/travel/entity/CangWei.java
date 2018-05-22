package com.example.travel.entity;

public class CangWei {
    private int id;
    private String name;

    public CangWei(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CangWei() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
