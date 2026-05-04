/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 9: Weight Measurement Test Cases

Description:
This test class validates weight measurement functionality alongside length.
It ensures proper conversion, addition, and equality handling for weight units
while preserving existing length functionality.

Covered Scenarios:
- Weight unit conversion (kg, gram, pound)
- Weight addition across units
- Equality comparison for weight
- Regression validation for length features
- Zero and edge case handling

Key Concepts:
- Multi-Domain Testing
- Regression Testing
- Unit Conversion Accuracy
- JUnit 5 Validation
- System Integrity Assurance

@author SAKET-2005
@version 9.0
================================================================================================================
*/

package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    // LENGTH TESTS
    @Test
    void given1Feet_shouldReturn12Inch()
    {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1, LengthUnit.FEET, LengthUnit.INCH));
    }

    // WEIGHT TESTS
    @Test
    void given1Kg_shouldReturn1000Gram()
    {
        assertEquals(1000.0,
                QuantityMeasurementApp.convertWeight(1, WeightUnit.KG, WeightUnit.GRAM));
    }

    @Test
    void given1000Gram_shouldReturn1Kg()
    {
        assertEquals(1.0,
                QuantityMeasurementApp.convertWeight(1000, WeightUnit.GRAM, WeightUnit.KG));
    }

    @Test
    void given1Pound_shouldReturn0Point453Kg()
    {
        assertEquals(0.453592,
                QuantityMeasurementApp.convertWeight(1, WeightUnit.POUND, WeightUnit.KG),
                0.0001);
    }

    @Test
    void given1KgAnd1000Gram_shouldReturn2Kg()
    {
        assertEquals(2.0,
                QuantityMeasurementApp.addWeight(1, WeightUnit.KG,
                        1000, WeightUnit.GRAM,
                        WeightUnit.KG));
    }

    @Test
    void givenZeroWeight_shouldReturnZero()
    {
        assertEquals(0.0,
                QuantityMeasurementApp.addWeight(0, WeightUnit.KG,
                        0, WeightUnit.GRAM,
                        WeightUnit.KG));
    }
}