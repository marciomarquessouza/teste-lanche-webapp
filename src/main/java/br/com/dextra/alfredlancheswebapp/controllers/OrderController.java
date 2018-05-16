package br.com.dextra.alfredlancheswebapp.controllers;

import br.com.dextra.alfredlancheswebapp.models.Orderv;
import br.com.dextra.alfredlancheswebapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    
    private OrderService orderService;
    
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "order/new", method = RequestMethod.POST)
    public String newOrder(Model model) {
        model.addAttribute("order", new Orderv());
        return "admintemplate/pages/orderform";
    }

    @RequestMapping(value = "orderv", method = RequestMethod.POST)
    public String saveOrder(Orderv orderv) {
        orderService.saveOrder(orderv);
        return "redirect:/orders";
    }

    @RequestMapping(value = "order/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "ordershow";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String list(Model model){

        model.addAttribute("orders", orderService.listAllOrders());
        return  "admintemplate/pages/orders";
    }

    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "admintemplate/pages/ordershow";
    }

    @RequestMapping(value = "order/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        orderService.deleteOrder(orderService.getOrderById(id));
        return "redirect:/orders";
    }
}
