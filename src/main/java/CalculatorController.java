package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double[] results = calculate(num1, num2);

            double sum = results[0];
            double product = results[1];
            double subtraction = results[2];
            double division = results[3];

            resultLabel.setText("Sum: " + sum + ", Product: " + product +
                               ", Subtraction: " + subtraction + ", Division: " + division);

            ResultService.saveResult(num1, num2, sum, product, subtraction, division);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }

    public double[] calculate(double n1, double n2) {
        double sum = n1 + n2;
        double product = n1 * n2;
        double sub = n1 - n2;
        double div = (n2 != 0) ? n1 / n2 : 0;

        return new double[]{sum, product, sub, div};
    }
}
