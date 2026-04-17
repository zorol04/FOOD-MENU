package com.example.demo;

import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShippingService {
///  finding the nearest warehouse:
    public Warehouse findnearestwarehouse(Seller S,List<Warehouse> list){
        Warehouse nearest=null;
        double min=Double.MAX_VALUE;
        for(Warehouse w:list){
            double dist=distance(S.latitude,S.longitude,w.latitude,w.longitude);

            if (dist<min){
                min=dist;
                nearest=w;
            }
        }
return nearest;
    }

    ///  fnd the shipping charge from warehosue to cutomer
    public double calshippingcharger(Warehouse w,Customer C,double weight,String speed){
        // cal the dist from warehosue to custo
        double dist=distance(w.latitude,w.longitude,C.latitude,C.longitude);
        double rate;
        if(dist>500) {
             rate=1;
        }else if(dist >100 && dist<500){
             rate=2;
        }else{
             rate=3;
        }
        rate=dist*weight*rate;
        String deliver="Standard";
        if(deliver=="Standard"){
            rate+=10;
        }else{
            rate+=(1.2*weight);
        }
          return rate;
    }

    ///  final mtd
    public double finalmethod(Seller S, Customer C,List<Warehouse> list,double weight,String speed){
        Warehouse nearest=findnearestwarehouse (S,list);
//        double Customer;
        return calshippingcharger(nearest,C,weight,speed);

    }

    //hlper mtd to fidn the distce
    private double distance(Double longitude1,double latitude1,double longitutde2,double latitude2){
        double d1=longitude1-longitutde2;
        double d2=latitude1-latitude2;
        return Math.sqrt(d1*d1+d2*d2 )*111;//(to covert into kiilomoer the lat long ar ein degree 1deg=111km);

    }
}
