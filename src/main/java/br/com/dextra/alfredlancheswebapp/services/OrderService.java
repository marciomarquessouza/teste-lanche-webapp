package br.com.dextra.alfredlancheswebapp.services;

import br.com.dextra.alfredlancheswebapp.models.Orderv;

public interface OrderService {

    Iterable<Orderv> listAllOrders();

    Orderv getOrderById(Integer id);

    Orderv saveOrder(Orderv orderv);

    void deleteOrder(Orderv orderv);
}
