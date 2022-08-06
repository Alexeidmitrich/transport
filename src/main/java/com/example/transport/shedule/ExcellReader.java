package com.example.transport.shedule;

import java.io.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class ExcellReader {
    public static void main(String[] args) throws Exception {
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

