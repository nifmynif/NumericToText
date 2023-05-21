package com.exprogs.numerictotext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class NumericToTextTest {

    @Test
    void getTextWrongNumberException() {
        try {
            NumericToText numeric = new NumericToText("");
            numeric.getText();
        } catch (DataFormatException e) {
            assertEquals("введено не число", e.getMessage());
        }
    }

    @Test
    void getTextBigNumberException() {
        try {
            new NumericToText("1".repeat(((Constants.SUFFIX.size() + 1) * 3) + 1));
        } catch (IndexOutOfBoundsException e) {
            assertEquals("мы еще не придумали названия этому числу(", e.getMessage());
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getTextZero() throws DataFormatException {
        NumericToText numeric = new NumericToText("0");
        assertEquals("ноль", numeric.getText());
    }

    @Test
    void getTextOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("1");
        assertEquals("один", numeric.getText());
    }

    @Test
    void getTextMinesOne() throws DataFormatException {
        NumericToText numeric = new NumericToText();
        numeric.setNum("-1");
        assertEquals("минус один", numeric.getText());
    }

    @Test
    void getTextEleven() throws DataFormatException {
        NumericToText numeric = new NumericToText("11");
        assertEquals("одиннадцать", numeric.getText());
    }

    @Test
    void getTextTwenty() throws DataFormatException {
        NumericToText numeric = new NumericToText("20");
        assertEquals("двадцать", numeric.getText());
    }

    @Test
    void getTextMinesOneHausenOneHandedOne() throws DataFormatException {
        NumericToText numeric = new NumericToText("1 101");
        assertEquals("одна тысяча сто один", numeric.getText());
    }

    @Test
    public void testDDT() throws Exception {
        InputStream in = new FileInputStream("src/test/resources/DDT.xls");
        HSSFWorkbook wb = new HSSFWorkbook(in);
        DataFormatter formatter = new DataFormatter();
        NumericToText numeric = new NumericToText();
        Sheet sheet = wb.getSheet("Лист1");
        for (Row row : sheet) {
            numeric.setNum(formatter.formatCellValue(row.getCell(0)));
            assertEquals(row.getCell(1).getStringCellValue(), numeric.getText());
        }
    }
}