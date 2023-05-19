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
        if (test.isSelected()) {
            for (String el : input.getText().split(",")) {
                try {
                    numeric.setNum(el);
                    output.setText(output.getText() + "\n" + numeric.getText().equals(inputTest.getText()));
                } catch (DataFormatException e) {
                    output.setText(output.getText() + "\n" + e.getMessage().equals(inputTest.getText()));
                }
            }
        } else {
            for (String el : input.getText().split(",")) {
                try {
                    numeric.setNum(el);
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