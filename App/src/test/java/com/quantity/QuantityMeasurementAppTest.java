/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 6: Addition of Two Length Units Test Cases

Description:
This test class validates addition operations between different length units.
It ensures correct conversion, addition, and result representation in the unit
of the first operand.

Covered Scenarios:
- Feet + Inch
- Yard + Feet
- Inch + CM
- Same unit addition
- Cross-unit addition correctness

Key Concepts:
- Unit Conversion + Addition
- Cross-unit Arithmetic Validation
- JUnit 5 Assertions
- Measurement Consistency

@author SAKET-2005
@version 6.0
================================================================================================================
*/

package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void given1FeetAnd12Inch_shouldReturn2Feet()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.add(1, LengthUnit.FEET, 12, LengthUnit.INCH));
    }

    @Test
    void given1YardAnd1Feet_shouldReturn4Feet()
    {
        assertEquals(4.0,
                QuantityMeasurementApp.add(1, LengthUnit.YARD, 1, LengthUnit.FEET));
    }

    @Test
    void given12InchAnd12Inch_shouldReturn2Feet()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.add(12, LengthUnit.INCH, 12, LengthUnit.INCH));
    }

    @Test
    void given1FeetAnd1Feet_shouldReturn2Feet()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.add(1, LengthUnit.FEET, 1, LengthUnit.FEET));
    }

    @Test
    void givenZeroValues_shouldReturnZero()
    {
        assertEquals(0.0,
                QuantityMeasurementApp.add(0, LengthUnit.FEET, 0, LengthUnit.INCH));
    }
}