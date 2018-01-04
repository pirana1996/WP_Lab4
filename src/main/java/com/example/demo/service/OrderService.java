package com.example.demo.service;


import com.example.demo.model.Order;

public interface OrderService {
    public Order placeOrder(String pizzaType, String clientName, String address);
}
