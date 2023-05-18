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
        NumericToText numeric = new NumericToText();
        numeric.setNum(Long.parseLong(input.getCharacters().toString()));
        output.setText(numeric.getText());
    }
}