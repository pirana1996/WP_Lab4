package com.example.demo.model;

public class Order {
    public Long orderId;
    public String pizzaType;
    public String clientName;
    public String clientAddress;

    public Order(Long orderId, String pizzaType, String clientName, String clientAddress){
        this.orderId = orderId;
        this.pizzaType = pizzaType;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return pizzaType + " " + clientName + " " + clientAddress;
    }
}
