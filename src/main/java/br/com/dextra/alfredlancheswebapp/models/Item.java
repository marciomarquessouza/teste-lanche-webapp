package br.com.dextra.alfredlancheswebapp.models;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Item {
    /**
     * O objeto Item é base para os objetos Ordem (Order) e Receita (Recept)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;
    private String description;
    private BigDecimal price;
    private String imageUrl;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
