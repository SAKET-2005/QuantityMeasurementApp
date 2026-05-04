/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest (UC13 - DRY Refactor Validation)
================================================================================================================

This test class validates that UC13 refactoring:
- Does NOT change external behavior from UC12
- Maintains correctness of add, subtract, divide
- Preserves equality and conversion logic
- Ensures cross-category safety
- Confirms regression stability after DRY refactor

Important:
UC13 is an internal refactor only → ALL UC12 tests must still pass.

@author SAKET-2005
@version 13.0
================================================================================================================
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    /* ================= ADDITION ================= */

    @Test
    void given10FeetAnd2Feet_shouldReturn12Feet()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        assertEquals(new Quantity<>(12, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    void given1KgAnd1000Gram_shouldReturn2Kg()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2, WeightUnit.KG), q1.add(q2));
    }

    /* ================= SUBTRACTION ================= */

    @Test
    void given10FeetAnd2Feet_shouldReturn8Feet()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        assertEquals(new Quantity<>(8, LengthUnit.FEET), q1.subtract(q2));
    }

    @Test
    void given2KgAnd1Kg_shouldReturn1Kg()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(2, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1, WeightUnit.KG);

        assertEquals(new Quantity<>(1, WeightUnit.KG), q1.subtract(q2));
    }

    @Test
    void given2LitreAnd500Ml_shouldReturn1Point5Litre()
    {
        Quantity<VolumeUnit> q1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(1.5, VolumeUnit.LITRE), q1.subtract(q2));
    }

    /* ================= DIVISION ================= */

    @Test
    void given10FeetAnd2Feet_shouldReturn5()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        assertEquals(5.0, q1.divide(q2));
    }

    @Test
    void given10KgAnd5Kg_shouldReturn2()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(10, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(5, WeightUnit.KG);

        assertEquals(2.0, q1.divide(q2));
    }

    @Test
    void given1LitreAnd1Litre_shouldReturn1()
    {
        Quantity<VolumeUnit> q1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1, VolumeUnit.LITRE);

        assertEquals(1.0, q1.divide(q2));
    }

    /* ================= CROSS CATEGORY SAFETY ================= */

    @Test
    void givenDifferentCategories_shouldNotBeEqual()
    {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KG);

        assertNotEquals(length, weight);
    }
}