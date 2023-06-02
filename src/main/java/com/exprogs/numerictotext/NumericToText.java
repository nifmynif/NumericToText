package com.exprogs.numerictotext;

import java.util.zip.DataFormatException;

public class NumericToText {
    private byte i = 0;//Итерация для отделения единиц, десятков и сотен
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
        i = 0;
        if (!num.getSign())//Проверка на отрицательное число и удаление лишних пробелов
            return numericToText(num, (byte) 0).setNegativeSign();
        else
            return numericToText(num, (byte) 0).setPositiveSign();
    }

    private Text numericToText(Number num, byte prev) {
        if (num.checkZero() && i == 0)//Проверка на 0
            return res.returnZero();
        if (num.checkZero())//Условие выхода из рекурсии
            return res;
        byte unit = num.getLastNumber();//Взяли последнюю цифру числа
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {//Проверка на суффиксы (после каждых трех цифр)
            if (i / 3 - 2 >= 0 && res.isTripleZero(i))//проверка если шло три нуля подряд
                res.removeFirstWord();
            if (unit == 1 && num.isOneForSufix())
                res.insertWord(Constants.SUFFIX_ONE.get((i / 3) - 1));
            else if (unit > 1 && unit < 5 && num.isOneForSufix())
                res.insertWord(Constants.SUFFIX_TWO_FOUR.get((i / 3) - 1));
            else
                res.insertWord(Constants.SUFFIX_FIVE_TO_NINETEEN.get((i / 3) - 1));
        }
        if (i % 3 == 0 && unit != 0) {//Проверка сотен (каждая третья цифра)
            res.insertWord(Constants.HUNDRED.get(unit - 1));
            return numericToText(num.removeLastNumber(), unit);
        }
        if ((i + 1) % 3 == 0) {//Проверка десятков (каждая вторая цифра если брать по три)
            if (num.isOneForTen()) {//Если в десятках 1, то выбирать значения от 10 до 19
                if (prev != 0)
                    res.removeFirstWord();
                res.insertWord(Constants.VALUE_UNIT_DOUBLE.get(prev));
            } else if (unit != 0)//В остальных случаях выбирать значения 20, 30, 40... 90
                res.insertWord(Constants.VALUE_DOUBLE.get(unit - 2));
            return numericToText(num.removeLastNumber(), unit);
        }
        if (i > 3 && i < 7 && unit != 0)//Проверка единиц (первое число если брать по три)
            res.insertWord(Constants.VALUE_MOD.get(unit - 1));
        else if (unit != 0)
            res.insertWord(Constants.VALUE.get(unit - 1));
        return numericToText(num.removeLastNumber(), unit);
    }
}