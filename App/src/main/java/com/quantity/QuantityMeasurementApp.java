/*
================================================================================================================
MAIN CLASS - QuantityMeasurementApp
================================================================================================================

Use Case 2: Feet and Inches Measurement Equality

Description:
This use case extends UC1 to support equality checks for both Feet and Inches.
Feet and Inches are treated as separate units and are not inter-converted.

The system:
- Compares two feet values using a Feet class
- Compares two inch values using an Inches class
- Each class validates and compares values independently
- Returns boolean result for equality check

Key Concepts:
- Class-based Unit Representation
- Encapsulation of Measurement Types
- Equality Validation
- Separation of Concerns
- Unit Testing Support

@author SAKET-2005
@version 2.0
================================================================================================================
*/
package com.quantity;

public class QuantityMeasurementApp
{
    public static boolean compareFeet(double feet1, double feet2)
    {
        Feet f1 = new Feet(feet1);
        Feet f2 = new Feet(feet2);
        return f1.isEqual(f2);
    }

    public static boolean compareInches(double inch1, double inch2)
    {
        Inches i1 = new Inches(inch1);
        Inches i2 = new Inches(inch2);
        return i1.isEqual(i2);
    }

    public static void main(String args[])
    {
        System.out.println("Feet Comparison Result: " + compareFeet(5.0, 5.0));
        System.out.println("Inches Comparison Result: " + compareInches(10.0, 10.0));
    }
}

class Feet
{
    private double value;

    Feet(double value)
    {
        this.value = value;
    }

    public boolean isEqual(Feet other)
    {
        return this.value == other.value;
    }
}

class Inches
{
    private double value;

    Inches(double value)
    {
        this.value = value;
    }

    public boolean isEqual(Inches other)
    {
        return this.value == other.value;
    }
}