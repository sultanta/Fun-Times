package com.hg.basket.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;

@Data
public class Discount implements Serializable {

    private static final long serialVersionUID = -229548987674336427L;

    private String offer;
    private int countOfStockItem;
    private StockItem stockItem;
    private String discountProduct;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public Discount(String offer, int countOfStockItem, StockItem stockItem, String discountProduct,
        LocalDateTime validFrom,
        LocalDateTime validTo) {
        this.offer = offer;
        this.countOfStockItem = countOfStockItem;
        this.stockItem = stockItem;
        this.discountProduct = discountProduct;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, countOfStockItem, stockItem, discountProduct,
            validFrom, validTo);
    }
}
