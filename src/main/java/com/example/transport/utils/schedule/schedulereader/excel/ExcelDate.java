package com.example.transport.utils.schedule.schedulereader.excel;

import com.example.transport.exception.ExcelException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelDate {


    LocalDate getDateFromExcel(String sheetName) throws Exception{
        Pattern r = Pattern.compile("(.*\\s[0-9]+\\s[0-9]+-[0-9]+)\\s([0-9]+\\.[0-9]+\\.[0-9]+)");
        Matcher m = r.matcher(sheetName);
        DateTimeFormatter formatter = (DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        if (m.find()) {
            LocalDate  date = LocalDate.parse(m.group(2), formatter);
            return date;
        }
        throw  new ExcelException("The date is wrong");
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
