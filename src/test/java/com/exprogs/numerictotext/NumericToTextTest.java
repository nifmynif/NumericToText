package com.exprogs.numerictotext;

import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class NumericToTextTest {

    @Test
    void getTextException() {
        try {
            NumericToText numeric = new NumericToText("");
            assertEquals("DataFormatException", numeric.getText());
        } catch (DataFormatException e) {
            assertEquals("введено не число", e.getMessage());
        }
    }
    @Test
    void getTextZero() throws DataFormatException {
            NumericToText numeric = new NumericToText("0");
            assertEquals("ноль", numeric.getText());
    }
    @Test
    void getTextOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("1");
        assertEquals("один", numeric.getText());
    }
    @Test
    void getTextMinesOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("-1");
        assertEquals("Минус один", numeric.getText());
    }
    @Test
    void getTextMinesOneHausenOneHandedOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("1 101");
        assertEquals("одна тысяча сто один", numeric.getText());
    }
}