package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Orderv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String city;

    private String address;

    private String state;

    private Double amount;

    private String promotionText;

    private Double promotionValue;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<ItemOrder> itemOrders;

    public Orderv() {
    }

    public Orderv(int id, String firstName, String lastName, String email, String phone, String city, String address, String state, Double amount, String promotionText, Double promotionValue) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.state = state;
        this.amount = amount;
        this.promotionText = promotionText;
        this.promotionValue = promotionValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPromotionText() {
        return promotionText;
    }

    public void setPromotionText(String promotionText) {
        this.promotionText = promotionText;
    }

    public Double getPromotionValue() {
        return promotionValue;
    }

    public void setPromotionValue(Double promotionValue) {
        this.promotionValue = promotionValue;
    }

    public Set<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(Set<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }
}
