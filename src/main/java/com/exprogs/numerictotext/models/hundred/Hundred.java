package com.exprogs.numerictotext.models.hundred;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class Hundred implements HundredInterface{
    private final byte i;

    public Hundred(byte i) {
        this.i = i;
    }

    @Override
    public String getHundred() {
        return ConstantsRU.HUNDRED.get(i - 1);
    }
}
