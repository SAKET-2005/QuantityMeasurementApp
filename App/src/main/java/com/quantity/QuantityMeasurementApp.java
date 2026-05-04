/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp (UC11 - Single File Version)
================================================================================================================

This version combines UC10 + UC11 into a single file to avoid:
- Missing class errors
- Package/classpath issues
- Multi-file dependency problems

Supports:
- Length (Feet, Inch, Yard, CM)
- Weight (Kg, Gram, Pound)
- Volume (Litre, Millilitre, Gallon)

All categories use a single generic Quantity<U> class.

@author SAKET-2005
@version 11.0
================================================================================================================
*/

public class QuantityMeasurementApp
{
    public static void main(String[] args)
    {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        System.out.println("Length: " + length);

        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KG);
        System.out.println("Weight: " + weight);

        Quantity<VolumeUnit> volume = new Quantity<>(1, VolumeUnit.LITRE);
        System.out.println("Volume: " + volume);

        System.out.println("1 Feet = " +
                new Quantity<>(1, LengthUnit.FEET).convertTo(LengthUnit.INCH));
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

    public Quantity<U> convertTo(U targetUnit)
    {
        double base = unit.toBaseUnit(value);
        double result = targetUnit.fromBaseUnit(base);
        return new Quantity<>(round(result), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other)
    {
        double base1 = unit.toBaseUnit(value);
        double base2 = other.unit.toBaseUnit(other.value);
        double sum = base1 + base2;

        double result = unit.fromBaseUnit(sum);
        return new Quantity<>(round(result), unit);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> that)) return false;

        if (this.unit.getClass() != that.unit.getClass())
            return false;

        double b1 = unit.toBaseUnit(value);
        double b2 = that.unit.toBaseUnit(that.value);

        return Math.abs(b1 - b2) < 0.0001;
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