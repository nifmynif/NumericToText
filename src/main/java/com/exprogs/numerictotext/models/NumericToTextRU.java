package com.exprogs.numerictotext.models;

import com.exprogs.numerictotext.models.hundred.Hundred;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceFiveToNineteen;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceOne;
import com.exprogs.numerictotext.models.suffix.SuffixInterfaceTwoToFour;
import com.exprogs.numerictotext.models.ten.Double;
import com.exprogs.numerictotext.models.ten.UnitDouble;
import com.exprogs.numerictotext.models.unit.Value;
import com.exprogs.numerictotext.models.unit.ValueMod;

import java.util.zip.DataFormatException;

public class NumericToTextRU extends NumericToText {

    public void setNum(String num) throws DataFormatException, IndexOutOfBoundsException {
        try {
            super.setNum(num);
        }catch (DataFormatException e){
            throw new DataFormatException("введено не число");
        }catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("мы еще не придумали названия этому числу(");
        }
    }

    public NumericToTextRU() {
    }

    public NumericToTextRU(String num) throws DataFormatException {
        setNum(num);
    }

    @Override
    public void work() {
        super.setText(new Text());
        numericToText(super.getNum(), (byte) 0);
        if (super.getNum().getSign())
            super.setText(super.getText().setPositiveSign());
        else
            super.setText(super.getText().setNegativeSign());
    }

    private Text numericToText(Number num, byte i) {
        if (num.checkZero() && i == 0)
            return super.getText().returnZero();
        if (num.checkZero())
            return super.getText();
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {//check suffix(after 3 units)
            if (i / 3 - 2 >= 0 && super.getText().isTripleZero(i))
                super.getText().removeFirstWord();
            if (num.getLastNumber() == 1 && num.isOneForSuffix())
                super.getText().setSuffix(new SuffixInterfaceOne(i));
            else if (num.getLastNumber() > 1 && num.getLastNumber() < 5 && num.isOneForSuffix())
                super.getText().setSuffix(new SuffixInterfaceTwoToFour(i));
            else
                super.getText().setSuffix(new SuffixInterfaceFiveToNineteen(i));
        }
        if (i % 3 == 0 && num.getLastNumber() != 0) {//check hundred(every 3 unit)
            super.getText().setHundred(new Hundred(num.getLastNumber()));
            return numericToText(num.removeLastNumber(), i);
        }
        if ((i + 1) % 3 == 0) {//check ten(every second unit if you take three)
            if (num.isOneForTen()) {
                if (num.getPrev() != 0)
                    super.getText().removeFirstWord();
                super.getText().setTen(new UnitDouble(num.getPrev()));
            } else if (num.getLastNumber() != 0)
                super.getText().setTen(new Double(num.getLastNumber()));
            return numericToText(num.removeLastNumber(), i);
        }
        if (i > 3 && i < 7 && num.getLastNumber() != 0)//check unit(every first unit if you take three)
            super.getText().setValue(new ValueMod(num.getLastNumber()));
        else if (num.getLastNumber() != 0)
            super.getText().setValue(new Value(num.getLastNumber()));
        return numericToText(num.removeLastNumber(), i);
    }
}