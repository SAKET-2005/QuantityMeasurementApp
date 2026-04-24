/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 6: Addition of Two Length Units (Same Category)

Description:
This use case extends UC5 by introducing addition operations between length measurements.
It allows addition of two lengths in different units (within the same category: Length)
and returns the result in the unit of the first operand.

Example:
1 Feet + 12 Inch = 2 Feet (result in Feet)

The system:
- Converts both values into a base unit (inches)
- Performs addition in base unit
- Converts result back to unit of first operand
- Supports FEET, INCH, YARD, CM
- Ensures type safety within same measurement category

Key Concepts:
- Unit Normalization
- Cross-unit Addition
- Reusability of Conversion Logic
- Encapsulation of Measurement Rules
- Single Responsibility Principle

@author SAKET-2005
@version 6.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    public static double add(double value1, LengthUnit unit1, double value2, LengthUnit unit2)
    {
        QuantityLength l1 = new QuantityLength(value1, unit1);
        QuantityLength l2 = new QuantityLength(value2, unit2);
        return l1.add(l2);
    }

    public static void main(String args[])
    {
        System.out.println("1 Feet + 12 Inch = " +
                add(1, LengthUnit.FEET, 12, LengthUnit.INCH));

        System.out.println("1 Yard + 1 Feet = " +
                add(1, LengthUnit.YARD, 1, LengthUnit.FEET));
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

    public double fromInches(double value)
    {
        return value / inchValue;
    }
}

class QuantityLength
{
    private double valueInInches;
    private LengthUnit unit;

    QuantityLength(double value, LengthUnit unit)
    {
        this.unit = unit;
        this.valueInInches = unit.toInches(value);
    }

    public double add(QuantityLength other)
    {
        double sumInInches = this.valueInInches + other.valueInInches;
        return this.unit.fromInches(sumInInches);
    }
}