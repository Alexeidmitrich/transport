package com.example.transport.shedule;

import com.example.transport.domain.Journey;
import com.example.transport.domain.JourneyStop;
import com.example.transport.domain.Person;
import com.example.transport.domain.StopTransport;
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
        //TODO
        assertThrows(ExcelException.class, () ->excelReader.getEmployee(), "Expected ExcelException. File is empty");

    }

    private void testList( List<List<Journey>> journeyList,int index, int expectedSize) {
        List<Journey> journeyInnerFirstList = journeyList.get(index);
        assertEquals(expectedSize, journeyInnerFirstList.size());
    }


}