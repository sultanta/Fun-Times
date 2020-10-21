package com.hg.basket.db;

import com.hg.basket.ProductType;
import com.hg.basket.model.StockItem;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GetStockItem {

    private static final Map<ProductType, StockItem> STOCK_ITEMS = new HashMap<>();

    static {
        STOCK_ITEMS.put(ProductType.SOUP, new StockItem(ProductType.SOUP, "tin", BigDecimal.valueOf(0.65)));
        STOCK_ITEMS.put(ProductType.BREAD, new StockItem(ProductType.BREAD, "loaf", BigDecimal.valueOf(0.80)));
        STOCK_ITEMS.put(ProductType.MILK, new StockItem(ProductType.MILK, "bottle", BigDecimal.valueOf(1.30)));
        STOCK_ITEMS.put(ProductType.APPLES, new StockItem(ProductType.APPLES, "single", BigDecimal.valueOf(0.10)));
    }

    public static StockItem getStockItem(ProductType product) {
        return STOCK_ITEMS.get(product);
    }

}
