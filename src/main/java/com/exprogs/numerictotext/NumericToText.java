package com.exprogs.numerictotext;

import java.math.BigInteger;
import java.util.zip.DataFormatException;

public class NumericToText {
    private final StringBuilder res = new StringBuilder();//Текстовый результат
    private byte i = 0;//Итерация для отделения единиц, десятков и сотен
    private BigInteger num;//Входное число
    private boolean sign;//Знак

    public void setNum(String num) throws DataFormatException {
        num = num.replaceAll(" ", "");//Удаление лишних пробелов при 1 001 или 11 001 случаях
        if (num.isEmpty()//Проверка пустой строки
                || num.equals("-")//Проверка если стоит только знак
                || (num.matches(".*\\W.*") && !num.matches(".*-.*"))//Проверка спец символов (*<_.>,)
                || (num.matches(".*\\D.*") && !num.matches(".*-.*"))//Проверка на буквы
                || (num.matches(".*-.*") && num.lastIndexOf("-") != 0))//Проверка чтобы знак стоял на своем месте
            throw new DataFormatException("введено не число");
        this.num = new BigInteger(num);
        if (this.num.compareTo(BigInteger.ZERO) < 0) {//проверка знака числа
            sign = false;
            this.num = this.num.negate();
        } else
            sign = true;
    }

    public NumericToText() {
    }

    public NumericToText(String num) throws DataFormatException {
        setNum(num);
    }

    public String getText() {
        res.setLength(i = 0);
        if (!sign)//Проверка на отрицательное число и удаление лишних пробелов
            return numericToText(num, (byte) 0).insert(0, "Минус ").toString().trim();
        else
            return numericToText(num, (byte) 0).toString().trim();
    }

    private StringBuilder numericToText(BigInteger num, byte prev) {
        if (num.compareTo(BigInteger.ZERO) == 0 && i == 0)//Проверка на 0
            return res.append(Constants.ZERO);
        if (num.compareTo(BigInteger.ZERO) == 0)//Условие выхода из рекурсии
            return res;
        byte unit = num.mod(BigInteger.TEN).byteValue();//Взяли последнюю цифру числа
        i += 1;
        if (i > Constants.SUFFIX.size())
            throw new IndexOutOfBoundsException("мы еще не придумали названия этому числу(");
        if (unit == 0)
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);//Если последняя цифра 0, то пропускаем
        if ((i - 1) % 3 == 0 && i > 3) {//Проверка на суффиксы (после каждых трех цифр)
            boolean b = num.divide(BigInteger.TEN).mod(BigInteger.TEN).compareTo(BigInteger.ONE) != 0;
            if (unit == 1 && b)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_ONE.get((i / 3) - 1));//Поставить суффиксы со склонениями при 1
            else if (unit > 1 && unit < 5 && b)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_TWO_FOUR.get((i / 3) - 1));//Поставить суффиксы со склонениями при 2-4
            else
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_FIVE_TO_NINETEEN.get((i / 3) - 1));//Поставить суффиксы со склонениями при 5-19
        }
        if (i % 3 == 0) {//Проверка сотен (каждая третья цифра)
            res.insert(0, Constants.SPACE).insert(0, Constants.HUNDRED.get(unit - 1));
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);
        }
        if ((i + 1) % 3 == 0) {//Проверка десятков (каждая вторая цифра если брать по три)
            if (num.mod(BigInteger.TEN).compareTo(BigInteger.ONE) == 0) {//Если в десятках 1, то выбирать значения от 10 до 19
                if (prev != 0)
                    res.delete(0, res.indexOf(Constants.SPACE) + 1);
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_UNIT_DOUBLE.get(prev));
            } else//В остальных случаях выбирать значения 20, 30, 40... 90
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_DOUBLE.get(unit - 2));
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);
        }
        if (i > 3 && i < 7)//Проверка единиц (первое число если брать по три)
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_MOD.get(unit - 1));//Если это тысячи, то склоняем
        else
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE.get(unit - 1));//Единицы без склонений
        return numericToText(num.divide(BigInteger.valueOf(10)), unit);
    }
}