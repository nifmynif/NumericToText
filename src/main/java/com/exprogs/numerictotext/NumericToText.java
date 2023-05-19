package com.exprogs.numerictotext;

import java.math.BigInteger;
import java.util.zip.DataFormatException;

public class NumericToText {
    private StringBuilder res = new StringBuilder();
    private byte i = 0;
    private BigInteger num;
    private boolean sign;

    public void setNum(String num) throws DataFormatException {
        num = num.replaceAll(" ", "");
        if (num.isEmpty()
                || num.equals("-")
                || (num.matches(".*\\W.*") && !num.matches(".*-.*"))
                || (num.matches(".*\\D.*") && !num.matches(".*-.*"))
                || (num.matches(".*-.*") && num.lastIndexOf("-") != 0))
            throw new DataFormatException("введено не число");
        this.num = new BigInteger(num);
        if (this.num.compareTo(BigInteger.ZERO) < 0) {
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
        i = 0;
        res = new StringBuilder();
        if (!sign)
            return numericToText(num, (byte) 0).insert(0, "Минус ").toString();
        else
            return numericToText(num, (byte) 0).toString();
    }

    private StringBuilder numericToText(BigInteger num, byte prev) {
        if (num.compareTo(BigInteger.ZERO) == 0 && i == 0)
            return res.append(Constants.ZERO);
        if (num.compareTo(BigInteger.ZERO) == 0)
            return res;
        byte unit = num.mod(BigInteger.TEN).byteValue();
        i += 1;
        if (unit == 0)
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);
        if ((i - 1) % 3 == 0 && i > 3) {
            boolean b = num.divide(BigInteger.TEN).mod(BigInteger.TEN).compareTo(BigInteger.ONE) != 0;
            if (unit == 1 && b)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_ONE.get((i / 3) - 1));
            else if (unit > 1 && unit < 5 && b)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_TWO_FOUR.get((i / 3) - 1));
            else
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_FIVE_TO_NINE.get((i / 3) - 1));
        }
        if (i % 3 == 0) {
            res.insert(0, Constants.SPACE).insert(0, Constants.HUNDRED.get(unit - 1));
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);
        }
        if ((i + 1) % 3 == 0) {
            if (num.mod(BigInteger.TEN).compareTo(BigInteger.ONE) == 0) {
                if (prev != 0)
                    res.delete(0, res.indexOf(Constants.SPACE) + 1);
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_UNIT_DOUBLE.get(prev));
            } else
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_DOUBLE.get(unit - 2));
            return numericToText(num.divide(BigInteger.valueOf(10)), unit);
        }
        if (i > 3 && i < 7)
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_MOD.get(unit - 1));
        else
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE.get(unit - 1));
        return numericToText(num.divide(BigInteger.valueOf(10)), unit);
    }
}
