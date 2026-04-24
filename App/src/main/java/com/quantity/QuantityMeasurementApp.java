/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 4: Extended Unit Support (Feet, Inches, Yards, Centimeters)

Description:
This use case extends UC3 by adding support for additional length units:
Yards and Centimeters. All units are handled using a unified enum-based
conversion system, improving scalability and maintainability.

The system:
- Supports FEET, INCH, YARD, CM
- Converts all units into a common base unit (inches)
- Uses LengthUnit enum for conversion factors
- Compares values after normalization
- Ensures extensibility without modifying core logic

Key Concepts:
- Enum-based Design
- Unit Conversion System
- Scalability of Generic Class
- DRY Principle Reinforcement
- Extensible Architecture

@author SAKET-2005
@version 4.0
================================================================================================================
*/
package com.quantity;

public class QuantityMeasurementApp
{
    public static boolean compareLength(double value1, LengthUnit unit1, double value2, LengthUnit unit2)
    {
        QuantityLength q1 = new QuantityLength(value1, unit1);
        QuantityLength q2 = new QuantityLength(value2, unit2);
        return q1.isEqual(q2);
    }

    public static void main(String args[])
    {
        System.out.println("1 Yard = 3 Feet: " +
                compareLength(1, LengthUnit.YARD, 3, LengthUnit.FEET));

        System.out.println("2 Feet = 24 Inch: " +
                compareLength(2, LengthUnit.FEET, 24, LengthUnit.INCH));

        System.out.println("1 CM comparison: " +
                compareLength(2.54, LengthUnit.CM, 1, LengthUnit.INCH));
    }
}

enum LengthUnit
{
    FEET(12.0),
    INCH(1.0),
    YARD(36.0),
    CM(0.393701);

    private final double inchValue;

    LengthUnit(double inchValue)
    {
        this.inchValue = inchValue;
    }

    public double toInches(double value)
    {
        return value * inchValue;
    }
}

class QuantityLength
{
    private double valueInInches;

    QuantityLength(double value, LengthUnit unit)
    {
        this.valueInInches = unit.toInches(value);
    }

    public boolean isEqual(QuantityLength other)
    {
        return this.valueInInches == other.valueInInches;
    }
}