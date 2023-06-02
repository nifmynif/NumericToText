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
                res.insertWord(Constants.SUFFIX_ONE.get((i / 3) - 1));
            else if (unit > 1 && unit < 5 && num.isOneForSuffix())
                res.insertWord(Constants.SUFFIX_TWO_FOUR.get((i / 3) - 1));
            else
                res.insertWord(Constants.SUFFIX_FIVE_TO_NINETEEN.get((i / 3) - 1));
        }
        if (i % 3 == 0 && unit != 0) {//Проверка сотен (каждая третья цифра)
            res.insertWord(Constants.HUNDRED.get(unit - 1));
            return numericToText(num.removeLastNumber(), i);
        }
        if ((i + 1) % 3 == 0) {//Проверка десятков (каждая вторая цифра если брать по три)
            if (num.isOneForTen()) {
                if (num.getPrev() != 0)
                    res.removeFirstWord();
                res.insertWord(Constants.VALUE_UNIT_DOUBLE.get(num.getPrev()));
            } else if (unit != 0)
                res.insertWord(Constants.VALUE_DOUBLE.get(unit - 2));
            return numericToText(num.removeLastNumber(), i);
        }
        if (i > 3 && i < 7 && unit != 0)//Проверка единиц (первое число если брать по три)
            res.insertWord(Constants.VALUE_MOD.get(unit - 1));
        else if (unit != 0)
            res.insertWord(Constants.VALUE.get(unit - 1));
        return numericToText(num.removeLastNumber(), i);
    }
}