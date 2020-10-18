package com.hg.basket.db;

import com.hg.basket.model.StockItem;
import java.util.HashMap;
import java.util.Map;

public class GetStockItem {

    private static final String SOUP = "soup";
    private static final String BREAD = "bread";
    private static final String MILK = "milk";
    private static final String APPLES = "apples";

    private static final Map<String, StockItem> STOCK_ITEMS = new HashMap<>();

    static {
        STOCK_ITEMS.put(SOUP, new StockItem("soup", "tin", 0.65));
        STOCK_ITEMS.put(BREAD, new StockItem("bread", "loaf", 0.80));
        STOCK_ITEMS.put(MILK, new StockItem("milk", "bottle", 1.30));
        STOCK_ITEMS.put(APPLES, new StockItem("apples", "single", 0.10));
    }

    public static StockItem getStockItem(String product) {
        return STOCK_ITEMS.get(product);
    }

}
