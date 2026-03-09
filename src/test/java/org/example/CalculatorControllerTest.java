package org.example;

import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.Test;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class CalculatorControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        // Load your FXML and start the actual UI
        Parent root = FXMLLoader.load(getClass().getResource("/calculator.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void testCalculateMathUI() {
        // 1. Enter numbers into text fields (replace #id with your actual FXML fx:id)
        clickOn("#number1Field").write("10");
        clickOn("#number2Field").write("2");

        // 2. Click the calculate button
        clickOn("#calculateButton");

        // 3. Verify the labels show the correct results
        verifyThat("#resultLabel", hasText("Sum: 12.0, Product: 20.0, Subtraction: 8.0, Division: 5.0"));
    }

    @Test
    void testDivisionByZeroUI() {
        clickOn("#number1Field").write("10");
        clickOn("#number2Field").write("0");
        clickOn("#calculateButton");

        verifyThat("#resultLabel", hasText("Sum: 10.0, Product: 0.0, Subtraction: 10.0, Division: 0.0"));
    }
}
