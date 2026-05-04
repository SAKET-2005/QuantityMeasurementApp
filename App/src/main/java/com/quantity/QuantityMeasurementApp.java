/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp (UC12 - Subtraction & Division)
================================================================================================================

This version extends UC11 by adding:
- Subtraction of quantities (same category only)
- Division of quantities (returns scalar ratio)

Supports:
- Length, Weight, Volume
- Generic Quantity<U>
- Full unit conversion + arithmetic operations

@author SAKET-2005
@version 12.0
================================================================================================================
*/

public class QuantityMeasurementApp
{
    public static void main(String[] args)
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        System.out.println("Subtraction: " + q1.subtract(q2));
        System.out.println("Division: " + q1.divide(q2));

        Quantity<VolumeUnit> v1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtraction: " + v1.subtract(v2));
    }
}

/* ================= INTERFACE ================= */

interface IMeasurable
{
    double getConversionFactor();
    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);
    String getUnitName();
}

/* ================= GENERIC CLASS ================= */

class Quantity<U extends IMeasurable>
{
    private final double value;
    private final U unit;

    public Quantity(double value, U unit)
    {
        this.value = value;
        this.unit = unit;
    }

    /* ================= CONVERT ================= */

    public Quantity<U> convertTo(U targetUnit)
    {
        double base = unit.toBaseUnit(value);
        return new Quantity<>(round(targetUnit.fromBaseUnit(base)), targetUnit);
    }

    /* ================= ADD ================= */

    public Quantity<U> add(Quantity<U> other)
    {
        double base = unit.toBaseUnit(value) + other.unit.toBaseUnit(other.value);
        return new Quantity<>(round(unit.fromBaseUnit(base)), unit);
    }

    /* ================= SUBTRACT ================= */

    public Quantity<U> subtract(Quantity<U> other)
    {
        double base = unit.toBaseUnit(value) - other.unit.toBaseUnit(other.value);
        return new Quantity<>(round(unit.fromBaseUnit(base)), unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit)
    {
        double base = unit.toBaseUnit(value) - other.unit.toBaseUnit(other.value);
        return new Quantity<>(round(targetUnit.fromBaseUnit(base)), targetUnit);
    }

    /* ================= DIVIDE ================= */

    public double divide(Quantity<U> other)
    {
        double base1 = unit.toBaseUnit(value);
        double base2 = other.unit.toBaseUnit(other.value);

        if (base2 == 0) throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    /* ================= EQUALITY ================= */

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> that)) return false;

        if (this.unit.getClass() != that.unit.getClass())
            return false;

        return Math.abs(
                this.unit.toBaseUnit(this.value) -
                        that.unit.toBaseUnit(that.value)
        ) < 0.0001;
    }

    @Override
    public String toString()
    {
        return value + " " + unit.getUnitName();
    }

    private double round(double v)
    {
        return Math.round(v * 100.0) / 100.0;
    }
}

/* ================= LENGTH ================= */

enum LengthUnit implements IMeasurable
{
    FEET(1.0, "Feet"),
    INCH(1.0 / 12.0, "Inch"),
    YARD(3.0, "Yard"),
    CM(0.0328084, "CM");

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

/* ================= WEIGHT ================= */

enum WeightUnit implements IMeasurable
{
    KG(1.0, "Kg"),
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

/* ================= VOLUME ================= */

enum VolumeUnit implements IMeasurable
{
    LITRE(1.0, "Litre"),
    MILLILITRE(0.001, "Millilitre"),
    GALLON(3.78541, "Gallon");

    private final double factor;
    private final String name;

    VolumeUnit(double factor, String name)
    {
        this.factor = factor;
        this.name = name;
    }

    public double getConversionFactor() { return factor; }

    public double toBaseUnit(double value) { return value * factor; }

    public double fromBaseUnit(double baseValue) { return baseValue / factor; }

    public String getUnitName() { return name; }
}