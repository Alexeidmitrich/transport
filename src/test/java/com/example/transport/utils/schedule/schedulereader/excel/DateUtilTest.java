package com.example.transport.utils.schedule.schedulereader.excel;

import com.example.transport.exception.ExcelException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DateUtilTest {

    @Test
    public void getDateTest() throws Exception {
        String sheetName = "Троллейбус 100 100-1 30.06.2022";
       // String sheetName = "";
        ExcelDate excelDate = new ExcelDate();
        LocalDate date = excelDate.getDateFromExcel(sheetName);
        LocalDate localDate = LocalDate.of(2022,06,30);
        //assertEquals(date, localDate);
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("Троллейбус 100 100-1-30.06.2022"),"Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("Троллейбус 100-1-30.06.2022"),"Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("100 100-1 30.06.2022"),"Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("Троллейбус 100 30.06.2022"),"Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("Троллейбус 100 100-1 30 июня 2022"),"Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class,()-> excelDate.getDateFromExcel("Троллейбус 30.06.2022"),"Expected ExcelException. Excel is empty");
    }
}
