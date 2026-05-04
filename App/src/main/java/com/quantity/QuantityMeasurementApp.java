/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp (UC13 - DRY Refactor for Arithmetic)
================================================================================================================

This version refactors UC12 by centralizing all arithmetic logic into a single helper method
to eliminate duplication and enforce DRY (Don't Repeat Yourself) principle.

Improvements over UC12:
- Centralized validation logic
- Centralized conversion logic
- Single arithmetic execution flow
- Reduced duplication across add/subtract/divide
- Maintains identical public API behavior

Key Concepts:
- DRY Principle
- Refactoring without behavior change
- Centralized business logic
- Maintainability improvement
- Scalable arithmetic design

@author SAKET-2005
@version 13.0
================================================================================================================
*/

public class QuantityMeasurementApp
{
    public static void main(String[] args)
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        System.out.println("Add: " + q1.add(q2));
        System.out.println("Subtract: " + q1.subtract(q2));
        System.out.println("Divide: " + q1.divide(q2));
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

/* ================= ARITHMETIC ENUM ================= */

enum ArithmeticOperation
{
    ADD, SUBTRACT, DIVIDE
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

    /* ================= PUBLIC API ================= */

    public Quantity<U> add(Quantity<U> other)
    {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit)
    {
        double result = execute(this, other, ArithmeticOperation.ADD);
        return new Quantity<>(round(targetUnit.fromBaseUnit(result)), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other)
    {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit)
    {
        double result = execute(this, other, ArithmeticOperation.SUBTRACT);
        return new Quantity<>(round(targetUnit.fromBaseUnit(result)), targetUnit);
    }

    public double divide(Quantity<U> other)
    {
        double result = execute(this, other, ArithmeticOperation.DIVIDE);
        return result;
    }

    /* ================= CENTRALIZED LOGIC ================= */

    private double execute(Quantity<U> q1, Quantity<U> q2, ArithmeticOperation op)
    {
        validate(q1, q2);

        double base1 = q1.unit.toBaseUnit(q1.value);
        double base2 = q2.unit.toBaseUnit(q2.value);

        return switch (op)
        {
            case ADD -> base1 + base2;
            case SUBTRACT -> base1 - base2;
            case DIVIDE ->
            {
                if (base2 == 0) throw new ArithmeticException("Division by zero");
                yield base1 / base2;
            }
        };
    }

    /* ================= VALIDATION ================= */

    private void validate(Quantity<U> q1, Quantity<U> q2)
    {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Null quantity");

        if (q1.unit.getClass() != q2.unit.getClass())
            throw new IllegalArgumentException("Different categories not allowed");

        if (Double.isNaN(q1.value) || Double.isNaN(q2.value))
            throw new IllegalArgumentException("Invalid number");
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

/* ================= UNITS ================= */

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