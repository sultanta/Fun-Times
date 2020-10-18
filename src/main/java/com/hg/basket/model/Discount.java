package com.hg.basket.model;

import com.hg.basket.ProductType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;

@Data
public class Discount implements Serializable {

    private static final long serialVersionUID = -229548987674336427L;

    private String offer;
    private int countOfBuyingStockItem;
    private StockItem buyingStockItem;
    private double discountRate;
    private ProductType discountApplyingProductType;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public Discount(String offer, int countOfBuyingStockItem, StockItem buyingStockItem, double discountRate,
        ProductType discountApplyingProductType,
        LocalDateTime validFrom,
        LocalDateTime validTo) {
        this.offer = offer;
        this.countOfBuyingStockItem = countOfBuyingStockItem;
        this.buyingStockItem = buyingStockItem;
        this.discountRate = discountRate;
        this.discountApplyingProductType = discountApplyingProductType;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, countOfBuyingStockItem, buyingStockItem, discountRate,
            discountApplyingProductType,
            validFrom, validTo);
    }
}
