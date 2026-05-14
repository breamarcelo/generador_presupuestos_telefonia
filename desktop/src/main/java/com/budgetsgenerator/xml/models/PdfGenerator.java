package com.budgetsgenerator.xml.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class PdfGenerator {
    public void generatePdf(String htmlContent, File outputFile) throws Exception {
        try(OutputStream os = new FileOutputStream(outputFile)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(htmlContent, "");
            builder.toStream(os);
            builder.run();
        }
    }
}
