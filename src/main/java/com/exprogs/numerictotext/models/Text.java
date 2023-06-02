package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.Constants;

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

    public void setSuffixOne(byte i) {
        insertWord(Constants.SUFFIX_ONE.get((i / 3) - 1));
    }

    public void setSuffixTwoToFour(byte i) {
        insertWord(Constants.SUFFIX_TWO_TO_FOUR.get((i / 3) - 1));
    }

    public void setSuffixFiveToNineteen(byte i) {
        insertWord(Constants.SUFFIX_FIVE_TO_NINETEEN.get((i / 3) - 1));
    }

    public void setHundred(byte i) {
        insertWord(Constants.HUNDRED.get(i - 1));
    }

    public void setValueUnitDouble(byte i) {
        insertWord(Constants.VALUE_UNIT_DOUBLE.get(i));
    }

    public void setValueDouble(byte i) {
        insertWord(Constants.VALUE_DOUBLE.get(i - 2));
    }

    public void setValueMod(byte i) {
        insertWord(Constants.VALUE_MOD.get(i - 1));
    }

    public void setValue(byte i) {
        insertWord(Constants.VALUE.get(i - 1));
    }
}
