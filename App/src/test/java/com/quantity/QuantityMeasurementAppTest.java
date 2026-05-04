/*
================================================================================================================
TEST CLASS - QuantityMeasurementAppTest (UC12)
================================================================================================================

Tests:
- Equality
- Conversion
- Addition
- Subtraction
- Division
- Cross-category safety

@author SAKET-2005
@version 12.0
================================================================================================================
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest
{
    /* ================= LENGTH ================= */

    @Test
    void given2FeetAnd1Feet_shouldReturn1Feet()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(new Quantity<>(1, LengthUnit.FEET), q1.subtract(q2));
    }

    @Test
    void given10FeetAnd2Feet_shouldReturn5Ratio()
    {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        assertEquals(5.0, q1.divide(q2));
    }

    /* ================= WEIGHT ================= */

    @Test
    void given10KgAnd5Kg_shouldReturn2Ratio()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(10, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(5, WeightUnit.KG);

        assertEquals(2.0, q1.divide(q2));
    }

    @Test
    void given2KgAnd1Kg_shouldReturn1Kg()
    {
        Quantity<WeightUnit> q1 = new Quantity<>(2, WeightUnit.KG);
        Quantity<WeightUnit> q2 = new Quantity<>(1, WeightUnit.KG);

        assertEquals(new Quantity<>(1, WeightUnit.KG), q1.subtract(q2));
    }

    /* ================= VOLUME ================= */

    @Test
    void given2LitreAnd500Ml_shouldReturn1Point5Litre()
    {
        Quantity<VolumeUnit> q1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(1.5, VolumeUnit.LITRE), q1.subtract(q2));
    }

    @Test
    void given1LitreAnd1Litre_shouldReturn1Ratio()
    {
        Quantity<VolumeUnit> q1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1, VolumeUnit.LITRE);

        assertEquals(1.0, q1.divide(q2));
    }

    /* ================= SAFETY ================= */

    @Test
    void givenDifferentCategories_shouldNotBeEqual()
    {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KG);

        assertNotEquals(length, weight);
    }
}