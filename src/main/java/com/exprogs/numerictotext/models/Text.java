package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.ConstantsRU;
import com.exprogs.numerictotext.models.hundred.HundredInterface;
import com.exprogs.numerictotext.models.suffix.SuffixInterface;
import com.exprogs.numerictotext.models.ten.TenInterface;
import com.exprogs.numerictotext.models.unit.ValueInterface;

public class Text {
    private final StringBuilder text;

    public StringBuilder getText() {
        return text;
    }

    public Text() {
        this.text = new StringBuilder(" ");
    }

    public Text setNegativeSign() {
        text.insert(0, "минус ");
        return this;
    }

    public Text setPositiveSign() {
        return this;
    }

    public Text returnZero() {
        text.append(ConstantsRU.ZERO);
        return this;
    }

    public boolean isTripleZero(byte i) {//if the zeros go one after the other three times
        return text.substring(0, text.indexOf(ConstantsRU.SPACE)).contains(ConstantsRU.SUFFIX.get((i / 3) - 2));
    }

    public void removeFirstWord() {
        text.delete(0, text.indexOf(ConstantsRU.SPACE) + 1);
    }

    private void insertWord(String word) {
        text.insert(0, ConstantsRU.SPACE).insert(0, word);
    }

    public void setSuffix(SuffixInterface suffix) {
        insertWord(suffix.getSuffix());
    }

    public void setHundred(HundredInterface hundred) {
        insertWord(hundred.getHundred());
    }

    public void setTen(TenInterface ten) {
        insertWord(ten.getTen());
    }

    public void setValue(ValueInterface value) {
        insertWord(value.getValue());
    }
}
