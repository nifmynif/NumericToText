package com.exprogs.numerictotext.models.suffix;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class SuffixInterfaceOne implements SuffixInterface {
    private final byte i;

    public SuffixInterfaceOne(byte i) {
        this.i = i;
    }

    @Override
    public String getSuffix() {
        return ConstantsRU.SUFFIX_ONE.get((i / 3) - 1);
    }
}
