package com.example.transport.utils.schedule.documentgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.transport.domain.Journey;
import com.example.transport.domain.JourneyStop;
import com.example.transport.domain.Person;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class WriterPdf {

    private String fileName;

    public WriterPdf(String fileName) {
        this.fileName = fileName;
    }

    public Path getPdfInCyrillic(Person person, List<Journey> journeys) {
        Path path = null;
        File file = new File(fileName);
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 12);
        try (FileOutputStream fs = new FileOutputStream(file)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fs);
            document.open();
            Paragraph paragraph = new Paragraph();
            Set<LocalDate> localDates = new HashSet<>();
            for (int i = 0; i < journeys.size(); i++) {
                localDates.add(journeys.get(i).getDate());
            }

            paragraph.add(new Paragraph(person.getFio(), normalFont));
            paragraph.add(new Paragraph("Рабочие дни", normalFont));
            paragraph.add(new Paragraph(localDates.toString(), normalFont));
            //paragraph.add(new Paragraph("gggg", normalFont));
            document.add(paragraph);
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

    public static void main(String[] args){
        //Person person = new Person();
        WriterPdf pdf = new WriterPdf("C:\\Users\\alexe\\Downloads\\Doc1.pdf");
        //pdf.getPdfInCyrillic(person);
        //System.out.println();
    }
}
