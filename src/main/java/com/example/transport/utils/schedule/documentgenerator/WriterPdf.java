package com.example.transport.utils.schedule.documentgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.example.transport.domain.Journey;
import com.example.transport.domain.JourneyStop;
import com.example.transport.domain.Person;
import com.example.transport.domain.StopTransport;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.layout.property.TextAlignment;



public class WriterPdf {

    private String fileName;

    public WriterPdf(String fileName) {
        this.fileName = fileName;
    }

    public Path getScheduleForPerson(Person person, List<Journey> journeys) {
        Path path = null;
        File file = new File(fileName);
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 14);
        try (FileOutputStream fs = new FileOutputStream(file)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fs);
            document.open();
            Paragraph personInformation = new Paragraph();
            Set<LocalDate> localDates = new HashSet<>();
            for (int i = 0; i < journeys.size(); i++) {
                localDates.add(journeys.get(i).getDate());
            }
            Set<String> journeySet = new HashSet<>();
            personInformation.add(new Paragraph(person.getFio(), normalFont));
            personInformation.add(new Paragraph("Рабочие дни", normalFont));
            personInformation.add(new Paragraph(localDates.toString(), normalFont));
            document.add(personInformation);
            for (int i = 0; i < journeys.size(); i++) {
                PdfPTable table = new PdfPTable(2);
                journeySet.add(journeys.get(i).getNumber());
                PdfPCell cell = new PdfPCell(new Phrase(journeys.get(i).getNumber()));
                cell.setColspan(2);
                table.addCell(cell);
                addTableHeader(table);
                List<JourneyStop> journeyStops = journeys.get(i).getJourneyStops();
                for (int j = 0; j < journeyStops.size(); j++) {
                    JourneyStop journeyStop = journeyStops.get(j);
                    StopTransport stop = journeyStop.getStop();
                    LocalTime time = journeyStop.getTime();
                        table.addCell(new Phrase(stop.getName(), normalFont));
                        table.addCell(time.toString());
                    }
                table.setSpacingBefore(30);
                table.setSpacingAfter(30);
                document.add(table);
            }
            document.close();
            path = file.toPath();
        }
        catch (DocumentException exc) {
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
        return path;
    }

    private void addTableHeader1(PdfPTable table) {
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 14);
        Stream.of("Рейс")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(columnTitle, normalFont));
                    table.addCell(header);
                });

    }
    private void addTableHeader(PdfPTable table) {
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 14);
        Stream.of("Остановки", "Время")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(columnTitle, normalFont));
                    table.addCell(header);
                });
    }

    public static void main(String[] args){
        //Person person = new Person();
        WriterPdf pdf = new WriterPdf("C:\\Users\\alexe\\Downloads\\Doc1.pdf");
        //pdf.getPdfInCyrillic(person);
        //System.out.println();
    }
}
