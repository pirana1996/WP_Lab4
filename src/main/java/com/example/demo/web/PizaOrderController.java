package com.example.demo.web;

import com.example.demo.model.Order;
import com.example.demo.service.impl.MenageOrderService;
import com.example.demo.service.impl.MenagePizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/lab")
public class PizaOrderController {

    MenagePizzaService pizzaService;
    MenageOrderService orderService;

    @Autowired
    public PizaOrderController(MenagePizzaService pizzaService, MenageOrderService orderService){
        this.pizzaService = pizzaService;
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexoejfe(){
        ModelAndView mw = new ModelAndView("index");
        return mw;
    }

    @RequestMapping(value = "/orderform", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pizza_index");
        modelAndView.addObject("pizzaTypes", pizzaService.getPizzaTypes());
        return modelAndView;
    }

    @RequestMapping(value = "/clientInfoForm", method = RequestMethod.GET)
    public ModelAndView showClientInfo(@RequestParam String pizzaSize, HttpSession session){
        session.setAttribute("pizzaType", pizzaSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client_info");

        return modelAndView;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public ModelAndView placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session){
        String pizzaType = (String) session.getAttribute("pizzaType");
        Order newOrder = orderService.placeOrder(pizzaType, clientName, clientAddress);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmation");
        System.out.println(newOrder == null);
        modelAndView.addObject("newOrder", newOrder);

        return modelAndView;
    }
}