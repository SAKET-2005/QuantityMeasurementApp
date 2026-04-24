/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 5: Unit-to-Unit Conversion Test Cases

Description:
This test class validates conversion between different length units.
It ensures correctness of conversion logic across FEET, INCH, YARD, and CM.

Covered Scenarios:
- Feet to Inch conversion
- Yard to Feet conversion
- CM to Inch conversion
- Inch to Feet conversion
- Zero value conversion

Key Concepts:
- Unit Conversion Testing
- Precision Validation
- JUnit 5 Assertions
- Cross-unit correctness verification

@author SAKET-2005
@version 5.0
================================================================================================================
*/

package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void given1Feet_shouldReturn12Inch()
    {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1, LengthUnit.FEET, LengthUnit.INCH));
    }

    @Test
    void given1Yard_shouldReturn3Feet()
    {
        assertEquals(3.0,
                QuantityMeasurementApp.convert(1, LengthUnit.YARD, LengthUnit.FEET));
    }

    @Test
    void given2Point54CM_shouldReturn1Inch()
    {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(2.54, LengthUnit.CM, LengthUnit.INCH));
    }

    @Test
    void given12Inch_shouldReturn1Feet()
    {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(12, LengthUnit.INCH, LengthUnit.FEET));
    }

    @Test
    void givenZeroValue_shouldReturnZero()
    {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0, LengthUnit.FEET, LengthUnit.YARD));
    }
}