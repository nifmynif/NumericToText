package com.exprogs.numerictotext.models.ten;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class UnitDouble implements TenInterface{
    private final byte i;

    public UnitDouble(byte i) {
        this.i = i;
    }

    @Override
    public String getTen() {
        return ConstantsRU.VALUE_UNIT_DOUBLE.get(i);
    }
}
