/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 3: Generic Quantity Class Test Cases

Description:
This test class validates the generic QuantityLength implementation.
It ensures correct conversion and comparison across different units.

Covered Scenarios:
- Same unit comparison (FEET, INCH)
- Cross-unit comparison (INCH ↔ FEET)
- Equal and unequal value checks

Key Concepts:
- Unit Testing (JUnit 5)
- Cross-Unit Validation
- Conversion Verification
- Test Coverage

@author SAKET-2005
@version 3.0
================================================================================================================
*/
package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void givenSameFeetValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(5, "FEET", 5, "FEET"));
    }

    @Test
    void givenDifferentFeetValues_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareLength(5, "FEET", 6, "FEET"));
    }

    @Test
    void given12InchAnd1Feet_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(12, "INCH", 1, "FEET"));
    }

    @Test
    void given1InchAnd1Feet_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareLength(1, "INCH", 1, "FEET"));
    }

    @Test
    void givenSameInchValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(10, "INCH", 10, "INCH"));
    }

    @Test
    void givenDifferentUnitsSameValue_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareLength(1, "FEET", 1, "INCH"));
    }
}