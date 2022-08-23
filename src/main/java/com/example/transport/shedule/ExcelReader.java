package com.example.transport.shedule;

import com.example.transport.domain.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ExcelReader {


    private final Workbook wb;
    private static final int FIRST_ROW_WITH_DATE = 2;
    private static final int STEP_JOURNEY_BLOCK = 4;
    private static final int FIRST_JOURNEY_SHEET = 4;
    public ExcelReader(String fileName) {
        try {
            File fis = new File(fileName);
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  Map<String, Transport> getTrolleybus() throws  Exception{
          Sheet sheet = wb.getSheetAt(0);
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
        List<StopTransport> stopTransportList = PoiPOJOUtils.sheetToPOJO(sheet, StopTransport.class);
        Map<String, StopTransport> stopTransporMap = stopTransportList
                .stream()
                        .collect(Collectors.toMap(StopTransport::getId, Function.identity()));
        System.out.println(stopTransportList);
        return stopTransporMap;
    }
    public List<CellRangeAddress> getDate() throws Exception{
        Sheet sheet = wb.getSheetAt(4);

        return null;// regions;
    }
    public List<Journey> getJourney() throws Exception {
        Sheet sheet = wb.getSheetAt(4);
        List<StopTransport> journeyStops = new ArrayList<>();
        List<Journey> journeys = new ArrayList<>();
        Map<String, Person> per = getEmployee();
        Map<String, Transport> transportMap = getTrolleybus();
        Map<String, StopTransport> stops = getStops();
        int i = 3;
        CellValue cellValue;
        do {
            Row row = sheet.getRow(i);
            cellValue = null;
            if (row != null) {
                break;
            }
                Cell stopCell = row.getCell(1);
                if (stopCell != null && stopCell.getCellType().equals(CellType.FORMULA)) {
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellReference cellReference = new CellReference(stopCell);
                    Row r = sheet.getRow(cellReference.getRow());
                    Cell cell = r.getCell(cellReference.getCol());
                    cellValue = evaluator.evaluate(cell);
                    StopTransport stopTransport = stops.get(cellValue.getStringValue());
                    journeyStops.add(stopTransport);
                }
            i++;
        } while (cellValue != null && cellValue.getStringValue() != null);
        //System.out.println(cellValue);
        List<CellRangeAddress> regions = sheet.getMergedRegions();
        String type = sheet.getRow(regions.get(0).getFirstRow()).getCell(0).getStringCellValue();
        Pattern r = Pattern.compile("(.*\\s[0-9]+-[0-9]+)\\s+([0-9]+\\s[a-zA-Zа-яА-Я ]+\\s[0-9]+)");
        Matcher m = r.matcher(type);
        String date = "";
        if (m.find( )) {
            date = m.group(2);
        }else {
            System.out.println("NO MATCH");
        }
        regions.remove(regions.get(0));
        int l = 0;
        for (CellRangeAddress region : regions) {
            //   CellRangeAddress region = regions.get(i);
            Journey journey = new Journey();
            journey.setData(date);
            Datetime datetime = null;
            int offset = FIRST_ROW_WITH_DATE;
            int k = -1;
            Row firstRow = sheet.getRow(region.getFirstRow());
            if(firstRow == null){
                break;
            }
            Cell cellWithJourneyInfo = firstRow.getCell(sheet.getRow(region.getFirstRow()).getFirstCellNum() + l);
            if (cellWithJourneyInfo == null){
                break;
            }
            String journeyInfo = cellWithJourneyInfo.
                    getStringCellValue();
            l = l + STEP_JOURNEY_BLOCK;
            if(journeyInfo.split("\\s+").length > 1){
                journey.setNumber(journeyInfo.split("\\s+")[1]);
            }
            while (true) {
                Row beginRow = sheet.getRow(region.getFirstRow() + offset);

                if (beginRow == null) {
                    break;
                }
                Cell cellNumber = beginRow.getCell(regions.get(0).getFirstRow() + 1);
                if (cellNumber == null) {
                    break;
                }
                JourneyStop journeyStop = new JourneyStop();
                journey.setNumberForPassengers(String.valueOf(cellNumber.getNumericCellValue()));
                Cell transportCell = beginRow.getCell(region.getFirstColumn());
                if (transportCell.getCellType().equals(CellType.FORMULA)) {
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellReference cellReference = new CellReference(transportCell);
                    Row rowTransport = sheet.getRow(cellReference.getRow());
                    Cell cellTransport = rowTransport.getCell(cellReference.getCol());
                    CellValue idTransport = evaluator.evaluate(cellTransport);
                    String idTransportStr = String.valueOf((int) idTransport.getNumberValue());
                    Transport transport = transportMap.get(idTransportStr);
                    journeyStop.setTransport(transport);
                }

                Cell Personcell = beginRow.getCell(regions.get(0).getFirstRow() + 4);
                if (Personcell.getCellType().equals(CellType.FORMULA)) {
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellReference cellReference = new CellReference(Personcell);
                    Row rowPerson = sheet.getRow(cellReference.getRow());
                    Cell cellPerson = rowPerson.getCell(cellReference.getCol());
                    CellValue title = evaluator.evaluate(cellPerson);
                    String idDriverStr = title.getStringValue();
                    Person person = per.get(idDriverStr);
                    journeyStop.setDriver(person);
                }

                Cell inspectorcell = beginRow.getCell(region.getFirstColumn() + 3);
                if (inspectorcell.getCellType().equals(CellType.FORMULA)) {
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    CellReference cellReference = new CellReference(inspectorcell);
                    Row rowInspector = sheet.getRow(cellReference.getRow());
                    Cell cellInspector = rowInspector.getCell(cellReference.getCol());
                    CellValue title = evaluator.evaluate(cellInspector);
                    String idInspectorStr = title.getStringValue();
                    Person person = per.get(idInspectorStr);
                    journeyStop.setInspector(person);
                }
                Cell cellTime = beginRow.getCell(regions.get(0).getFirstRow() + 3);
                if (cellTime == null) {
                    break;
               } else {
                    journeyStop.setTime(String.valueOf(cellTime.getLocalDateTimeCellValue()));
                }
                    System.out.println();
                    journey.addJourneyStop(journeyStop);
                }
            }
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


