package com.example.demo.service.impl;

import com.example.demo.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenagePizzaService implements PizzaService {

    ArrayList<String> pizzaTypes;

    public MenagePizzaService(){
        pizzaTypes = new ArrayList<>();
        pizzaTypes.add("Small");
        pizzaTypes.add("Medium");
        pizzaTypes.add("Large");
    }

    @Override
    public ArrayList<String> getPizzaTypes() {
        return pizzaTypes;
    }
}
