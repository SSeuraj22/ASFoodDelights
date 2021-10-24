package com.example.asfooddelights;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String option;
    private String meat;
    private ArrayList<String> sides = new ArrayList<String>();
    private String boxSize;

    public void addOption(String opt){
        this.option = opt;
    }
    public void addMeat(String m){
        this.meat = m;
    }
    public void addSide(String s){
        if(s!=null){
            sides.add(s);
        }
    }
    public void addBoxSize(String size){
        this.boxSize = size;
    }



}
