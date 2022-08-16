package com.example.transport.shedule;


import com.example.transport.domain.Person;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Deprecated


public class ExelReaderEmployee {

    private final Workbook wb;
     public ExelReaderEmployee(String fileName) {
         try {
             File fis = new File(fileName);
             wb = WorkbookFactory.create(fis);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }


     public Map<String, Person> getEmployee() throws Exception {
         Sheet sheet = wb.getSheetAt(2);
         List<Person> personList = PoiPOJOUtils.sheetToPOJO(sheet, Person.class)
                 .stream().filter(person -> person.getTitle().equals("Контроллер")).collect(Collectors.toList());
         List<Person> personList1 = PoiPOJOUtils.sheetToPOJO(sheet, Person.class)
                 .stream().filter(person -> person.getTitle().equals("Водитель")).collect(Collectors.toList());
         Map<String, Person> personMap = personList
                 .stream()
                 .collect(Collectors.toMap(Person::getId, Function.identity()));
         System.out.println(personList);
         System.out.println(personList1);
             return personMap;
     }

    public static void main(String[] args) {
        ExelReaderEmployee exelReaderEmployee = new ExelReaderEmployee("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        try {
            exelReaderEmployee.getEmployee();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

