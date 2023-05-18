package com.exprogs.numerictotext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumericToTextTest {

    @Test
    void getText() {
        NumericToText numeric=new NumericToText(123);
        assertArrayEquals("сто двадцать три".toCharArray(), numeric.getText().toCharArray());
    }
}