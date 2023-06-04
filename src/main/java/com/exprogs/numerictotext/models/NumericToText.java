package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.constants.Constants;
import com.exprogs.numerictotext.models.hundred.Hundred;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceFiveToNineteen;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceOne;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceTwoToFour;
import com.exprogs.numerictotext.models.ten.Double;
import com.exprogs.numerictotext.models.ten.UnitDouble;
import com.exprogs.numerictotext.models.unit.Value;
import com.exprogs.numerictotext.models.unit.ValueMod;

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
        if (num.getSign())
            return numericToText(num, (byte) 0).setPositiveSign();
        else
            return numericToText(num, (byte) 0).setNegativeSign();
    }

    private Text numericToText(Number num, byte i) {
        if (num.checkZero() && i == 0)
            return res.returnZero();
        if (num.checkZero())
            return res;
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {//check suffix(after 3 units)
            if (i / 3 - 2 >= 0 && res.isTripleZero(i))
                res.removeFirstWord();
            if (num.getLastNumber() == 1 && num.isOneForSuffix())
                res.setSuffix(new SuffixInterfaceOne(i));
            else if (num.getLastNumber() > 1 && num.getLastNumber() < 5 && num.isOneForSuffix())
                res.setSuffix(new SuffixInterfaceTwoToFour(i));
            else
                res.setSuffix(new SuffixInterfaceFiveToNineteen(i));
        }
        if (i % 3 == 0 && num.getLastNumber() != 0) {//check hundred(every 3 unit)
            res.setHundred(new Hundred(num.getLastNumber()));
            return numericToText(num.removeLastNumber(), i);
        }
        if ((i + 1) % 3 == 0) {//check ten(every second unit if you take three)
            if (num.isOneForTen()) {
                if (num.getPrev() != 0)
                    res.removeFirstWord();
                res.setTen(new UnitDouble(num.getPrev()));
            } else if (num.getLastNumber() != 0)
                res.setTen(new Double(num.getLastNumber()));
            return numericToText(num.removeLastNumber(), i);
        }
        if (i > 3 && i < 7 && num.getLastNumber() != 0)//check unit(every first unit if you take three)
            res.setValue(new ValueMod(num.getLastNumber()));
        else if (num.getLastNumber() != 0)
            res.setValue(new Value(num.getLastNumber()));
        return numericToText(num.removeLastNumber(), i);
    }
}