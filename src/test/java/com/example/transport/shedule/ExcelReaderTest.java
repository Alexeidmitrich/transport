package com.example.transport.shedule;

import com.example.transport.domain.*;
import com.example.transport.exception.ExcelException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {


    @Test
    void getJourneyTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("com.example.transport.shedule/Timetable.xls").getFile());
        ExcelReader excelReader = new ExcelReader(file);
        List<List<Journey>> journeyList = excelReader.getJourney();
        assertEquals(3, journeyList.size());
        testList(journeyList, 0, 4);
        testList(journeyList, 1, 4);
        testList(journeyList, 2, 4);
        List<Journey> journeyInnerFirstList = journeyList.get(0);
        Journey firstJourney = journeyInnerFirstList.get(0);
        assertEquals(7, firstJourney.getJourneyStops().size());
        String[] expectedTime = {"04:59", "05:03", "05:04", "05:05", "05:07", "05:09", "05:10"};
        String[] stopTransport = {"ОСТ1000001", "ОСТ1000002", "ОСТ1000009", "ОСТ1000012", "ОСТ1000013", "ОСТ1000018", "ОСТ1000021"};
        for (int i = 0; i < firstJourney.getJourneyStops().size(); i++) {
            JourneyStop journeyStop = firstJourney.getJourneyStops().get(i);
            assertEquals("894", journeyStop.getTransport().getId());
            Person driver = journeyStop.getDriver();
            assertEquals("КИН05600-2002", driver.getId());
            assertEquals("Костомаров Игорь Николаевич", driver.getFio());
            Person inspector = journeyStop.getInspector();
            assertEquals("НДД92345-2009", inspector.getId());
            assertEquals("Ногакин Дмитрий Дмитриевич", inspector.getFio());
            LocalTime timeJourney = journeyStop.getTime();
            assertEquals(expectedTime[i], timeJourney.toString());
            StopTransport stop = journeyStop.getStop();
            assertEquals(stopTransport[i],stop.getId());

        }
    }

    @Test
    void emptyFileTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("com.example.transport.shedule/EmptyTimetable.xls").getFile());
        ExcelReader excelReader = new ExcelReader(file);
        List<List<Journey>> journeys = excelReader.getJourney();
        assertEquals(0, journeys.size());
        assertThrows(ExcelException.class, ()->excelReader.getEmployee(), "Expected ExcelException. Excel is empty");
        assertThrows(ExcelException.class, ()->excelReader.getStops(), "Expected ExcelException. Excel is empty");

    }

    private void testList( List<List<Journey>> journeyList,int index, int expectedSize) {
        List<Journey> journeyInnerFirstList = journeyList.get(index);
        assertEquals(expectedSize, journeyInnerFirstList.size());
    }
    @Test
    void transportTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("com.example.transport.shedule/Timetable.xls").getFile());
        ExcelReader excelReader = new ExcelReader(file);
        Map<String, Transport> transportMap = excelReader.getTransport();
        String[] trollTransport = {"894","895","896","897","986","677","543","4322","4565","4433","4555","2134","2135","2156","4569"};
        for (int i = 0; i < trollTransport.length; i++) {
            //System.out.println(entry.getKey() + " <> " + entry.getValue());
            assertTrue(transportMap.containsKey(trollTransport[i]));
        }
    }

    @Test
    void getJourneyWrong() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("com.example.transport.shedule/TimetableMoreWrong.xls").getFile());
        ExcelReader excelReader = new ExcelReader(file);
        assertThrows(ExcelException.class,()->excelReader.getJourney(),"");
    }

    @Test
    void emptyPeopleTest() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("com.example.transport.shedule/TimeTableEmptyPeople.xls").getFile());
        ExcelReader excelReader = new ExcelReader(file);
        assertThrows(ExcelException.class,()->excelReader.getJourney(),"");
    }


}