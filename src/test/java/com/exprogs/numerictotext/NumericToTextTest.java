package com.exprogs.numerictotext;

import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class NumericToTextTest {

    @Test
    void getText() throws DataFormatException {
        NumericToText numeric = new NumericToText("0");
        assertEquals("ноль", numeric.getText());
    }
}