/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest
================================================================================================================

Use Case 2: Feet and Inches Measurement Equality Test Cases

Description:
This test class validates the correctness of equality operations for Feet and Inches.
It ensures proper handling of:
- Equal values
- Unequal values
- Zero values
- Negative values

The test cases ensure complete coverage of UC2 functionality using JUnit 5.

Key Concepts:
- Unit Testing
- Test Coverage
- Assertion Validation
- JUnit 5 Framework

@author SAKET-2005
@version 2.0
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
        assertTrue(QuantityMeasurementApp.compareFeet(5.0, 5.0));
    }

    @Test
    void givenDifferentFeetValues_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareFeet(5.0, 6.0));
    }

    @Test
    void givenSameInchValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareInches(10.0, 10.0));
    }

    @Test
    void givenDifferentInchValues_shouldReturnFalse()
    {
        assertFalse(QuantityMeasurementApp.compareInches(10.0, 12.0));
    }

    @Test
    void givenZeroFeetValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareFeet(0.0, 0.0));
    }

    @Test
    void givenNegativeInchValues_shouldReturnTrue()
    {
        assertTrue(QuantityMeasurementApp.compareInches(-5.0, -5.0));
    }
}