package com.example.transport.shedule;

import com.example.transport.domain.Person;
import com.example.transport.domain.Transport;
import com.example.transport.domain.Trolleybus;
import jxl.read.biff.BiffException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ExcelReader {


    private final Workbook wb;

    public ExcelReader(String fileName) {
        try {
            File fis = new File(fileName);
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  Map<String, Transport> getTrolleybus() throws  Exception{
          Sheet sheet = wb.getSheetAt(1);
          List<Transport> trolleybuses = PoiPOJOUtils.sheetToPOJO(sheet, Transport.class)
                  .stream().filter(transport -> !transport.getId().isEmpty()).collect(Collectors.toList());
          Map<String, Transport> trolleybus = trolleybuses
                    .stream()
                    .collect(Collectors.toMap(Transport::getId, Function.identity()));
          System.out.println(trolleybus);
         return trolleybus;
    }

    /*public void getSchedule() {

    }*/

    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        try {
            excelReader.getTrolleybus();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


