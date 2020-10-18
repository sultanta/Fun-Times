package com.hg.basket;

import static org.junit.Assert.assertNotEquals;

import com.hg.basket.db.GetStockItem;
import com.hg.basket.impl.ShoppingServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;

public class ShoppingServiceImplTest {

    private static final String SOUP = "soup";
    private static final String BREAD = "bread";
    private static final String MILK = "milk";
    private static final String APPLES = "apples";

    @InjectMocks
    private ShoppingServiceImpl shoppingServiceImpl;

    @Test
    public void calculateThreeSoupTwoBread() {
        //Price a basket containing: 3 tins of soup and 2 loaves of bread, bought today
        //(0.65 * 3) + (0.80 * 2) = 3.55 without discount
        assertNotEquals(3.15,
            ((3 * (GetStockItem.getStockItem(SOUP).getCost())) + (2 * (GetStockItem.getStockItem(BREAD).getCost()))));
    }

    @Test
    public void calculateDiscount() {

    }

    @Test
    public void calculateExpireDate() {

    }


}
