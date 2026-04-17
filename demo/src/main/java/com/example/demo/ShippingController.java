package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippingController {
    @Autowired
    ShippingService service;
    @GetMapping("/shipping")
    public double getshipping(){// final retunr the double value
        Seller S=new Seller(001,"Nestle",28.6139,77.2090);
        Customer C=new Customer(004,"Andheri minimart",11.232,23.445495);List<Warehouse> list = List.of(
                new Warehouse(1, "BLR", 13, 77),
                new Warehouse(2, "MUM", 19, 72)
        );
        return service.finalmethod(S,C,list,1,"express");
    }


}
