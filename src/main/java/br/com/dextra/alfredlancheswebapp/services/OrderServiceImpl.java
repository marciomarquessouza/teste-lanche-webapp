package br.com.dextra.alfredlancheswebapp.services;

import br.com.dextra.alfredlancheswebapp.models.ItemOrder;
import br.com.dextra.alfredlancheswebapp.models.Orderv;
import br.com.dextra.alfredlancheswebapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Orderv> listAllOrders() {

        Iterable<Orderv> orders = orderRepository.findAll();

        orders.forEach(item->item.setAmount(sumOrderItem(item)));

        return orders;
    }

    @Override
    public Orderv getOrderById(Integer id) {

        Orderv orderv = orderRepository.findById(id).get();
        orderv.setAmount(sumOrderItem(orderv));

        return orderv;
    }

    @Override
    public Orderv saveOrder(Orderv orderv) {
        return orderRepository.save(orderv);
    }

    @Override
    public void deleteOrder(Orderv orderv) {
        orderRepository.delete(orderv);

    }

    public Double sumOrderItem(Orderv orderv) {

        Double total = 0d;

        for (ItemOrder itemOrder : orderv.getItemOrders() ) {
            total += itemOrder.getQuantity() * itemOrder.getItem().getPrice();
        }

        return total;

    }

}
