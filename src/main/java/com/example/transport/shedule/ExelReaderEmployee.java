package com.example.transport.shedule;


import com.example.transport.domain.Person;
import com.example.transport.domain.Transport;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
     public Map<String, Person> getDriver() throws Exception {
         Sheet sheet = wb.getSheetAt(2);
         List<Person> personList = PoiPOJOUtils.sheetToPOJO(sheet, Person.class)
                 .stream().filter(person -> !person.getId().isEmpty()).collect(Collectors.toList());
         Map<String, Person> personMap = personList
                 .stream()
                 .collect(Collectors.toMap(Person::getId, Function.identity()));
         /*if (personMap.equals("Водитель")) {
             System.out.println(personMap);
         } else if (personMap.equals("Контролер")){
             System.out.println(personMap);
         }*/
         System.out.println(personMap);
         return personMap;
     }

    public static void main(String[] args) {
        ExelReaderEmployee exelReaderEmployee = new ExelReaderEmployee("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        try {
            exelReaderEmployee.getDriver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

