package com.exprogs.numerictotext.models.suffix;

import com.exprogs.numerictotext.constants.Constants;

public class SuffixInterfaceFiveToNineteen implements SuffixInterface {
    private final byte i;

    public SuffixInterfaceFiveToNineteen(byte i) {
        this.i = i;
    }

    @Override
    public String getSuffix() {
        return Constants.SUFFIX_FIVE_TO_NINETEEN.get((i / 3) - 1);
    }
}
