package com.exprogs.numerictotext.models.ten;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class Double implements TenInterface{
    private final byte i;

    public Double(byte i) {
        this.i = i;
    }

    @Override
    public String getTen() {
        return ConstantsRU.VALUE_DOUBLE.get(i - 2);
    }
}
