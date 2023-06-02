package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.Constants;

import java.util.zip.DataFormatException;

public class NumericToText {
    private Number num;
    private Text res;

    public void setNum(String num) throws DataFormatException {
        this.num = new Number(num.replaceAll(Constants.SPACE, ""));
    }

    public NumericToText() {
    }

    public NumericToText(String num) throws DataFormatException {
        setNum(num);
    }

    public String getText() {
        res = new Text();
        if (!num.getSign())
            return numericToText(num, (byte) 0).setNegativeSign();
        else
            return numericToText(num, (byte) 0).setPositiveSign();
    }

    private Text numericToText(Number num, byte i) {
        if (num.checkZero() && i == 0)
            return res.returnZero();
        if (num.checkZero())
            return res;
        byte unit = num.getLastNumber();
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {//Проверка на суффиксы (после каждых трех цифр)
            if (i / 3 - 2 >= 0 && res.isTripleZero(i))
                res.removeFirstWord();
            if (unit == 1 && num.isOneForSuffix())
                res.setSuffixOne(i);
            else if (unit > 1 && unit < 5 && num.isOneForSuffix())
                res.setSuffixTwoToFour(i);
            else
                res.setSuffixFiveToNineteen(i);
        }
        if (i % 3 == 0 && unit != 0) {//Проверка сотен (каждая третья цифра)
            res.setHundred(unit);
            return numericToText(num.removeLastNumber(), i);
        }
        if ((i + 1) % 3 == 0) {//Проверка десятков (каждая вторая цифра если брать по три)
            if (num.isOneForTen()) {
                if (num.getPrev() != 0)
                    res.removeFirstWord();
                res.setValueUnitDouble(num.getPrev());
            } else if (unit != 0)
                res.setValueDouble(unit);
            return numericToText(num.removeLastNumber(), i);
        }
        if (i > 3 && i < 7 && unit != 0)//Проверка единиц (первое число если брать по три)
            res.setValueMod(unit);
        else if (unit != 0)
            res.setValue(unit);
        return numericToText(num.removeLastNumber(), i);
    }
}