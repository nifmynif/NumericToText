package com.exprogs.numerictotext;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.zip.DataFormatException;

public class HelloController {
    @FXML
    public CheckBox test;
    @FXML
    public TextField inputTest;
    @FXML
    private Label output;
    @FXML
    private TextField input;

    @FXML
    protected void onHelloButtonClick() {
        output.setText("");
        NumericToText numeric = new NumericToText();
        String[] inputElements = input.getText().split(",");
        String[] inputTestElements = inputTest.getText().split(",");
        if (test.isSelected()) {
            for (int i = 0; i < inputElements.length && i < inputTestElements.length; i++) {
                try {
                    numeric.setNum(inputElements[i]);
                    output.setText(output.getText() + "\n" + numeric.getText().equals(inputTestElements[i].trim()));
                } catch (DataFormatException e) {
                    output.setText(output.getText() + "\n" + e.getMessage().equals(inputTestElements[i].trim()));
                }
            }
        } else {
            for (String inputElement : inputElements) {
                try {
                    numeric.setNum(inputElement);
                    output.setText(output.getText() + "\n" + numeric.getText());
                } catch (DataFormatException e) {
                    output.setText(output.getText() + "\n" + e.getMessage());
                }
            }
        }
    }

    public void onCheckboxClick() {
        inputTest.setVisible(!inputTest.isVisible());
    }
}