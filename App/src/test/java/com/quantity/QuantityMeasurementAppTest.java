/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 8: Refactoring Unit Enum to Standalone Test Cases

Description:
This test class validates the refactored architecture where LengthUnit
is a standalone class responsible for conversions. It ensures that all
existing functionality from UC1–UC7 remains intact after refactoring.

Covered Scenarios:
- Unit conversion validation
- Addition across different units
- Cross-unit equality checks
- Backward compatibility verification
- Multi-unit arithmetic correctness

Key Concepts:
- Refactoring Validation
- Regression Testing
- Delegation-based Design Testing
- JUnit 5 Assertions
- System Stability Assurance

@author SAKET-2005
@version 8.0
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
    void given12InchAnd1Feet_shouldReturn2Feet()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.add(1, LengthUnit.FEET,
                        12, LengthUnit.INCH,
                        LengthUnit.FEET));
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
                QuantityMeasurementApp.convert(2.54, LengthUnit.CM, LengthUnit.INCH),
                0.01);
    }

    @Test
    void givenZeroValues_shouldReturnZero()
    {
        assertEquals(0.0,
                QuantityMeasurementApp.add(0, LengthUnit.FEET,
                        0, LengthUnit.INCH,
                        LengthUnit.FEET));
    }
}