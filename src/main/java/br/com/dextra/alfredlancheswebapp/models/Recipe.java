package br.com.dextra.alfredlancheswebapp.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private Double amount;
    private Set<ItemRecipe> itemRecipes;

    public Recipe() { }

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(int id, String name, String description, String imageUrl, Double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    public Set<ItemRecipe> getItemRecipes() {
        return itemRecipes;
    }

    public void setItemRecipes(Set<ItemRecipe> itemRecipes) {
        this.itemRecipes = itemRecipes;
    }

    @Override
    public String toString() {

        String result = String.format(
                "Receita[id=%d, name='%s']%n",
                id, name );
         if(itemRecipes != null) {
             for(ItemRecipe itemRecipe : itemRecipes) {
                 result += String.format(
                         "Item[id=%id, name='%s']%n",
                         itemRecipe.getId(), itemRecipe.getName()
                 );
             }
         }

        return result;

    }
}
