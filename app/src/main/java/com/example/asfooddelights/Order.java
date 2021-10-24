package com.example.asfooddelights;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private String option;
    private String meat;
    private ArrayList<String> sides = new ArrayList<String>();
    private String boxSize;

    public void setOption(String opt){
        this.option = opt;
    }
    public void setMeat(String m){
        this.meat = m;
    }
    public void setSide(String s){
        if(s!=null){
            sides.add(s);
        }
    }
    public void setBoxSize(String size){
        this.boxSize = size;
    }
    public String getOption(){
        return this.option;
    }
    public String getMeat(){
        return this.meat;
    }
    public ArrayList<String> getSides(){
        return this.sides;
    }
    public String getBoxSize(){
        return this.boxSize;
    }



}
