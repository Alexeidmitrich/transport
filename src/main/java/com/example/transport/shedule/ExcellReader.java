package com.example.transport.shedule;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Iterator;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class ExcellReader {
    public static void main(String[] args) throws Exception {
        /*try {
            FileInputStream excelFile = new FileInputStream("C:\\Users\\alexe\\Downloads\\Timetable.xls");
            Workbook wb = new HSSFWorkbook(excelFile);
            Sheet datatypeSheet = wb.getSheetAt(2);
            Iterator<Row> iterator = datatypeSheet.iterator();
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
        File f = new File("C:\\Users\\alexe\\Downloads\\Timetable.xls");

        try {
            Workbook wb=Workbook.getWorkbook(f);
            int Num = wb.getNumberOfSheets();

            for (int i = 0; i < Num; i++) {
                Sheet sheet = wb.getSheet(i);
                Sheet s = wb.getSheet(i);

                int row = s.getRows();
                int col = s.getColumns();

                for(int i1=0; i1<row;i1++) {
                    for(int j=0;j<col;j++) {
                        Cell c =s.getCell(j, i1);
                        System.out.println(c.getContents());
                        //String text = c.getContents(); 
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("completed");
    }
}

