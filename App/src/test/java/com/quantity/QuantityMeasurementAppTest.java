package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest
{
    @Test
    void testEqualValues()
    {
        assertTrue(QuantityMeasurementApp.areEqual(5.0, 5.0));
    }

    @Test
    void testDifferentValues()
    {
        assertFalse(QuantityMeasurementApp.areEqual(5.0, 6.0));
    }

    @Test
    void testZeroValues()
    {
        assertTrue(QuantityMeasurementApp.areEqual(0.0, 0.0));
    }

    @Test
    void testNegativeValues()
    {
        assertTrue(QuantityMeasurementApp.areEqual(-3.0, -3.0));
    }
}