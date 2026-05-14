package com.example.api.dto;

public class ServiciosAdicionalesDTO {
    private int id;
    private String roaming;
    private String internacional;
    private boolean legalitas;
    private boolean cloud;
    private boolean ciberProteccion;
    private boolean atencionPersonalizada;
    private String centralita;
    private int numeroBeneficios;
    private String descuentoBeneficios;
    public ServiciosAdicionalesDTO() {
    }
    public ServiciosAdicionalesDTO(int id, String roaming, String internacional, boolean legalitas, boolean cloud,
            boolean coberProteccion, boolean atencionPersonalizada, String centralita, int numeroBeneficios,
            String descuentoBeneficios) {
        this.id = id;
        this.roaming = roaming;
        this.internacional = internacional;
        this.legalitas = legalitas;
        this.cloud = cloud;
        this.ciberProteccion = coberProteccion;
        this.atencionPersonalizada = atencionPersonalizada;
        this.centralita = centralita;
        this.numeroBeneficios = numeroBeneficios;
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
        return legalitas;
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
    public int getNumeroBeneficios() {
        return numeroBeneficios;
    }
    public void setNumeroBeneficios(int numeroBeneficios) {
        this.numeroBeneficios = numeroBeneficios;
    }
    public String getDescuentoBeneficios() {
        return descuentoBeneficios;
    }
    public void setDescuentoBeneficios(String descuentoBeneficios) {
        this.descuentoBeneficios = descuentoBeneficios;
    }
    
}
