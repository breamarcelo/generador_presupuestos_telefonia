package com.budgetsgenerator.dto;

public class ServiciosAdicionalesDTO {
    private int id;
    private String roaming;
    private String internacional;
    private boolean legalitas;
    private boolean cloud;
    private boolean ciberProteccion;
    private boolean atencionPersonalizada;
    private String centralita;
    private int numBeneficios;
    private String descuentoBeneficios;
    
    public ServiciosAdicionalesDTO() {
    }
    
    public ServiciosAdicionalesDTO(int id, String roaming, String internacional, boolean legalitas, boolean cloud,
            boolean ciberProteccion, boolean atencionPersonalizada, String centralita, int numBeneficios,
            String descuentoBeneficios) {
        this.id = id;
        this.roaming = roaming;
        this.internacional = internacional;
        this.legalitas = legalitas;
        this.cloud = cloud;
        this.ciberProteccion = ciberProteccion;
        this.atencionPersonalizada = atencionPersonalizada;
        this.centralita = centralita;
        this.numBeneficios = numBeneficios;
        this.descuentoBeneficios = descuentoBeneficios;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRoaming() {
        return roaming;
    }
    public void setRoaming(String roaming) {
        this.roaming = roaming;
    }
    public String getInternacional() {
        return internacional;
    }
    public void setInternacional(String internacional) {
        this.internacional = internacional;
    }
    public boolean isLegalitas() {
        return this.legalitas;
    }
    public void setLegalitas(boolean legalitas) {
        this.legalitas = legalitas;
    }
    public boolean isCloud() {
        return cloud;
    }
    public void setCloud(boolean cloud) {
        this.cloud = cloud;
    }
    public boolean isCiberProteccion() {
        return ciberProteccion;
    }
    public void setCiberProteccion(boolean ciberProteccion) {
        this.ciberProteccion = ciberProteccion;
    }
    public boolean isAtencionPersonalizada() {
        return atencionPersonalizada;
    }
    public void setAtencionPersonalizada(boolean atencionPersonalizada) {
        this.atencionPersonalizada = atencionPersonalizada;
    }
    public String getCentralita() {
        return centralita;
    }
    public void setCentralita(String centralita) {
        this.centralita = centralita;
    }
    public int getNumBeneficios() {
        return numBeneficios;
    }
    public void setNumBeneficios(int numBeneficios) {
        this.numBeneficios = numBeneficios;
    }
    public String getDescuentoBeneficios() {
        return descuentoBeneficios;
    }
    public void setDescuentoBeneficios(String descuentoBeneficios) {
        this.descuentoBeneficios = descuentoBeneficios;
    }
}
