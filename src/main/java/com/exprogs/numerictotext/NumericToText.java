package com.exprogs.numerictotext;

public class NumericToText {
    private StringBuilder res = new StringBuilder();
    private byte i = 0;
    private long num;

    public void setNum(long num) {
        this.num = num;
    }

    public NumericToText() {
    }

    public NumericToText(long num) {
        this.num = num;
    }

    public String getText() {
        i = 0;
        res = new StringBuilder();
        return numericToText(num, (byte) 0).toString();
    }

    private StringBuilder numericToText(long num, byte prev) {
        if (num == 0 && i == 0)
            return res.append(Constants.ZERO);
        if (num == 0)
            return res;
        byte unit = (byte) (num % 10);
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {
            if (unit == 1 && ((num / 10) % 10) != 1) {
                Constants.SUFFIX_ONE.forEach((key, value) -> {
                    if (key == i / 3)
                        res.insert(0, Constants.SPACE).insert(0, value);
                });
            } else if (unit > 1 && unit < 5 && ((num / 10) % 10) != 1) {
                Constants.SUFFIX_TWO_FOUR.forEach((key, value) -> {
                    if (key == i / 3)
                        res.insert(0, Constants.SPACE).insert(0, value);
                });
            } else if (((num / 10) % 10) != 0 || ((num / 100) % 10) != 0 || unit != 0) {
                Constants.SUFFIX_FIVE_TO_NINE.forEach((key, value) -> {
                    if (key == i / 3)
                        res.insert(0, Constants.SPACE).insert(0, value);
                });
            }
        }
        if (i % 3 == 0) {
            Constants.HUNDRED.forEach((key, value) -> {
                if (key == unit)
                    res.insert(0, Constants.SPACE).insert(0, value);
            });
            return numericToText(num / 10, unit);
        }
        if ((i + 1) % 3 == 0) {
            if ((num % 10) == 1) {
                Constants.VALUE_UNIT_DOUBLE.forEach((key, value) -> {
                    if (key == prev) {
                        if (prev != 0)
                            res.delete(0, res.indexOf(Constants.SPACE) + 1);
                        res.insert(0, Constants.SPACE).insert(0, value);
                    }
                });
            } else {
                Constants.VALUE_DOUBLE.forEach((key, value) -> {
                    if (key == unit)
                        res.insert(0, Constants.SPACE).insert(0, value);
                });
            }
            return numericToText(num / 10, unit);
        }
        if (i > 3 && i < 7) {
            Constants.VALUE_MOD.forEach((key, value) -> {
                if (key == unit)
                    res.insert(0, Constants.SPACE).insert(0, value);
            });
        } else {
            Constants.VALUE.forEach((key, value) -> {
                if (key == unit)
                    res.insert(0, Constants.SPACE).insert(0, value);
            });
        }
        return numericToText(num / 10, unit);
    }
}
