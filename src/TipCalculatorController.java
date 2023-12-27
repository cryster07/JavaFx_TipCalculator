// Assignment 3, Tip Calculator
// Name:Safal Ghimire
// StudentID: 99164249
// - JavaFX
// Description: Controller that handles calculateButton and tipPercentageSlider
//              events.

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * Grabs the user input from the text fields. Attempts to parse the String input
 * into numeric values. Errors will display if not valid values. Calculates the
 * check total with tip amount as well as a total amount per person.
 * 
 * @author ghimirsa
 */
public class TipCalculatorController {

    // Formatter for currency and percentages
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default value

    /**
     * The @FXML annotation preceding an instance variable indicates that the
     * variable’s name is used in the FXML file that describes the apps GUI.
     */
    @FXML
    private TextField partyTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField perPersonTextField;

    @FXML
    private TextField totalTextField;

    /**
     * A Buttons event handler receives an ActionEvent, which indicates that
     * the Button was clicked.
     *
     * The @FXML annotation preceding a method indicates that the method can be
     * used to specify a control’s event handler in the FXML file that describes
     * the apps GUI.
     */
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal size = new BigDecimal(Integer.parseInt(partyTextField.getText()));
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            BigDecimal perPerson = total.divide(size);

            tipTextField.setText(currency.format(tip));
            perPersonTextField.setText(currency.format(perPerson));
            totalTextField.setText(currency.format(total));
        } catch (NumberFormatException ex) {
            // Check if the Party Size input is a valid integer
            if (!partyTextField.getText().matches("\\d+")) {
                // Invalid Party Size input
                partyTextField.setText("Enter whole value");
                partyTextField.selectAll();
                partyTextField.requestFocus();
            } else {
                // Invalid Check Amount input
                amountTextField.setText("Enter amount");
                amountTextField.selectAll();
                amountTextField.requestFocus();
            }
        }
    }

    /**
     * Called by FXMLLoader to initialize the controller
     */
    public void initialize() {
        // 0-4 rounds down, 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);

        // Listener for changes to tipPercentageSlider's value
        tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {

            /**
             * 
             * @param ov
             * @param oldValue
             * @param newValue
             */
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                tipPercentageLabel.setText(percent.format(tipPercentage));
            }
        });
    }
}