/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 7: Addition with Target Unit Specification

Description:
This use case extends UC6 by allowing addition of two length measurements
and returning the result in a user-specified target unit.

Unlike UC6, where the result is returned in the unit of the first operand,
this use case gives full flexibility to define the output unit explicitly.

Example:
1 Feet + 12 Inch in YARD = 0.667 YARD (approx)

The system:
- Converts both inputs into a base unit (inches)
- Adds the values in base unit
- Converts the result into the specified target unit
- Supports FEET, INCH, YARD, CM

Key Concepts:
- Flexible Output Unit Selection
- Unit Normalization
- Reusable Conversion Logic
- Enhanced API Design
- Scalable Measurement System

@author SAKET-2005
@version 7.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    public static double add(double value1, LengthUnit unit1,
                             double value2, LengthUnit unit2,
                             LengthUnit targetUnit)
    {
        QuantityLength l1 = new QuantityLength(value1, unit1);
        QuantityLength l2 = new QuantityLength(value2, unit2);
        return l1.addInTargetUnit(l2, targetUnit);
    }

    public static void main(String args[])
    {
        System.out.println("1 Feet + 12 Inch in FEET = " +
                add(1, LengthUnit.FEET, 12, LengthUnit.INCH, LengthUnit.FEET));

        System.out.println("1 Feet + 12 Inch in YARD = " +
                add(1, LengthUnit.FEET, 12, LengthUnit.INCH, LengthUnit.YARD));
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

    public double addInTargetUnit(QuantityLength other, LengthUnit targetUnit)
    {
        double sumInInches = this.valueInInches + other.valueInInches;
        return targetUnit.fromInches(sumInInches);
    }
}