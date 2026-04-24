package com.quantity;
/*
================================================================================================================
MAIN CLASS - main.java.com.quantity.QuantityMeasurementApp
================================================================================================================

Use Case 1: Checking Equality of Two Values in Feet

Description:
This program validates and compares two numerical values measured in feet.
It ensures that both inputs are numeric and then checks whether they are equal.

The application handles invalid inputs gracefully and returns a boolean result
indicating whether the two values are equal.

Key Concepts:
- Input Validation
- Equality Comparison
- Exception Handling
- Defensive Programming
- Boolean Result Evaluation

@author SAKET-2005
@version 1.0
================================================================================================================
*/

public class QuantityMeasurementApp
{
    public static boolean areEqual(double value1, double value2)
    {
        return value1 == value2;
    }

    public static void main(String args[])
    {
        System.out.println("=== Quantity Measurement App ===");
        System.out.println("Version: 1.0");
        System.out.println();

        try
        {
            double value1 = Double.parseDouble(args[0]);
            double value2 = Double.parseDouble(args[1]);

            boolean result = areEqual(value1, value2);

            System.out.println("Equality Result: " + result);
        }
        catch (Exception e)
        {
            System.out.println("Error: Invalid input");
        }
    }
}