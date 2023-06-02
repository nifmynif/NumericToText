package com.exprogs.numerictotext;

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

    public void insertWord(String word) {
        text.insert(0, Constants.SPACE).insert(0, word);
    }
}
