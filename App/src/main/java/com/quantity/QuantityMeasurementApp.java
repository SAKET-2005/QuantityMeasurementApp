/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 5: Unit-to-Unit Conversion (Same Measurement Type)

Description:
This use case extends UC4 by introducing explicit conversion between length units.
Instead of only comparing values, the system provides conversion functionality between
FEET, INCH, YARD, and CM using a centralized enum-based conversion system.

The system:
- Converts any supported unit into a base unit (inches)
- Converts from base unit to target unit
- Provides reusable conversion API
- Maintains centralized conversion logic in LengthUnit enum
- Ensures accurate unit transformation

Key Concepts:
- Unit Conversion API
- Enum-based Design
- Reusable Architecture
- Separation of Concerns
- Scalable Measurement System

@author SAKET-2005
@version 5.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit)
    {
        QuantityLength quantity = new QuantityLength(value, sourceUnit);
        return quantity.convertTo(targetUnit);
    }

    public static void main(String args[])
    {
        System.out.println("1 Feet to Inch: " +
                convert(1, LengthUnit.FEET, LengthUnit.INCH));

        System.out.println("1 Yard to Feet: " +
                convert(1, LengthUnit.YARD, LengthUnit.FEET));

        System.out.println("2.54 CM to Inch: " +
                convert(2.54, LengthUnit.CM, LengthUnit.INCH));
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

    QuantityLength(double value, LengthUnit unit)
    {
        this.valueInInches = unit.toInches(value);
    }

    public double convertTo(LengthUnit targetUnit)
    {
        return targetUnit.fromInches(this.valueInInches);
    }
}