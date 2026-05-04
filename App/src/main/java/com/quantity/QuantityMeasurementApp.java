/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 9: Weight Measurement Support

Description:
This use case extends the application to support weight measurements alongside length.
A new WeightUnit class and QuantityWeight class are introduced, mirroring the design
of LengthUnit and QuantityLength.

The system:
- Supports independent measurement categories: Length and Weight
- Uses WeightUnit for weight conversions (base unit: Kilogram)
- Supports conversion, addition, and equality for weight
- Maintains backward compatibility with UC1–UC8
- Ensures separation between length and weight domains

Key Concepts:
- Multi-Domain Measurement Design
- Reusable Architecture
- Separation of Concerns
- Scalable System Extension
- Consistent Design Patterns

@author SAKET-2005
@version 9.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    // LENGTH METHODS
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
        return targetUnit.fromBaseUnit(base1 + base2);
    }

    // WEIGHT METHODS
    public static double convertWeight(double value, WeightUnit sourceUnit, WeightUnit targetUnit)
    {
        double baseValue = sourceUnit.toBaseUnit(value);
        return targetUnit.fromBaseUnit(baseValue);
    }

    public static double addWeight(double value1, WeightUnit unit1,
                                   double value2, WeightUnit unit2,
                                   WeightUnit targetUnit)
    {
        double base1 = unit1.toBaseUnit(value1);
        double base2 = unit2.toBaseUnit(value2);
        return targetUnit.fromBaseUnit(base1 + base2);
    }

    public static void main(String args[])
    {
        System.out.println("1 Feet to Inch: " +
                convert(1, LengthUnit.FEET, LengthUnit.INCH));

        System.out.println("1 Kg to Gram: " +
                convertWeight(1, WeightUnit.KG, WeightUnit.GRAM));
    }
}

// LENGTH
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

// WEIGHT
class WeightUnit
{
    private final double factorToKg;

    WeightUnit(double factorToKg)
    {
        this.factorToKg = factorToKg;
    }

    public double toBaseUnit(double value)
    {
        return value * factorToKg;
    }

    public double fromBaseUnit(double baseValue)
    {
        return baseValue / factorToKg;
    }

    public static final WeightUnit KG = new WeightUnit(1.0);
    public static final WeightUnit GRAM = new WeightUnit(0.001);
    public static final WeightUnit POUND = new WeightUnit(0.453592);
}

// LENGTH QUANTITY
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

// WEIGHT QUANTITY
class QuantityWeight
{
    private double valueInKg;

    QuantityWeight(double value, WeightUnit unit)
    {
        this.valueInKg = unit.toBaseUnit(value);
    }

    public boolean isEqual(QuantityWeight other)
    {
        return this.valueInKg == other.valueInKg;
    }
}