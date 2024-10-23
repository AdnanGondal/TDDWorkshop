package org.example.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSum_AddsNumbersCorrectly_whenTwoNumbersSupplied() {
        // Build
        int a = 1;
        int b = 2;
        Calculator calc = new Calculator();

        // Act
        int res = calc.sum(a,b);

        // Assert
        assertEquals(3,res);
        assertTrue(res > 0);
        assertThat(res).isEqualTo(3);

    }

    @Test
    void testSubtract_givesCorrectResult_whenTwoNumbersSupplied() {
        // Build
        int a=3;
        int b=1;
        Calculator calc = new Calculator();

        // Act
        int res = calc.subtract(a,b);

        // Assert
        assertEquals(2, res);

    }

    @Test
    void testSubtract_givesCorrectNegativeResult_whenTwoNumbersSupplied() {
        // Build
        int a=1;
        int b=3;
        Calculator calc = new Calculator();

        // Act
        int res = calc.subtract(a,b);

        // Assert
        assertEquals(-2, res);
    }


}