/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 8: Refactoring Unit Enum to Standalone

Description:
This use case refactors UC1–UC7 by extracting LengthUnit into a standalone class.
The responsibility of unit conversion is moved from QuantityLength to LengthUnit,
improving cohesion and reducing coupling.

The system:
- Uses LengthUnit as a standalone class for all conversions
- Delegates conversion logic to LengthUnit
- Simplifies QuantityLength to focus on arithmetic and comparison
- Maintains backward compatibility with UC1–UC7
- Supports scalable architecture for future measurement types

Key Concepts:
- Single Responsibility Principle (SRP)
- Decoupling of Classes
- Delegation Pattern
- Scalable Architecture Design
- Clean Code Refactoring

@author SAKET-2005
@version 8.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit)
    {
        double baseValue = sourceUnit.toBaseUnit(value);
        return targetUnit.fromBaseUnit(baseValue);
    }

    public static double add(double value1, LengthUnit unit1,
                             double value2, LengthUnit unit2,
                             LengthUnit targetUnit)
    {
        double base1 = unit1.toBaseUnit(value1);
        double base2 = unit2.toBaseUnit(value2);
        double sum = base1 + base2;
        return targetUnit.fromBaseUnit(sum);
    }

    public static void main(String args[])
    {
        System.out.println("Convert 1 Feet to Inch: " +
                convert(1, LengthUnit.FEET, LengthUnit.INCH));

        System.out.println("Add 1 Feet + 12 Inch in Feet: " +
                add(1, LengthUnit.FEET, 12, LengthUnit.INCH, LengthUnit.FEET));
    }
}

class LengthUnit
{
    private final double factorToFeet;

    LengthUnit(double factorToFeet)
    {
        this.factorToFeet = factorToFeet;
    }

    public double toBaseUnit(double value)
    {
        return value * factorToFeet;
    }

    public double fromBaseUnit(double baseValue)
    {
        return baseValue / factorToFeet;
    }

    public static final LengthUnit FEET = new LengthUnit(1.0);
    public static final LengthUnit INCH = new LengthUnit(1.0 / 12.0);
    public static final LengthUnit YARD = new LengthUnit(3.0);
    public static final LengthUnit CM = new LengthUnit(0.0328084);
}

class QuantityLength
{
    private double valueInFeet;

    QuantityLength(double value, LengthUnit unit)
    {
        this.valueInFeet = unit.toBaseUnit(value);
    }

    public boolean isEqual(QuantityLength other)
    {
        return this.valueInFeet == other.valueInFeet;
    }
}