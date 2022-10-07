package com.example.transport.utils.schedule.documentgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import com.example.transport.domain.Person;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class WriterPdf {
    protected static String person;
    private String fileName;

    public WriterPdf(String fileName) {
        this.fileName = fileName;
    }

    public WriterPdf() {

    }

    public Path getPdfInCyrillic(String person) {
        Path path = null;
        File file = new File(fileName);
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 22);
        try (FileOutputStream fs = new FileOutputStream(file)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fs);
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph(person, normalFont));
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
        WriterPdf pdf = new WriterPdf("C:\\Users\\alexe\\Downloads\\Doc1.pdf");
        pdf.getPdfInCyrillic(person);
        System.out.println();
    }

}
