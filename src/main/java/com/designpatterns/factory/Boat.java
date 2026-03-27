package com.designpatterns.factory;

public class Boat implements Transport {

    @Override
    public void deliver() {
        System.out.println("Entregado por mar");
    }
}
