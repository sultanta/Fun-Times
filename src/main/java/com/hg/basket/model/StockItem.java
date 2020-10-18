package com.hg.basket.model;


import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

@Data
public class StockItem implements Serializable {

    private static final long serialVersionUID = -229548328174336427L;

    private String product;
    private String unit;
    private double cost;

    public StockItem(String product, String unit, double cost) {
        this.product = product;
        this.unit = unit;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product, unit, cost);
    }

}
