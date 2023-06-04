package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.ConstantsRU;

import java.util.zip.DataFormatException;

public abstract class NumericToText {
    private Number num;
    private Text res;

    public Number getNum() {
        return num;
    }

    public void setNum(String num) throws DataFormatException {
        this.num = new Number(num.replaceAll(ConstantsRU.SPACE, ""));
    }

    public Text getText() {
        return res;
    }

    public void setText(Text res) {
        this.res = res;
    }
    public String getResText() {
        return res.getText().toString().trim();
    }

    public NumericToText() {
    }

    public NumericToText(String num) throws DataFormatException {
        setNum(num);
    }

    public abstract void work();
}