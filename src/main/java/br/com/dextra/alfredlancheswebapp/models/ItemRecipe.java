package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;

@Entity
public class ItemRecipe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private Double quantity;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemRecipe() { }

    // *** Construtor sem observação - o campo observação não foi solicitado no teste ***
    public ItemRecipe(Recipe recipe, Item item, Double quantity) {
        this.quantity = quantity;
        this.recipe = recipe;
        this.item = item;
    }

    // *** Construtor com observação ***
    public ItemRecipe(Recipe recipe, Item item, Double quantity, String observation) {
        this.quantity = quantity;
        this.observation = observation;
        this.recipe = recipe;
        this.item = item;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
