package com.exprogs.numerictotext;

public class NumericToText {
    private StringBuilder res = new StringBuilder();
    private byte i = 0;
    private long num;
    private boolean sign;

    public void setNum(long num) {
        if (num < 0) {
            sign = false;
            num *= -1;
        } else
            sign = true;
        this.num = num;
    }

    public NumericToText() {
    }

    public NumericToText(long num) {
        if (num < 0) {
            sign = false;
            num *= -1;
        } else
            sign = true;
        this.num = num;
    }

    public String getText() {
        i = 0;
        res = new StringBuilder();
        if (!sign)
            return numericToText(num, (byte) 0).insert(0, "Минус ").toString();
        else
            return numericToText(num, (byte) 0).toString();
    }

    private StringBuilder numericToText(long num, byte prev) {
        if (num == 0 && i == 0)
            return res.append(Constants.ZERO);
        if (num == 0)
            return res;
        byte unit = (byte) (num % 10);
        i += 1;
        if (unit == 0)
            return numericToText(num / 10, unit);
        if ((i - 1) % 3 == 0 && i > 3) {
            if (unit == 1 && ((num / 10) % 10) != 1)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_ONE.get((i / 3) - 1));
            else if (unit > 1 && unit < 5 && ((num / 10) % 10) != 1)
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_TWO_FOUR.get((i / 3) - 1));
            else
                res.insert(0, Constants.SPACE).insert(0, Constants.SUFFIX_FIVE_TO_NINE.get((i / 3) - 1));
        }
        if (i % 3 == 0) {
            res.insert(0, Constants.SPACE).insert(0, Constants.HUNDRED.get(unit - 1));
            return numericToText(num / 10, unit);
        }
        if ((i + 1) % 3 == 0) {
            if ((num % 10) == 1) {
                if (prev != 0)
                    res.delete(0, res.indexOf(Constants.SPACE) + 1);
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_UNIT_DOUBLE.get(prev));
            } else
                res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_DOUBLE.get(unit - 2));
            return numericToText(num / 10, unit);
        }
        if (i > 3 && i < 7)
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE_MOD.get(unit - 1));
        else
            res.insert(0, Constants.SPACE).insert(0, Constants.VALUE.get(unit - 1));
        return numericToText(num / 10, unit);
    }
}
