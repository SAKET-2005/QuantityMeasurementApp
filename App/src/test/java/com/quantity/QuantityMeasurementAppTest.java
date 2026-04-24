/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 4: Extended Unit Support Test Cases

Description:
This test class validates multi-unit conversion across FEET, INCH,
YARD, and CM. It ensures correct normalization and equality checking
after conversion to a base unit.

Covered Scenarios:
- Feet to Inch conversion
- Yard to Feet conversion
- CM to Inch conversion
- Cross-unit comparisons
- Zero value validation

Key Concepts:
- Multi-unit Testing
- Conversion Accuracy
- JUnit Validation
- Cross-Unit Equality Checks

@author SAKET-2005
@version 4.0
================================================================================================================
*/
package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void given1YardAnd3Feet_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(1, LengthUnit.YARD, 3, LengthUnit.FEET));
    }

    @Test
    void given1FeetAnd12Inch_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(1, LengthUnit.FEET, 12, LengthUnit.INCH));
    }

    @Test
    void given2InchAnd5CM_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(2.54, LengthUnit.CM, 1, LengthUnit.INCH));
    }

    @Test
    void givenDifferentFeetAndYard_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareLength(1, LengthUnit.FEET, 2, LengthUnit.YARD));
    }

    @Test
    void givenZeroValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareLength(0, LengthUnit.FEET, 0, LengthUnit.INCH));
    }
}