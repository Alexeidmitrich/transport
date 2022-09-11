package com.example.transport.shedule;

import com.example.transport.domain.Journey;
import com.example.transport.domain.JourneyStop;
import com.example.transport.domain.Person;
import com.example.transport.domain.StopTransport;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        testList(journeyList,2,4);
        List<Journey> journeyInnerFirstList = journeyList.get(0);
        Journey firstJourney = journeyInnerFirstList.get(0);
        assertEquals(7, firstJourney.getJourneyStops().size());
        for (int i = 0; i < firstJourney.getJourneyStops().size(); i++) {
            JourneyStop journeyStop = firstJourney.getJourneyStops().get(i);
            assertEquals("894", journeyStop.getTransport().getId());
            Person driver =  journeyStop.getDriver();
            assertEquals("КИН05600-2002",driver.getId());
            assertEquals("Костомаров Игорь Николаевич", driver.getFio());
            Person inspector = journeyStop.getInspector();
            assertEquals("НДД92345-2009", inspector.getId());
            assertEquals("Ногакин Дмитрий Дмитриевич", inspector.getFio());

        }
        List<JourneyStop> stops = journeyInnerFirstList.get(0).getJourneyStops();
        //JourneyStop stop = stops.get(0);
        assertEquals(7,stops.size());

    }

    private void testList( List<List<Journey>> journeyList,int index, int expectedSize) {
        List<Journey> journeyInnerFirstList = journeyList.get(index);
        assertEquals(expectedSize, journeyInnerFirstList.size());
    }


}