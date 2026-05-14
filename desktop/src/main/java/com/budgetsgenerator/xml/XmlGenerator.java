package com.budgetsgenerator.xml;

import java.io.StringWriter;

import com.budgetsgenerator.xml.models.PresupuestoXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class XmlGenerator {
    private static XmlGenerator instance;
    private static JAXBContext context; 
    private static PresupuestoXml presupuesto;

    private XmlGenerator(){
    }

    public static XmlGenerator getInstance() {
        if(instance == null) {
            instance = new XmlGenerator();
        }
        return instance;
    }
    
    public static String createXml(PresupuestoXml presupuesto) {
        StringWriter sw = new StringWriter();
        try {
            context = JAXBContext.newInstance(PresupuestoXml.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // m.marshal(presupuesto, new File("presupuesto.xml"));
            m.marshal(presupuesto, sw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
