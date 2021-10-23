package com.example.asfooddelights;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String option;
    private String meat;
    private ArrayList<String> side;
    private String boxSize;

    public Order(){

    }

    public Order (String option){
        this.option = option;
        this.side = new ArrayList<String>();
    }

    public void addMeat(String m){
        this.meat = m;
    }
    public void addSide(String s){
        side.add(s);
    }
    public void addBoxSize(String size){
        this.boxSize = size;
    }



}
