package com.budgetsgenerator.xml.models;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Presupuesto")
public class PresupuestoXml {
   private List<LineasPresupuestoXml> lineas;
   private String total;

   public PresupuestoXml() {
   }

   public PresupuestoXml(List<LineasPresupuestoXml> lineas, String total) {
      this.lineas = lineas;
      this.total = total;
   }

   @XmlElementWrapper(name="LineasPresupuesto")
   @XmlElement(name="Linea")
   public List<LineasPresupuestoXml> getLineas() {
      return lineas;
   }

   public void setLineas(List<LineasPresupuestoXml> lineas) {
      this.lineas = lineas;
   }

   @XmlElement(name="Total")
   public String getTotal() {
      return total;
   }

   public void setTotal(String total) {
      this.total = total;
   }

   

}
