package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.ConstantsRU;

import java.math.BigInteger;
import java.util.zip.DataFormatException;

public class Number {
    private BigInteger number;
    private boolean sign;
    private byte prev;

    public Number(String num) throws DataFormatException {
        setNumber(num);
    }

    public void setNumber(String number) throws DataFormatException {
        if (number.isEmpty()//input validation
                || number.equals("-")
                || (number.matches(".*\\W.*") && !number.matches(".*-.*"))
                || (number.matches(".*\\D.*") && !number.matches(".*-.*"))
                || (number.matches(".*-.*") && number.lastIndexOf("-") != 0))
            throw new DataFormatException();
        if (number.length() > (ConstantsRU.SUFFIX.size() + 1) * 3)//checking the length of a number
            throw new IndexOutOfBoundsException();
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

    public boolean isOneForSuffix() {//case for suffix when last unit is 1
        return number.divide(BigInteger.TEN).mod(BigInteger.TEN).compareTo(BigInteger.ONE) != 0;
    }

    public Number removeLastNumber() {
        prev = getLastNumber();
        number = number.divide(BigInteger.valueOf(10));
        return this;
    }

    public boolean isOneForTen() {//11-19 check
        return number.mod(BigInteger.TEN).compareTo(BigInteger.ONE) == 0;
    }

    public byte getPrev() {
        return prev;
    }
}
