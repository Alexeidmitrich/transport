package com.example.transport.shedule;

import com.example.transport.domain.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public String getDate(String sheetName) throws Exception{
        Pattern r = Pattern.compile("(.*\\s[0-9]+-[0-9]+)\\s+([0-9]+\\s[a-zA-Zа-яА-Я ]+\\s[0-9]+)");
        Matcher m = r.matcher(sheetName);
        String date = "";
        if (m.find( )) {
            date = m.group(2);
            return date;
        }

        return null;// regions;
    }


    public List<List<Journey>> getJourney() throws Exception {
        List<List<Journey>> listJourneyOther = new LinkedList<>();
        for (int i = FIRST_JOURNEY_SHEET; i < wb.getNumberOfSheets() ; i++) {
            listJourneyOther.add(getJourney(i));
        }
        return listJourneyOther;
    }

    public List<Journey> getJourney(int sheetNumber) throws Exception {
        Sheet sheet = wb.getSheetAt(sheetNumber);
        Map<String, StopTransport> stops = getStops();
        List<Journey> journeys = new ArrayList<>();
        Map<String, Person> per = getEmployee();
        Map<String, Transport> transportMap = getTrolleybus();
        List<CellRangeAddress> regions = sheet.getMergedRegions();
        regions.remove(regions.get(0));
        int l = 0;
        for (CellRangeAddress region : regions) {
            //   CellRangeAddress region = regions.get(i);
            Journey journey = new Journey();
            String date = getDate(sheet.getSheetName());
            journey.setData(date);
            int offset = FIRST_ROW_WITH_DATE;
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
                offset++;
                if (beginRow == null) {
                    break;
                }
                Cell cellNumber = beginRow.getCell(regions.get(0).getFirstColumn() - 1);
                if (cellNumber == null) {
                    break;
                }


                JourneyStop journeyStop = new JourneyStop();
                journey.setNumberForPassengers(String.valueOf(cellNumber.getNumericCellValue()));

                double idTransport = getCellValueNumber(sheet, beginRow, region.getFirstColumn());
                String idTransportStr = String.valueOf((int) idTransport);
                Transport transport = transportMap.get(idTransportStr);
                journeyStop.setTransport(transport);
                String idStopStr = getCellValueString(sheet, beginRow, 1);
                StopTransport stopTransport = stops.get(idStopStr);
                journeyStop.setStop(stopTransport);
                String idDriverStr = getCellValueString(sheet, beginRow, region.getFirstColumn()+ 2);
                Person driver = per.get(idDriverStr);
                journeyStop.setDriver(driver);
                String idInspectorStr = getCellValueString(sheet, beginRow,region.getFirstColumn() + 3 );
                Person inspector = per.get(idInspectorStr);
                journeyStop.setInspector(inspector);
                Cell cellTime = beginRow.getCell(region.getFirstColumn() + 1);
                if (cellTime == null) {
                    break;
                }
                journeyStop.setTime(String.valueOf(cellTime.getLocalDateTimeCellValue()));
                journey.addJourneyStop(journeyStop);

            }
            journeys.add(journey);
        }
        return journeys;
    }

    private String getCellValueString(Sheet sheet, Row row, int columnNumber){
        Cell inspectorCell = row.getCell(columnNumber);
        if (inspectorCell.getCellType().equals(CellType.FORMULA)) {
           CellValue cellValue = getCell(sheet, inspectorCell);
            String valueString = cellValue.getStringValue();
           return valueString;
        }
        return "";
    }


    private double getCellValueNumber(Sheet sheet, Row row, int columnNumber){
        Cell inspectorCell = row.getCell(columnNumber);
        if (inspectorCell.getCellType().equals(CellType.FORMULA)) {
            CellValue cellValue = getCell(sheet, inspectorCell);
            double valueString = cellValue.getNumberValue();
            return valueString;
        }
        return 0.0;
    }

    private CellValue getCell(Sheet sheet, Cell cell) {
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        CellReference cellReference = new CellReference(cell);
        Row rowInspector = sheet.getRow(cellReference.getRow());
        Cell cellInspector = rowInspector.getCell(cellReference.getCol());
        CellValue cellValue = evaluator.evaluate(cellInspector);
        return cellValue;
    }

    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        try {
            /*excelReader.getTrolleybus();
            excelReader.getEmployee();
            excelReader.getStops();
            excelReader.getDate();*/
            excelReader.getJourney();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


