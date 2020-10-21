package com.hg.basket.model;


import com.hg.basket.ProductType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;

@Data
public class StockItem implements Serializable {

    private static final long serialVersionUID = -229548328174336427L;

    private ProductType product;
    private String unit;
    private BigDecimal cost;

    public StockItem(ProductType product, String unit, BigDecimal cost) {
        this.product = product;
        this.unit = unit;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product, unit, cost);
    }

}
