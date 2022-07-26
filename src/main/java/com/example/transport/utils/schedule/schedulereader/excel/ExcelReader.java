package com.example.transport.utils.schedule.schedulereader.excel;

import com.example.transport.domain.*;
import com.example.transport.exception.ExcelException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
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

    public ExcelReader(File file){
        try{
           wb = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  Map<String, Transport> getTransport() throws  Exception{
          Sheet sheet = wb.getSheetAt(0);
          List<Transport> transportMaps = PoiPOJOUtils.sheetToPOJO(sheet, Transport.class)
          .stream().filter(transport -> !transport.getId().isEmpty()).collect(Collectors.toList());
          Map<String, Transport> transportMap = transportMaps
                  .stream()
                  .collect(Collectors.toMap(Transport::getId, Function.identity()));
         return transportMap;
    }

    public Map<String, Person> getEmployee() throws Exception {
        if(wb.getNumberOfSheets() < 3){
            throw new Exception("Excel has no sheet with employee");
        }
        Sheet sheet = wb.getSheetAt(2);
        List<Person> personList = PoiPOJOUtils.sheetToPOJO(sheet, Person.class);
        Map<String, Person> personMap = personList
                .stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        return personMap;
    }

    public Map<String , StopTransport> getStops() throws Exception {
        if(wb.getNumberOfSheets() < 4){
            throw new ExcelException("Excel has no sheet with stops");
        }
        Sheet sheet = wb.getSheetAt(3);
        List<StopTransport> stopTransportList = PoiPOJOUtils.sheetToPOJO(sheet, StopTransport.class);
        Map<String, StopTransport> stopTransporMap = stopTransportList
                .stream()
                .collect(Collectors.toMap(StopTransport::getId, Function.identity()));
        return stopTransporMap;
    }



    public List<List<Journey>> getJourney() throws Exception {

        // Map<LocalDate, List<Journey>> journeyMap = new HashMap<>();
        List<List<Journey>> journeyList = new LinkedList<>();
        for (int i = FIRST_JOURNEY_SHEET; i < wb.getNumberOfSheets() ; i++) {
            journeyList.add(getJourney(i));
        }
        return journeyList;
    }

    private Journey getJourney(Sheet sheet, CellRangeAddress region, Cell cellWithJourneyInfo, CellRangeAddress metaInfoRegion) throws Exception {
        Map<String, StopTransport> stops = getStops();
        Map<String, Person> per = getEmployee();
        Map<String, Transport> transportMap = getTransport();
        Journey journey = new Journey();

        ExcelDate dateUtil = new ExcelDate();
        LocalDate date = dateUtil.getDateFromExcel(sheet.getSheetName());
        journey.setDate(date);
        String journeyInfo = cellWithJourneyInfo.
                getStringCellValue();
        Line line  = new Line();
        String [] journeyInfoArray = journeyInfo.split("\\s+");
        if(journeyInfoArray.length > 1){
            journey.setNumber(journeyInfoArray[1]);

        }
        int offset = FIRST_ROW_WITH_DATE;
        while (true) {
            Row beginRow = sheet.getRow(region.getFirstRow() + offset);
            offset++;
            if (beginRow == null) {
                break;
            }
            Cell cellNumber = beginRow.getCell(metaInfoRegion.getFirstColumn() + 2);
            //cellNumber.getCellType(CellType.STRING);
            String value = String.valueOf((int)cellNumber.getNumericCellValue());
            if (value == null) {
                break;
            }
            JourneyStop journeyStop = new JourneyStop();
            journey.setNumberForPassengers(value);

            if(line.getNumber() == null) {
                line.setNumber(journey.getNumberForPassengers());
            }
            double idTransport = getCellValueNumber(sheet, beginRow, region.getFirstColumn());
            String idTransportStr = String.valueOf((int) idTransport);
            Transport transport = transportMap.get(idTransportStr);
            journeyStop.setTransport(transport);
            String idStopStr = getCellValueString(sheet, beginRow, 1);
            StopTransport stopTransport = stops.get(idStopStr);
            journeyStop.setStop(stopTransport);
            String idDriverStr = getCellValueString(sheet, beginRow, region.getFirstColumn()+ 2);
            Person driver = per.get(idDriverStr);
             if (driver.getTitle().equals("Контроллер")){
               throw new ExcelException("Not found");
             }
            journeyStop.setDriver(driver);
            String idInspectorStr = getCellValueString(sheet, beginRow,region.getFirstColumn() + 3 );
            Person inspector = per.get(idInspectorStr);
            if (inspector.getTitle().equals("Водитель")){
                throw new ExcelException("Not found");
            }
            journeyStop.setInspector(inspector);

            Cell cellTime = beginRow.getCell(region.getFirstColumn() + 1);
                if (cellTime == null){
                   break;
                } if (cellTime.getLocalDateTimeCellValue() == null){
                    continue;
            }
            journeyStop.setTime(cellTime.getLocalDateTimeCellValue().toLocalTime());
            journey.addJourneyStop(journeyStop);

            line.addJourney(journey);
            journey.setLine(line);
            journeyStop.setJourney(journey);

        }
        return journey;
    }



    public List<Journey> getJourney(int sheetNumber) throws Exception {
        Sheet sheet = wb.getSheetAt(sheetNumber);
        List<CellRangeAddress> regions = sheet.getMergedRegions();
        List<Journey> journeys = new ArrayList<>();
        CellRangeAddress regionWithMetaInfo = regions.get(0);
        regions.remove(regionWithMetaInfo);
        int l = 0;
        for (CellRangeAddress region : regions) {
            Row firstRow = sheet.getRow(region.getFirstRow());
            if(firstRow == null){
                break;
            }
            Cell cellWithJourneyInfo = firstRow.getCell(sheet.getRow(region.getFirstRow()).getFirstCellNum() + l);
            if (cellWithJourneyInfo == null){
                break;
            }
            l = l + STEP_JOURNEY_BLOCK;
            Journey journey  = getJourney(sheet, region, cellWithJourneyInfo, regionWithMetaInfo);
            journeys.add(journey);
        }
        return journeys;
    }

    private String getCellValueString(Sheet sheet, Row row, int columnNumber){
        Cell inspectorCell = row.getCell(columnNumber);
        if(inspectorCell == null){
           throw new ExcelException("Excel is empty");
        }
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


