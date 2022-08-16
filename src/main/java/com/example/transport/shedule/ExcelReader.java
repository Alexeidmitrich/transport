package com.example.transport.shedule;

import com.example.transport.domain.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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


    public Map<String, Person> getEmployee() throws Exception {
        Sheet sheet = wb.getSheetAt(2);
        List<Person> personList = PoiPOJOUtils.sheetToPOJO(sheet, Person.class);
        Map<String, Person> personMap = personList
                .stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(personList);
        return personMap;
    }
    public Map<String , StopTransport> getStops() throws Exception {
        Sheet sheet = wb.getSheetAt(3);
        //TODO rename
        List<StopTransport> stopTransportList = PoiPOJOUtils.sheetToPOJO(sheet, StopTransport.class);
        Map<String, StopTransport> stopTransporMap = stopTransportList
                .stream()
                        .collect(Collectors.toMap(StopTransport::getId, Function.identity()));
        System.out.println(stopTransportList);
        return stopTransporMap;
    }
    public List<CellRangeAddress> getDate() throws Exception{
        Sheet sheet = wb.getSheetAt(4);
        List<CellRangeAddress> regions = sheet.getMergedRegions();
        String type = sheet.getRow(regions.get(0).getFirstRow()).getCell(0).getStringCellValue();
        System.out.println(type);
        return regions;
    }
    public List<Journey> getJourney() throws Exception {
        Sheet sheet = wb.getSheetAt(4);
        List<StopTransport> journeyStops = new ArrayList<>();
        List<Journey> journeys = new ArrayList<>();
        Map<String, Person> per = new HashMap<>();
        Map<String, Transport> transportMap = getTrolleybus();
        Map<String, StopTransport> stops = getStops();
        int i = 3;
        //CellValue cellValue = null;
        CellValue cellValue;
        do {
            Row row = sheet.getRow(i);
            Cell stopCell = row.getCell(1);
            cellValue = null;
            if (stopCell != null && stopCell.getCellType().equals(CellType.FORMULA)) {
                FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                CellReference cellReference = new CellReference(stopCell);
                Row r = sheet.getRow(cellReference.getRow());
                Cell cell = r.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cell);
                StopTransport stopTransport = stops.get(cellValue.getStringValue());
                journeyStops.add(stopTransport);
                break;
            }
            i++;
        } while (cellValue != null && cellValue.getStringValue() != null);
        System.out.println(cellValue);
        return journeys;
    }
    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        try {
            excelReader.getTrolleybus();
            excelReader.getEmployee();
            excelReader.getStops();
            excelReader.getDate();
            excelReader.getJourney();
            excelReader.getJourney();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


