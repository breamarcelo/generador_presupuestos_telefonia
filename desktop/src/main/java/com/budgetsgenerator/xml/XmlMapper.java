package com.budgetsgenerator.xml;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.viewmodels.ResumentTableItem;
import com.budgetsgenerator.xml.models.LineasPresupuestoXml;
import com.budgetsgenerator.xml.models.PresupuestoXml;


public class XmlMapper {
    private static XmlMapper instance;
    
    private XmlMapper(){
    }
    
    public static XmlMapper getInstance() {
        if(instance == null) {
            instance = new XmlMapper();
        }
        return instance;
    }
    
    public PresupuestoXml lineaToToXml(List<ResumentTableItem> tableItems, String total){
        List<LineasPresupuestoXml> listaLineas = new ArrayList<>();
        LineasPresupuestoXml xml = null;
        
        for(ResumentTableItem item : tableItems) {
            xml = new LineasPresupuestoXml();
            String descripcion = "";
            
            for(String line : item.getDescripcion().getItems()) {
                descripcion += line + "\n";
            }

            xml.setCantidad(Integer.toString(item.getCantidad()));
            xml.setDescripcion(descripcion);
            xml.setImporte(Double.toString(item.getImporte()));

            listaLineas.add(xml);
        }
        return new PresupuestoXml(listaLineas, total);
    }
}
