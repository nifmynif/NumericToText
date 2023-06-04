package com.exprogs.numerictotext;

import com.exprogs.numerictotext.constants.ConstantsRU;
import com.exprogs.numerictotext.models.NumericToText;
import com.exprogs.numerictotext.models.NumericToTextRU;
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
            new NumericToTextRU("");
        } catch (DataFormatException e) {
            assertEquals("введено не число", e.getMessage());
        }
    }

    @Test
    void getTextBigNumberException() {
        try {
            new NumericToTextRU("1".repeat(((ConstantsRU.SUFFIX.size() + 1) * 3) + 1));
        } catch (Exception e) {
            assertEquals("мы еще не придумали названия этому числу(", e.getMessage());
        }
    }

    @Test
    void getTextZero() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU("000");
        numeric.work();
        assertEquals("ноль", numeric.getResText());
    }

    @Test
    void getTextOne() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU("1");
        numeric.work();
        assertEquals("один", numeric.getResText());
    }

    @Test
    void getTextMinesOne() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU();
        numeric.setNum("-1");
        numeric.work();
        assertEquals("минус один", numeric.getResText());
    }

    @Test
    void getTextTwenty() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU("20");
        numeric.work();
        assertEquals("двадцать", numeric.getResText());
    }

    @Test
    void getTextMinesOneHausenOneHandedOne() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU("-1 101");
        numeric.work();
        assertEquals("минус одна тысяча сто один", numeric.getResText());
    }

    @Test
    void getTextOneMillion() throws DataFormatException {
        NumericToText numeric = new NumericToTextRU("1 000 000");
        numeric.work();
        assertEquals("один миллион", numeric.getResText());
    }

    @Test
    public void testDDT() throws Exception {
        try (InputStream in = new FileInputStream("src/test/resources/DDT.xls");
             HSSFWorkbook wb = new HSSFWorkbook(in)) {
            DataFormatter formatter = new DataFormatter();
            NumericToText numeric = new NumericToTextRU();
            Sheet sheet = wb.getSheet("Лист1");
            for (Row row : sheet) {
                numeric.setNum(formatter.formatCellValue(row.getCell(0)));
                numeric.work();
                assertEquals(row.getCell(1).getStringCellValue(), numeric.getResText());
            }
        }
    }
}