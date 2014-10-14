package com.example.littlechemie;

public class WorldPopulation {   
    private String country;
    private int flag;
 
    public WorldPopulation(String country,int flag) {
        this.country = country;       
        this.flag = flag;
    }
 
   public String getCountry() {
        return this.country;
    }
 
   public int getFlag() {
        return this.flag;
    }
}