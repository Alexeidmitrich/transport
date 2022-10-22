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
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.layout.element.Table;



public class WriterPdf {

    private String fileName;

    public WriterPdf(String fileName) {
        this.fileName = fileName;
    }

    public Path getScheduleForPerson(Person person, List<Journey> journeys) {
        Path path = null;
        File file = new File(fileName);
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 22);
        try (FileOutputStream fs = new FileOutputStream(file)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fs);
            document.open();
            PdfPTable table = new PdfPTable(2);
            addTableHeader(table);
            //addRows(table);
            //addCustomRows(table);
            Paragraph paragraph = new Paragraph();
            Set<LocalDate> localDates = new HashSet<>();
            for (int i = 0; i < journeys.size(); i++) {
                localDates.add(journeys.get(i).getDate());
            }
            Set<String> journeySet = new HashSet<>();
            for (int i = 0; i < journeys.size(); i++) {
                journeySet.add(journeys.get(i).getNumber());
            }
            List<String> journeySet1 = new ArrayList<>();
            for (int i = 0; i < journeys.size(); i++) {
                List<JourneyStop> journeyStops = journeys.get(i).getJourneyStops();
                for (int j = 0; j < journeyStops.size(); j++) {
                    JourneyStop journeyStop = journeyStops.get(j);
                    StopTransport stop = journeyStop.getStop();
                    LocalTime time = journeyStop.getTime();
                    //journeySet1.add(String.valueOf(time));
                    //journeySet1.add(String.valueOf(stop));
                    table.addCell(stop.toString());
                    table.addCell(time.toString());
                }
               break;
            }
            paragraph.add(new Paragraph(person.getFio(), normalFont));
            paragraph.add(new Paragraph("Рабочие дни", normalFont));
            paragraph.add(new Paragraph(localDates.toString(), normalFont));
            paragraph.add(new Paragraph("Рейсы", normalFont));
            paragraph.add(new Paragraph(journeySet.toString(), normalFont));
            /*paragraph.add(new Paragraph("Время", normalFont));
            paragraph.add(new Paragraph(journeySet1.toString(), normalFont));*/
            document.add(paragraph);
            document.add(table);
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

    /*private void addCustomRows(PdfPTable table)
            throws URISyntaxException, BadElementException, IOException {
        /*PdfPCell horizontalAlignCell = new PdfPCell(new Phrase(""));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);

        PdfPCell verticalAlignCell = new PdfPCell(new Phrase(""));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
    }

    private void addRows(PdfPTable table) {
        //table.addCell("row 1, col 2");
        //table.addCell("row 1, col 2");
    }*/

    private void addTableHeader(PdfPTable table) {
        Stream.of("Stop", "Time")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.BLUE);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
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
