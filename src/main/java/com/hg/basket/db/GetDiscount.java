package com.hg.basket.db;

import com.hg.basket.ProductType;
import com.hg.basket.model.Discount;
import com.hg.basket.model.StockItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class GetDiscount {

    private static final Set<Discount> DISCOUNT_SET = new HashSet<>();

    static {
        DISCOUNT_SET.add(
            new Discount("Buy 2 tins of soup and get a loaf of bread half price | yesterday | for 7 days",
                2,
                new StockItem(ProductType.SOUP, "tin", BigDecimal.valueOf(0.65)),
                0.5,
                ProductType.BREAD,
                LocalDateTime.now().minusDays(Long.valueOf(1)),
                LocalDateTime.now().plusDays(Long.valueOf(6)))
        );
        DISCOUNT_SET.add(
            new Discount("Apples have a 10% discount | from 3 days hence | until the end of the following month",
                1,
                new StockItem(ProductType.APPLES, "single", BigDecimal.valueOf(0.10)),
                0.9,
                ProductType.APPLES,
                LocalDateTime.now().minusDays(Long.valueOf(3)),
                LocalDateTime.now().plusMonths(Long.valueOf(2)).minusDays(Long.valueOf(3)))
        );
    }

    public static Boolean getStockItem(Discount discount) {
        return DISCOUNT_SET.contains(discount);
    }
}
