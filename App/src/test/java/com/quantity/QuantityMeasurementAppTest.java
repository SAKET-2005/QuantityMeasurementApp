/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 10: Generic Quantity Class Testing

Description:
This test class validates the generic Quantity<U> implementation using both
LengthUnit and WeightUnit categories.

Covered Scenarios:
- Generic equality comparison
- Generic unit conversion
- Generic addition operations
- Cross-category safety validation
- Regression support for UC1–UC9

Key Concepts:
- Generic Testing
- Type Safety Validation
- Regression Testing
- JUnit 5 Assertions
- Unified Test Strategy

@author SAKET-2005
@version 10.0
================================================================================================================
*/

package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    @Test
    void givenLengthValues_shouldBeEqual()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    @Test
    void givenWeightValues_shouldBeEqual()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(q1, q2);
    }

    @Test
    void givenLengthAddition_shouldReturnCorrectResult()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCH);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    void givenWeightAddition_shouldReturnCorrectResult()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2, WeightUnit.KG), q1.add(q2));
    }

    @Test
    void givenConversion_shouldReturnCorrectValue()
    {
        Quantity<LengthUnit> q = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCH);

        assertEquals(new Quantity<>(12, LengthUnit.INCH), result);
    }

    @Test
    void givenDifferentCategories_shouldNotBeEqual()
    {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KG);

        assertNotEquals(length, weight);
    }
}