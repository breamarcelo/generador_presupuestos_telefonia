package com.budgetsgenerator.xml;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.PresupuestoXml;

public class XmlService {
    private static XmlService instance;
    private static XmlMapper mapper;
    private static XmlGenerator xmlGenerator;
    private static PdfGenerator pdfGenerator = new PdfGenerator();
    private static PresupuestoXml presupuestoXml;

    private XmlService(){
    }

    public static XmlService getInstance() {
        if(instance == null) {
            instance = new XmlService();
        }
        return instance;
    }

    public void createPdf(List<ResumentTableItem> tableItems, String total, String filePath){
        presupuestoXml = mapper.getInstance().lineaToToXml(tableItems, total);
        String xml = xmlGenerator.getInstance().createXml(presupuestoXml);
        InputStream xsl = getClass().getResourceAsStream("/templates/presupuesto.xsl");
        try {
            String html = transformXmltoHtml(xml, xsl);
            pdfGenerator.generatePdf(html, new File(filePath));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }

    public String transformXmltoHtml(String xmlData, InputStream xslStream) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslStream));
        StringWriter writer = new StringWriter();
        transformer.transform(new StreamSource(new StringReader(xmlData)), new StreamResult(writer));
        return writer.toString();
    }
}
