package com.exprogs.numerictotext;

import java.math.BigInteger;
import java.util.zip.DataFormatException;

public class Number {
    private BigInteger number;
    private boolean sign;

    public Number(String num) throws DataFormatException {
        setNumber(num);
    }

    public void setNumber(String number) throws DataFormatException {
        if (number.isEmpty()//Проверка пустой строки
                || number.equals("-")//Проверка если стоит только знак
                || (number.matches(".*\\W.*") && !number.matches(".*-.*"))//Проверка спец символов (*<_.>,)
                || (number.matches(".*\\D.*") && !number.matches(".*-.*"))//Проверка на буквы
                || (number.matches(".*-.*") && number.lastIndexOf("-") != 0))//Проверка чтобы знак стоял на своем месте
            throw new DataFormatException("введено не число");
        if (number.length() > (Constants.SUFFIX.size() + 1) * 3)//Условие если введенное число больше чем то что можно обработать
            throw new IndexOutOfBoundsException("мы еще не придумали названия этому числу(");
        this.number = new BigInteger(number);
        checkSign();
    }

    private void checkSign() {
        if (this.number.compareTo(BigInteger.ZERO) < 0) {
            sign = false;
            this.number = this.number.negate();
        } else
            sign = true;
    }

    public boolean getSign() {
        return sign;
    }

    public boolean checkZero() {
        return number.compareTo(BigInteger.ZERO) == 0;
    }

    public byte getLastNumber() {
        return number.mod(BigInteger.TEN).byteValue();
    }

    public boolean isOneForSufix() {
        return number.divide(BigInteger.TEN).mod(BigInteger.TEN).compareTo(BigInteger.ONE) != 0;
    }

    public Number removeLastNumber() {
        number = number.divide(BigInteger.valueOf(10));
        return this;
    }

    public boolean isOneForTen() {
        return number.mod(BigInteger.TEN).compareTo(BigInteger.ONE) == 0;
    }
}
