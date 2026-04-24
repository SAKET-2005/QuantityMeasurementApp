/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 7: Addition with Target Unit Specification Test Cases

Description:
This test class validates addition of two length values with explicit
target unit conversion. It ensures the result is correctly converted
into the requested unit.

Covered Scenarios:
- Feet + Inch in Feet
- Feet + Inch in Yard
- Inch + CM in Inch
- Yard + Feet in CM
- Zero value addition

Key Concepts:
- Target Unit Conversion
- Flexible Output Validation
- Unit Arithmetic Consistency
- JUnit 5 Testing

@author SAKET-2005
@version 7.0
================================================================================================================
*/

package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void given1FeetAnd12Inch_inFeet_shouldReturn2Feet()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.add(1, LengthUnit.FEET,
                        12, LengthUnit.INCH,
                        LengthUnit.FEET));
    }

    @Test
    void given1FeetAnd12Inch_inYard_shouldReturnApproxZeroPoint667()
    {
        assertEquals(0.6667,
                QuantityMeasurementApp.add(1, LengthUnit.FEET,
                        12, LengthUnit.INCH,
                        LengthUnit.YARD),
                0.01);
    }

    @Test
    void given12InchAnd2Point54CM_inInch_shouldReturnApprox1Inch()
    {
        assertEquals(1.0,
                QuantityMeasurementApp.add(12, LengthUnit.INCH,
                        2.54, LengthUnit.CM,
                        LengthUnit.INCH),
                0.01);
    }

    @Test
    void given1YardAnd1Feet_inFeet_shouldReturn4Feet()
    {
        assertEquals(4.0,
                QuantityMeasurementApp.add(1, LengthUnit.YARD,
                        1, LengthUnit.FEET,
                        LengthUnit.FEET));
    }

    @Test
    void givenZeroValues_shouldReturnZero()
    {
        assertEquals(0.0,
                QuantityMeasurementApp.add(0, LengthUnit.FEET,
                        0, LengthUnit.INCH,
                        LengthUnit.YARD));
    }
}