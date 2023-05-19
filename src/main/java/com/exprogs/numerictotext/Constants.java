package com.exprogs.numerictotext;

import java.util.ArrayList;

public class Constants {
    public static final String SPACE = " ";
    public static final String ZERO = "ноль";
    public static final ArrayList<String> VALUE = new ArrayList<>();

    static {
        VALUE.add("один");
        VALUE.add("два");
        VALUE.add("три");
        VALUE.add("четыре");
        VALUE.add("пять");
        VALUE.add("шесть");
        VALUE.add("семь");
        VALUE.add("восемь");
        VALUE.add("девять");
    }

    public static final ArrayList<String> VALUE_MOD = new ArrayList<>();

    static {
        VALUE_MOD.add("одна");
        VALUE_MOD.add("две");
        VALUE_MOD.add("три");
        VALUE_MOD.add("четыре");
        VALUE_MOD.add("пять");
        VALUE_MOD.add("шесть");
        VALUE_MOD.add("семь");
        VALUE_MOD.add("восемь");
        VALUE_MOD.add("девять");
    }

    public static final ArrayList<String> VALUE_UNIT_DOUBLE = new ArrayList<>();

    static {
        VALUE_UNIT_DOUBLE.add("десять");
        VALUE_UNIT_DOUBLE.add("одиннадцать");
        VALUE_UNIT_DOUBLE.add("двенадцать");
        VALUE_UNIT_DOUBLE.add("тринадцать");
        VALUE_UNIT_DOUBLE.add("четырнадцать");
        VALUE_UNIT_DOUBLE.add("пятнадцать");
        VALUE_UNIT_DOUBLE.add("шестнадцать");
        VALUE_UNIT_DOUBLE.add("семнадцать");
        VALUE_UNIT_DOUBLE.add("восемнадцать");
        VALUE_UNIT_DOUBLE.add("девятнадцать");
    }

    public static final ArrayList<String> VALUE_DOUBLE = new ArrayList<>();

    static {
        VALUE_DOUBLE.add("двадцать");
        VALUE_DOUBLE.add("тридцать");
        VALUE_DOUBLE.add("сорок");
        VALUE_DOUBLE.add("пятьдесят");
        VALUE_DOUBLE.add("шестьдесят");
        VALUE_DOUBLE.add("семьдесят");
        VALUE_DOUBLE.add("восемьдесят");
        VALUE_DOUBLE.add("девяносто");
    }

    public static final ArrayList<String> HUNDRED = new ArrayList<>();

    static {
        HUNDRED.add("сто");
        HUNDRED.add("двести");
        HUNDRED.add("триста");
        HUNDRED.add("четыреста");
        HUNDRED.add("пятьсот");
        HUNDRED.add("шестьсот");
        HUNDRED.add("семьсот");
        HUNDRED.add("восемьсот");
        HUNDRED.add("девятьсот");
    }

    private static final ArrayList<String> SUFFIX = new ArrayList<>();

    static {
        SUFFIX.add("тысяч");
        SUFFIX.add("миллион");
        SUFFIX.add("миллиард");
        SUFFIX.add("триллион");
        SUFFIX.add("квадриллион");
        SUFFIX.add("квинтиллион");
        SUFFIX.add("секстиллион");
        SUFFIX.add("септиллион");
        SUFFIX.add("октиллион");
        SUFFIX.add("нониллион");
    }

    public static final ArrayList<String> SUFFIX_ONE = new ArrayList<>();

    public static final ArrayList<String> SUFFIX_TWO_FOUR = new ArrayList<>();

    public static final ArrayList<String> SUFFIX_FIVE_TO_NINE = new ArrayList<>();

    static {
        SUFFIX_ONE.add(SUFFIX.get(0) + "a");
        SUFFIX_TWO_FOUR.add(SUFFIX.get(0) + "и");
        SUFFIX_FIVE_TO_NINE.add(SUFFIX.get(0));
        for (int i = 1; i < SUFFIX.size(); i++) {
            SUFFIX_ONE.add(SUFFIX.get(i));
            SUFFIX_TWO_FOUR.add(SUFFIX.get(i) + "а");
            SUFFIX_FIVE_TO_NINE.add(SUFFIX.get(i) + "ов");
        }
    }
}
