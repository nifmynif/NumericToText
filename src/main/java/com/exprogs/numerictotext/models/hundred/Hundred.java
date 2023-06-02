package com.exprogs.numerictotext.models.hundred;

import com.exprogs.numerictotext.constants.Constants;

public class Hundred implements HundredInterface{
    private final byte i;

    public Hundred(byte i) {
        this.i = i;
    }

    @Override
    public String getHundred() {
        return Constants.HUNDRED.get(i - 1);
    }
}
