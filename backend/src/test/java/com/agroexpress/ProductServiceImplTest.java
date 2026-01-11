package com.agroexpress;

import com.agroexpress.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    void testCalculateDiscountPercentage_ValidInputs() {
        // Arrange
        double mrpPrice = 100.0;
        double sellingPrice = 80.0;

        // Act
        int discountPercentage = ProductServiceImpl.calculateDiscountPercentage(mrpPrice, sellingPrice);

        // Assert
        assertEquals(20, discountPercentage);
    }

    @Test
    void testCalculateDiscountPercentage_NoDiscount() {
        // Arrange
        double mrpPrice = 100.0;
        double sellingPrice = 100.0;

        // Act
        int discountPercentage = ProductServiceImpl.calculateDiscountPercentage(mrpPrice, sellingPrice);

        // Assert
        assertEquals(0, discountPercentage);
    }

    @Test
    void testCalculateDiscountPercentage_InvalidMrpPrice() {
        // Arrange
        double mrpPrice = 0.0;
        double sellingPrice = 80.0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ProductServiceImpl.calculateDiscountPercentage(mrpPrice, sellingPrice);
        });
        assertEquals("Actual price must be greater than zero.", exception.getMessage());
    }

    @Test
    void testCalculateDiscountPercentage_FullDiscount() {
        // Arrange
        double mrpPrice = 100.0;
        double sellingPrice = 0.0;

        // Act
        int discountPercentage = ProductServiceImpl.calculateDiscountPercentage(mrpPrice, sellingPrice);

        // Assert
        assertEquals(100, discountPercentage);
    }
}