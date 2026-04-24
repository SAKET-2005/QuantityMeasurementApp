/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 3: Generic Quantity Class for DRY Principle

Description:
This use case refactors UC1 and UC2 by introducing a single generic QuantityLength class.
It removes duplication between Feet and Inches classes and follows the DRY (Don't Repeat Yourself) principle.

The system:
- Accepts two values with unit types (FEET, INCH)
- Converts all values into a common base unit (feet)
- Compares converted values for equality
- Supports easy extension for future units

Key Concepts:
- DRY Principle
- Code Refactoring
- Unit Conversion
- Encapsulation
- Scalability in Design

@author SAKET-2005
@version 3.0
================================================================================================================
*/
package com.quantity;

public class QuantityMeasurementApp
{
    public static boolean compareLength(double value1, String unit1, double value2, String unit2)
    {
        QuantityLength q1 = new QuantityLength(value1, unit1);
        QuantityLength q2 = new QuantityLength(value2, unit2);
        return q1.isEqual(q2);
    }

    public static void main(String args[])
    {
        System.out.println("Feet vs Feet: " + compareLength(1, "FEET", 1, "FEET"));
        System.out.println("Inch vs Inch: " + compareLength(12, "INCH", 12, "INCH"));
    }
}

class QuantityLength
{
    private double valueInFeet;

    private static final double INCH_TO_FEET = 1.0 / 12.0;
    private static final double FEET_TO_FEET = 1.0;

    QuantityLength(double value, String unit)
    {
        this.valueInFeet = convertToFeet(value, unit);
    }

    private double convertToFeet(double value, String unit)
    {
        if (unit.equalsIgnoreCase("FEET"))
            return value * FEET_TO_FEET;
        if (unit.equalsIgnoreCase("INCH"))
            return value * INCH_TO_FEET;
        return 0;
    }

    public boolean isEqual(QuantityLength other)
    {
        return this.valueInFeet == other.valueInFeet;
    }
}