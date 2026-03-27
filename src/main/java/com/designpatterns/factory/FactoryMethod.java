package com.designpatterns.factory;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryMethod {

    static void main() {
        Logistics logistics;
        logistics = new EarthLogistics();
        logistics.planDelivery();

        logistics = new SeaLogistics();
        logistics.planDelivery();
    }
}
