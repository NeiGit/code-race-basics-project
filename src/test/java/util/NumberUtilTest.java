package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberUtilTest {

    @Test
    @DisplayName("isPositive | true cases")
    void isPositiveTrueCases() {
        Assertions.assertTrue(NumberUtil.isPositive(6));
        assertTrue(NumberUtil.isPositive(2));
        assertTrue(NumberUtil.isPositive(1));
        assertTrue(NumberUtil.isPositive(807));
        assertTrue(NumberUtil.isPositive(190354));
        assertTrue(NumberUtil.isPositive(85948985));
    }

    @Test
    @DisplayName("isPositive | false cases")
    void isPositiveFalseCases() {
        assertFalse(NumberUtil.isPositive(-6));
        assertFalse(NumberUtil.isPositive(-10));
        assertFalse(NumberUtil.isPositive(-103209302));
        assertFalse(NumberUtil.isPositive(-50));

        assertFalse(NumberUtil.isPositive(0));
    }


    @Test
    @DisplayName("isEven | true cases")
    void isEvenTrueCases() {
        assertTrue(NumberUtil.isEven(2));
        assertTrue(NumberUtil.isEven(100));
    }

    @Test
    @DisplayName("isEven | false cases")
    void isEvenFalseCases() {
        assertFalse(NumberUtil.isEven(3));
        assertFalse(NumberUtil.isEven(101));
    }
}