package com.exprogs.numerictotext;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label output;
    @FXML
    private TextField input;

    @FXML
    protected void onHelloButtonClick() {
        output.setText("");
        NumericToText numeric = new NumericToText();
        for (String el : input.getText().split(",")) {
            numeric.setNum(el);
            output.setText(output.getText() + "\n" + numeric.getText());
        }
    }
}