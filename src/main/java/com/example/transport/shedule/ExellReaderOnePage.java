package com.example.transport.shedule;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.Iterator;


import java.io.FileInputStream;

public class ExellReaderOnePage {

     public static void main(String[] args) throws Exception {
       /* try {
            FileInputStream excelFile = new FileInputStream("C:\\Users\\alexe\\Downloads\\Timetable.xls");
            Workbook wb = new HSSFWorkbook(excelFile);
            Sheet sheet = wb.getSheetAt(3);
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}