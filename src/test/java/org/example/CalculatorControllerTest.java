package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @Test
    void testCalculateMath() {
        CalculatorController controller = new CalculatorController();

        // Input: 10 and 2
        double[] results = controller.calculate(10.0, 2.0);

        // Assertions
        assertEquals(12.0, results[0], "Sum should be 12");
        assertEquals(20.0, results[1], "Product should be 20");
        assertEquals(8.0, results[2], "Subtraction should be 8");
        assertEquals(5.0, results[3], "Division should be 5");
    }

    @Test
    void testDivisionByZero() {
        CalculatorController controller = new CalculatorController();

        // Input: 10 and 0
        double[] results = controller.calculate(10.0, 0.0);

        assertEquals(0.0, results[3], "Division by zero should return 0.0 per requirements");
    }
}
