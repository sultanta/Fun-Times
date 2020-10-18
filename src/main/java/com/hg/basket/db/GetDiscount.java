package com.hg.basket.db;

import com.hg.basket.model.Discount;
import com.hg.basket.model.StockItem;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GetDiscount {

    private static final Map<Discount, StockItem> DISCOUNT_MAP = new HashMap<>();

    static {
        DISCOUNT_MAP.put(
            new Discount("Buy 2 tins of soup and get a loaf of bread half price | yesterday | for 7 days",
                2,
                new StockItem("soup", "tin", 0.65),
                "bread",
                LocalDateTime.now().minusDays(Long.valueOf(1)),
                LocalDateTime.now().plusDays(Long.valueOf(6)))
            , new StockItem("bread", "loaf", 0.40));
        DISCOUNT_MAP.put(
            new Discount("Apples have a 10% discount | from 3 days hence | until the end of the following month",
                1,
                new StockItem("apples", "single", 0.10),
                "apples",
                LocalDateTime.now().minusDays(Long.valueOf(3)),
                LocalDateTime.now().plusMonths(Long.valueOf(2)).minusDays(Long.valueOf(3)))
            , new StockItem("apples",
                "single", 0.09));
    }

    public static StockItem getStockItem(Discount discount) {
        return DISCOUNT_MAP.get(discount);
    }

}
