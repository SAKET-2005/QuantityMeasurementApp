package com.quantity;/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest (UC11 - Fixed Single File Compatible)
================================================================================================================

This test class is updated to work with:
- Single-file QuantityMeasurementApp setup (no package)
- Generic Quantity<U> implementation
- Length, Weight, and Volume measurement categories

It validates:
- Equality across same categories
- Unit conversion correctness
- Addition across units
- Cross-category safety (compile/runtime isolation)

@author SAKET-2005
@version 11.0
================================================================================================================
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    /* ================= LENGTH TESTS ================= */

    @Test
    void given1FeetAnd12Inch_shouldBeEqual()
    {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inch = new Quantity<>(12, LengthUnit.INCH);

        assertEquals(feet, inch);
    }

    @Test
    void given1FeetAnd1Inch_shouldNotBeEqual()
    {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inch = new Quantity<>(1, LengthUnit.INCH);

        assertNotEquals(feet, inch);
    }

    @Test
    void given1FeetAnd12Inch_shouldAddTo2Feet()
    {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inch = new Quantity<>(12, LengthUnit.INCH);

        Quantity<LengthUnit> result = feet.add(inch);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    @Test
    void given1Feet_shouldConvertTo12Inch()
    {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> result = feet.convertTo(LengthUnit.INCH);

        assertEquals(new Quantity<>(12, LengthUnit.INCH), result);
    }

    /* ================= WEIGHT TESTS ================= */

    @Test
    void given1KgAnd1000Gram_shouldBeEqual()
    {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> gram = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void given1KgAnd500Gram_shouldNotBeEqual()
    {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> gram = new Quantity<>(500, WeightUnit.GRAM);

        assertNotEquals(kg, gram);
    }

    @Test
    void given1KgAnd1000Gram_shouldAddTo2Kg()
    {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> gram = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = kg.add(gram);

        assertEquals(new Quantity<>(2, WeightUnit.KG), result);
    }

    @Test
    void given1Kg_shouldConvertTo1000Gram()
    {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KG);

        Quantity<WeightUnit> result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(new Quantity<>(1000, WeightUnit.GRAM), result);
    }

    /* ================= VOLUME TESTS ================= */

    @Test
    void given1LitreAnd1000Ml_shouldBeEqual()
    {
        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertEquals(litre, ml);
    }

    @Test
    void given1LitreAnd500Ml_shouldNotBeEqual()
    {
        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        assertNotEquals(litre, ml);
    }

    @Test
    void given1LitreAnd500Ml_shouldAddTo1Point5Litre()
    {
        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = litre.add(ml);

        assertEquals(new Quantity<>(1.5, VolumeUnit.LITRE), result);
    }

    @Test
    void given1Gallon_shouldConvertToLitres()
    {
        Quantity<VolumeUnit> gallon = new Quantity<>(1, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(new Quantity<>(3.79, VolumeUnit.LITRE), result);
    }

    /* ================= CROSS CATEGORY TEST ================= */

    @Test
    void givenDifferentCategories_shouldNotBeEqual()
    {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KG);

        assertNotEquals(length, weight);
    }
}