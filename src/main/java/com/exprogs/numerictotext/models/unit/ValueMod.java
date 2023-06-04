package com.exprogs.numerictotext.models.unit;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class ValueMod implements ValueInterface {
    private final byte i;

    public ValueMod(byte i) {
        this.i = i;
    }

    @Override
    public String getValue() {
        return ConstantsRU.VALUE_MOD.get(i - 1);
    }
}
