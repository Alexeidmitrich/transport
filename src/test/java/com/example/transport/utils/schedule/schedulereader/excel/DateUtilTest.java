package com.example.transport.utils.schedule.schedulereader.excel;

import com.example.transport.exception.ExcelException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DateUtilTest {

    @Test
    public void getDate() throws Exception {
        String sheetName = "Троллейбус 100 100-1 30.06.2022";
        //String sheetName = "";
        DateUtil dateUtil = new DateUtil();
        LocalDate date = dateUtil.getDateFromExcel(sheetName);
        LocalDate localDate = LocalDate.of(2022,06,30);
        assertEquals(date, localDate);
        //assertThrows(ExcelException.class, dateUtil.getDateFromExcel(sheetName),"Expected ExcelException. Excel is empty");
    }
}
