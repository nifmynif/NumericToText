package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.Constants;
import com.exprogs.numerictotext.models.hundred.HundredInterface;
import com.exprogs.numerictotext.models.suffix.SuffixInterface;
import com.exprogs.numerictotext.models.ten.TenInterface;
import com.exprogs.numerictotext.models.unit.ValueInterface;

public class Text {
    private final StringBuilder text;

    public Text() {
        this.text = new StringBuilder(" ");
    }

    public String setNegativeSign() {
        return text.insert(0, "минус ").toString().trim();
    }

    public String setPositiveSign() {
        return text.toString().trim();
    }

    public Text returnZero() {
        text.append(Constants.ZERO);
        return this;
    }

    public boolean isTripleZero(byte i) {
        return text.substring(0, text.indexOf(Constants.SPACE)).contains(Constants.SUFFIX.get((i / 3) - 2));
    }

    public void removeFirstWord() {
        text.delete(0, text.indexOf(Constants.SPACE) + 1);
    }

    private void insertWord(String word) {
        text.insert(0, Constants.SPACE).insert(0, word);
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
