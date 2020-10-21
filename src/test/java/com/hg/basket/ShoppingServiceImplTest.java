package com.hg.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.hg.basket.db.GetDiscount;
import com.hg.basket.db.GetStockItem;
import com.hg.basket.impl.ShoppingServiceImpl;
import com.hg.basket.model.Discount;
import com.hg.basket.model.StockItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ShoppingServiceImplTest {

    @InjectMocks
    private ShoppingServiceImpl shoppingServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        shoppingServiceImpl = new ShoppingServiceImpl();
    }

    @Test
    public void calculateThreeSoupAndTwoBread() {
        //Price a basket containing: 3 tins of soup and 2 loaves of bread, bought today
        //(0.65 * 3) + (0.80 * 2) = 3.55 without discount

        BigDecimal totalPrice =
            GetStockItem.getStockItem(ProductType.SOUP).getCost().multiply(BigDecimal.valueOf(3)).add(GetStockItem
                .getStockItem(ProductType.BREAD).getCost().multiply(BigDecimal.valueOf(2)));

        Discount discount = createDiscountObject();
        if (GetDiscount.getStockItem(discount)) {
            totalPrice = totalPrice.subtract(BigDecimal.valueOf(0.40));
        }
        assertEquals(BigDecimal.valueOf(3.15), totalPrice);
    }

    @Test
    public void calculateSixApplesAndMilk() {
        //Price a basket containing: 6 apples and a bottle of milk, bought today
        BigDecimal applePrice = GetStockItem.getStockItem(ProductType.APPLES).getCost().multiply(BigDecimal.valueOf(6));

        BigDecimal totalPrice =
            applePrice.add(GetStockItem
                .getStockItem(ProductType.MILK).getCost());

        Discount discount = createAppleDiscountObject();
        if (GetDiscount.getStockItem(discount)) {
            totalPrice = totalPrice.subtract(applePrice.multiply(BigDecimal.valueOf(0.10)));
        }

        assertEquals(BigDecimal.valueOf(1.90), totalPrice);
    }

    @Test
    public void calculateSixApplesAndMilkInFiveDays() {
        //Price a basket containing: 6 apples and a bottle of milk, bought in 5 days time
        BigDecimal applePrice = GetStockItem.getStockItem(ProductType.APPLES).getCost().multiply(BigDecimal.valueOf(6));
        BigDecimal totalPrice =
            applePrice.add(GetStockItem
                .getStockItem(ProductType.MILK).getCost());

        Discount discount = createAppleDiscountObject();
        if (GetDiscount.getStockItem(discount)) {
            totalPrice = totalPrice.subtract(applePrice.multiply(BigDecimal.valueOf(0.10)));
        }

        assertEquals(BigDecimal.valueOf(1.84), totalPrice);
    }

    @Test
    public void calculateThreeApplesAndTwoSoupInFiveDays() {
        //Price a basket containing: 3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time
        BigDecimal applePrice = GetStockItem.getStockItem(ProductType.APPLES).getCost().multiply(BigDecimal.valueOf(3));
        BigDecimal totalPrice =
            applePrice.add((GetStockItem
                .getStockItem(ProductType.SOUP).getCost()).multiply(BigDecimal.valueOf(2)));

        Discount discount = createAppleDiscountObject();
        if (GetDiscount.getStockItem(discount)) {
            totalPrice = totalPrice.subtract(applePrice.multiply(BigDecimal.valueOf(0.10)));
        }

        assertEquals(BigDecimal.valueOf(1.97), totalPrice);
    }

    @Test
    public void getInputs() {
        assertTrue(shoppingServiceImpl.getInputs());
    }

    private Discount createDiscountObject() {
        return new Discount(
            "Buy 2 tins of soup and get a loaf of bread half price | yesterday | for 7 days",
            2,
            new StockItem(ProductType.SOUP, "tin", BigDecimal.valueOf(0.65)),
            0.5,
            ProductType.BREAD,
            LocalDateTime.now().minusDays(Long.valueOf(1)),
            LocalDateTime.now().plusDays(Long.valueOf(6)));
    }

    private Discount createAppleDiscountObject() {
        return new Discount("Apples have a 10% discount | from 3 days hence | until the end of the following month",
            1,
            new StockItem(ProductType.APPLES, "single", BigDecimal.valueOf(0.10)),
            0.9,
            ProductType.APPLES,
            LocalDateTime.now().minusDays(Long.valueOf(3)),
            LocalDateTime.now().plusMonths(Long.valueOf(2)).minusDays(Long.valueOf(3))
        );
    }

}
