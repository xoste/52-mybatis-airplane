package com.xoste.leon.pojo;

public class Airport {
    private int id;
    private String portName;
    private String portCity;

    public Airport() {
    }

    public Airport(int id, String portName, String portCity) {
        this.id = id;
        this.portName = portName;
        this.portCity = portCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortCity() {
        return portCity;
    }

    public void setPortCity(String portCity) {
        this.portCity = portCity;
    }
}
