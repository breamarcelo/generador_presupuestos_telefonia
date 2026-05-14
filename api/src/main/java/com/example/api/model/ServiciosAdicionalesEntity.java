package com.example.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TServicios_adicionales")
public class ServiciosAdicionalesEntity {
    @Id
    @Column(name="PK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Roaming")
    private String roaming;

    @Column(name="Internacional")
    private String internacional;

    @Column(name="Legalitas")
    private boolean legalitas;

    @Column(name="Cloud")
    private boolean cloud;
    
    @Column(name="Ciber_proteccion")
    private boolean ciberProteccion;

    @Column(name="Atencion_personalizada")
    private boolean atencionPersonalizada;

    @Column(name="Centralita")
    private String centralita;

    @Column(name="Numero_beneficios")
    private int numeroBeneficios;

    @Column(name="Descuento_beneficios")
    private String descuentoBeneficios;

    @OneToOne(mappedBy="serviciosAdicionales")
    private TarifasEntity tarifa;

    public ServiciosAdicionalesEntity() {
    }

    public ServiciosAdicionalesEntity(int id, String roaming, String internacional, boolean legalitas, boolean cloud,
            boolean ciberProteccion, boolean atencionPersonalizada, String centralita, int numeroBeneficios,
            String descuentoBeneficios) {
        this.id = id;
        this.roaming = roaming;
        this.internacional = internacional == null ? "" : internacional;
        this.legalitas = legalitas;
        this.cloud = cloud;
        this.ciberProteccion = ciberProteccion;
        this.atencionPersonalizada = atencionPersonalizada;
        this.centralita = centralita == null ? "" : centralita;
        this.numeroBeneficios = numeroBeneficios;
        this.descuentoBeneficios = descuentoBeneficios == null ? "" : descuentoBeneficios;
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

    public TarifasEntity getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifasEntity tarifa) {
        this.tarifa = tarifa;
    }
}
