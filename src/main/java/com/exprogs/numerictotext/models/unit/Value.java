package com.exprogs.numerictotext.models.unit;

import com.exprogs.numerictotext.constants.Constants;

public class Value implements ValueInterface {
    private final byte i;

    public Value(byte i) {
        this.i = i;
    }

    @Override
    public String getValue() {
        return Constants.VALUE.get(i - 1);
    }
}
