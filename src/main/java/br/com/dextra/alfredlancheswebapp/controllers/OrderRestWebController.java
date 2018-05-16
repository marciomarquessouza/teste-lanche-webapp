package br.com.dextra.alfredlancheswebapp.controllers;

import br.com.dextra.alfredlancheswebapp.message.Response;
import br.com.dextra.alfredlancheswebapp.models.Orderv;
import br.com.dextra.alfredlancheswebapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/api/")
public class OrderRestWebController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/save")
    public Response postOrder(@RequestBody Orderv orderv) {

        orderService.saveOrder(orderv);
        Response response = new Response("Done", orderv);
        return response;
    }

    @GetMapping(value = "/all")
    public Response getAllOrder() {
        Response response = new Response("Done", orderService.listAllOrders());
        return response;
    }

    @GetMapping(value = "/view")
    public Response getOrder(@RequestBody Integer id) {

        Response response = new Response("Done", orderService.getOrderById(id));
        return response;
    }

    @DeleteMapping(value = "/remove")
    public Response deleteOrder(@RequestBody Orderv orderv) {

        orderService.deleteOrder(orderv);
        Response response = new Response("Done", orderService.listAllOrders());
        return response;

    }
}
