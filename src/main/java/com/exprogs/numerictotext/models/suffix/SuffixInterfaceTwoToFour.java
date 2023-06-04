package com.exprogs.numerictotext.models.suffix;

import com.exprogs.numerictotext.constants.ConstantsRU;

public class SuffixInterfaceTwoToFour implements SuffixInterface {
    private  final  byte i;

    public SuffixInterfaceTwoToFour(byte i) {
        this.i = i;
    }

    @Override
    public String getSuffix() {
        return ConstantsRU.SUFFIX_TWO_TO_FOUR.get((i / 3) - 1);
    }
}
