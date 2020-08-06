package com.andhradroid.unittestcasedemo;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void add_Success() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);

        Assert.assertEquals(5, result);
    }

    @Test
    public void add_Failed() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);

        Assert.assertNotEquals(6, result);
    }
}
