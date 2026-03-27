package com.designpatterns.factory;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Entregado por tierra");
    }
}
