package com.designpatterns.factory;

public class EarthLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
