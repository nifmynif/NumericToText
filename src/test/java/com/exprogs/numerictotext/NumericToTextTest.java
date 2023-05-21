package com.exprogs.numerictotext;

import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class NumericToTextTest {

    @Test
    void getTextWrongNumberException() {
        try {
            NumericToText numeric = new NumericToText("");
            numeric.getText();
        } catch (DataFormatException e) {
            assertEquals("введено не число", e.getMessage());
        }
    }

    @Test
    void getTextBigNumberException() {
        try {
            new NumericToText("1".repeat(((Constants.SUFFIX.size() + 1) * 3) + 1));
        } catch (IndexOutOfBoundsException e) {
            assertEquals("мы еще не придумали названия этому числу(", e.getMessage());
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
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
        NumericToText numeric = new NumericToText();
        numeric.setNum("-1");
        assertEquals("Минус один", numeric.getText());
    }

    @Test
    void getTextEleven() throws DataFormatException {
        NumericToText numeric = new NumericToText("11");
        assertEquals("одиннадцать", numeric.getText());
    }

    @Test
    void getTextTwenty() throws DataFormatException {
        NumericToText numeric = new NumericToText("20");
        assertEquals("двадцать", numeric.getText());
    }

    @Test
    void getTextMinesOneHausenOneHandedOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("1 101");
        assertEquals("одна тысяча сто один", numeric.getText());
    }
}