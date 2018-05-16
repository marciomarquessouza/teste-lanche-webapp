package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;

@Entity
public class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "sales_order_id")
    private Orderv orderv;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemOrder(Integer id, Double quantity, Orderv orderv) {
        this.id = id;
        this.quantity = quantity;
        this.orderv = orderv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Orderv getOrderv() {
        return orderv;
    }

    public void setOrderv(Orderv orderv) {
        this.orderv = orderv;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
