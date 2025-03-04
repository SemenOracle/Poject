package org.example;

public class Clients {
    private int id;
    private String name;
    private int distributor_id;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDistributor_id(int distributor_id) {
        this.distributor_id = distributor_id;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getDistributor_id() {
        return distributor_id;
    }
}
