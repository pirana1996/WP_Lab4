package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class MenageOrderService implements OrderService {
    ArrayList<Order> orders;

    public MenageOrderService(){
        orders = new ArrayList<>();
    }

    @Override
    public Order placeOrder(String pizzaType, String clientName, String address) {
        return new Order((long) (new Random()).nextInt(),pizzaType,clientName,address);
    }
}
