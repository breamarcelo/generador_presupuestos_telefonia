package com.example.api.dto;

public class PresupuestosDTO {
    private int id;
    private String nombre;
    private TarifasDTO tarifa;
    private FibrasDTO fibra;
    private StreamingDTO streaming;
    private CentralitasDTO centralita;
    private PacksFutbolDTO packFutbol;
    private DescuentosDTO descuento;
    public PresupuestosDTO() {
    }
    public PresupuestosDTO(int id, String nombre, TarifasDTO tarifa, FibrasDTO fibra, StreamingDTO streaming,
            CentralitasDTO centralita, PacksFutbolDTO packFutbol, DescuentosDTO descuento) {
        this.id = id;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.fibra = fibra;
        this.streaming = streaming;
        this.centralita = centralita;
        this.packFutbol = packFutbol;
        this.descuento = descuento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TarifasDTO getTarifa() {
        return tarifa;
    }
    public void setTarifa(TarifasDTO tarifa) {
        this.tarifa = tarifa;
    }
    public FibrasDTO getFibra() {
        return fibra;
    }
    public void setFibra(FibrasDTO fibra) {
        this.fibra = fibra;
    }
    public StreamingDTO getStreaming() {
        return streaming;
    }
    public void setStreaming(StreamingDTO streaming) {
        this.streaming = streaming;
    }
    public CentralitasDTO getCentralita() {
        return centralita;
    }
    public void setCentralita(CentralitasDTO centralita) {
        this.centralita = centralita;
    }
    public PacksFutbolDTO getPackFutbol() {
        return packFutbol;
    }
    public void setPackFutbol(PacksFutbolDTO packFutbol) {
        this.packFutbol = packFutbol;
    }
    public DescuentosDTO getDescuento() {
        return descuento;
    }
    public void setDescuento(DescuentosDTO descuento) {
        this.descuento = descuento;
    }
    
}
