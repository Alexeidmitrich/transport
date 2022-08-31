package com.example.transport.myReaderExcel;

import com.example.transport.domain.Journey;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XLSParser {
    public Journey getJourney(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Journey.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);
        if (object instanceof Journey ) {
            Journey journey = (Journey) object;
            return journey;
        }
        return null;
    }
}
