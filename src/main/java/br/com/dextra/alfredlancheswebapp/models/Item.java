package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Item {
    /**
     * O objeto Item é base para os objetos Ordem (Orderv) e Receita (Recept)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private String code;

    private String description;

    private Double price;

    private String imageUrl;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<ItemRecipe> itemRecipes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<ItemRecipe> getItemRecipes() {
        return itemRecipes;
    }

    public void setItemRecipes(Set<ItemRecipe> itemRecipes) {
        this.itemRecipes = itemRecipes;
    }

}
