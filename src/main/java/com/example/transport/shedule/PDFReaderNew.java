package com.example.transport.shedule;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;

    public class PDFReaderNew{
        public static void main(String args[]) throws Exception {
            String dest = "C:\\Users\\alexe\\Downloads\\Doc2.pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            Paragraph paragraph = new Paragraph("Tutorials");
            List list = new List();
            list.add("Jva");
            list.add("JavFX");
            list.add("Apache Tika");
            list.add("OpenCV");
            list.add("WebGL");
            list.add("Coffee Script");
            list.add("Java RMI");
            list.add("Apache Pig");
            document.add(paragraph);

            document.add(list);
            document.close();
            System.out.println("List added");
        }
    }