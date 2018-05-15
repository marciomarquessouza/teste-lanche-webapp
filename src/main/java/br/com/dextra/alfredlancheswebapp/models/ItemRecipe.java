package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;

@Entity
public class RecipeItems {

    private Integer id;
    private String name;
    private Double value;
    private Double quantity;
    private String observation;
    private Recipe recipe;

    public RecipeItems() { }

    public RecipeItems(String name) {
        this.name = name;
    }

    public RecipeItems(Integer id, String name, Double value, Double quantity, String observation, Recipe recipe) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.observation = observation;
        this.recipe = recipe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
