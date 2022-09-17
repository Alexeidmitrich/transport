package com.example.transport.shedule;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class WriterPdf {
    private String fileName;

    public WriterPdf(String fileName) {
        this.fileName = fileName;
    }

    public void getPdfInCyrillic() {
        Font normalFont = FontFactory.getFont("/fonts/times-roman.ttf", "cp1251", BaseFont.EMBEDDED, 22);
        try (FileOutputStream fs = new FileOutputStream(fileName)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fs);
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph("Проблема со шрифтами", normalFont));
            document.add(paragraph);
            document.close();
        }
        catch (DocumentException exc) {
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String[] args){
        WriterPdf pdf = new WriterPdf("C:\\Users\\alexe\\Downloads\\Doc1.pdf");
        pdf.getPdfInCyrillic();
        System.out.println();
    }

}
