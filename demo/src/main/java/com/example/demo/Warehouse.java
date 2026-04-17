package com.example.demo;

public class Warehouse {
String name;
int id;
double latitude;
double longitude;
public Warehouse(int id,String name,double latitude,double longitude){
    this.id=id;
    this.name=name;
    this.latitude=latitude;
    this.longitude=longitude;
}
public int getid(){return id;}
    public String getname(){return name;}
      public double getlatitude(){return latitude;}
    public double getlongitude(){return longitude;};
}
