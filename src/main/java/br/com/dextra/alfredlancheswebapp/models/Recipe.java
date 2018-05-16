package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private String name;

    private String description;

    private String imageUrl;

    private Double amount;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<ItemRecipe> itemRecipes;

    public Recipe() { }

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Recipe(int id, String name, String description, String imageUrl, Double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<ItemRecipe> getItemRecipes() {
        return itemRecipes;
    }

    public void setItemRecipes(Set<ItemRecipe> itemRecipes) {
        this.itemRecipes = itemRecipes;
    }

}
