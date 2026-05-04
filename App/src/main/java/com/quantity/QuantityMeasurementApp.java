/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 10: Generic Quantity Class with Unit Interface

Description:
This use case refactors the application into a generic and scalable design by introducing
a common IMeasurable interface and a single generic Quantity<U> class.

The system:
- Eliminates duplicate QuantityLength and QuantityWeight classes
- Introduces IMeasurable interface for all unit types
- Refactors LengthUnit and WeightUnit to implement IMeasurable
- Uses a single generic Quantity<U> class for all measurement categories
- Ensures type safety using Java generics
- Prevents cross-category comparisons (e.g., length vs weight)
- Maintains all functionality from UC1–UC9

Key Concepts:
- Generics in Java
- Interface-based Design
- DRY Principle (Don't Repeat Yourself)
- Type Safety & Compile-time Checks
- Scalable Architecture

@author SAKET-2005
@version 10.0
================================================================================================================
*/

package com.quantity;

public class QuantityMeasurementApp
{
    public static void main(String[] args)
    {
        Quantity<LengthUnit> length1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12, LengthUnit.INCH);

        System.out.println("Length Equality: " + length1.equals(length2));
        System.out.println("Length Addition: " + length1.add(length2));

        Quantity<WeightUnit> weight1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + weight1.equals(weight2));
        System.out.println("Weight Addition: " + weight1.add(weight2));
    }
}

interface IMeasurable
{
    double getConversionFactor();
    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);
    String getUnitName();
}

enum LengthUnit implements IMeasurable
{
    FEET(1.0, "Feet"),
    INCH(1.0 / 12.0, "Inch"),
    YARD(3.0, "Yard"),
    CM(0.0328084, "Centimeter");

    private final double factor;
    private final String name;

    LengthUnit(double factor, String name)
    {
        this.factor = factor;
        this.name = name;
    }

    public double getConversionFactor() { return factor; }

    public double toBaseUnit(double value) { return value * factor; }

    public double fromBaseUnit(double baseValue) { return baseValue / factor; }

    public String getUnitName() { return name; }
}

enum WeightUnit implements IMeasurable
{
    KG(1.0, "Kilogram"),
    GRAM(0.001, "Gram"),
    POUND(0.453592, "Pound");

    private final double factor;
    private final String name;

    WeightUnit(double factor, String name)
    {
        this.factor = factor;
        this.name = name;
    }

    public double getConversionFactor() { return factor; }

    public double toBaseUnit(double value) { return value * factor; }

    public double fromBaseUnit(double baseValue) { return baseValue / factor; }

    public String getUnitName() { return name; }
}

class Quantity<U extends IMeasurable>
{
    private final double value;
    private final U unit;

    public Quantity(double value, U unit)
    {
        if (unit == null || Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid input");

        this.value = value;
        this.unit = unit;
    }

    public Quantity<U> convertTo(U targetUnit)
    {
        double base = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other)
    {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit)
    {
        if (other == null) throw new IllegalArgumentException("Null quantity");

        double base1 = unit.toBaseUnit(value);
        double base2 = other.unit.toBaseUnit(other.value);
        double sum = base1 + base2;

        double result = targetUnit.fromBaseUnit(sum);
        return new Quantity<>(round(result), targetUnit);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> that)) return false;

        if (this.unit.getClass() != that.unit.getClass())
            return false;

        double base1 = unit.toBaseUnit(value);
        double base2 = that.unit.toBaseUnit(that.value);

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public int hashCode()
    {
        return Double.hashCode(unit.toBaseUnit(value));
    }

    @Override
    public String toString()
    {
        return value + " " + unit.getUnitName();
    }

    private double round(double val)
    {
        return Math.round(val * 100.0) / 100.0;
    }
}