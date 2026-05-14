package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.dto.CentralitasDTO;
import com.example.api.dto.DescuentosDTO;
import com.example.api.dto.FibrasDTO;
import com.example.api.dto.LineasAdicionalesDTO;
import com.example.api.dto.LineasPresupuestoDTO;
import com.example.api.dto.PacksFutbolDTO;
import com.example.api.dto.PresupuestosDTO;
import com.example.api.dto.ResultDTO;
import com.example.api.dto.ServiciosAdicionalesDTO;
import com.example.api.dto.StreamingDTO;
import com.example.api.dto.TarifasDTO;
import com.example.api.model.LineasPresupuestoEntity;
import com.example.api.model.PresupuestosEntity;

@Service
public class PresupuestosService {
    private PresupuestosService instance;

    private PresupuestosService(){}

    public PresupuestosService getInstance() {
        if(instance == null) {
            instance = new PresupuestosService();
        }
        return instance;
    }

    public ResultDTO toDto(PresupuestosEntity entity, List<LineasPresupuestoEntity> lineaList) {
        DescuentosDTO descuento = new DescuentosDTO();
        PacksFutbolDTO packFutbol = new PacksFutbolDTO();
        CentralitasDTO centralita = new CentralitasDTO();
        StreamingDTO streaming = new StreamingDTO();
        FibrasDTO fibra = new FibrasDTO();
        ServiciosAdicionalesDTO serviciosAdicionales = new ServiciosAdicionalesDTO();
        TarifasDTO tarifa = new TarifasDTO();
        PresupuestosDTO presupuesto = new PresupuestosDTO();
        double total = 0;
        ResultDTO dto = new ResultDTO();

        if(entity.getPackFutbol() != null) {
            packFutbol.setId(entity.getPackFutbol().getId());
            packFutbol.setNombre(entity.getPackFutbol().getNombre());
            packFutbol.setPrecio(entity.getPackFutbol().getPrecio());
            total += entity.getPackFutbol().getPrecio();
        }

        if(entity.getCentralita() != null) {
            centralita.setId(entity.getCentralita().getId());
            centralita.setNombre(entity.getCentralita().getNombre());
            centralita.setPrecio(entity.getCentralita().getPrecio());
            total += entity.getCentralita().getPrecio();
        }

        if(entity.getStreaming() != null) {
            streaming.setId(entity.getStreaming().getId());
            streaming.setNombre(entity.getStreaming().getNombre());
        }

        if(entity.getTarifa() != null) {
            fibra.setId(entity.getFibra().getId());
            fibra.setNombre(entity.getFibra().getNombre());
            fibra.setSobrecargo(entity.getFibra().getSobrecargo());
            
            serviciosAdicionales.setId(entity.getTarifa().getServiciosAdicionales().getId());
            serviciosAdicionales.setRoaming(entity.getTarifa().getServiciosAdicionales().getRoaming());
            serviciosAdicionales.setInternacional(entity.getTarifa().getServiciosAdicionales().getInternacional());
            serviciosAdicionales.setLegalitas(entity.getTarifa().getServiciosAdicionales().isLegalitas());
            serviciosAdicionales.setCloud(entity.getTarifa().getServiciosAdicionales().isCloud());
            serviciosAdicionales.setCiberProteccion(entity.getTarifa().getServiciosAdicionales().isCiberProteccion());
            serviciosAdicionales.setAtencionPersonalizada(entity.getTarifa().getServiciosAdicionales().isAtencionPersonalizada());
            serviciosAdicionales.setCentralita(entity.getTarifa().getServiciosAdicionales().getCentralita());
            serviciosAdicionales.setNumeroBeneficios(entity.getTarifa().getServiciosAdicionales().getNumeroBeneficios());
            serviciosAdicionales.setDescuentoBeneficios(entity.getTarifa().getServiciosAdicionales().getDescuentoBeneficios());
            
            tarifa.setId(entity.getTarifa().getId());
            tarifa.setNombre(entity.getTarifa().getNombre());
            tarifa.setTipo(entity.getTarifa().getTipo());
            tarifa.setLineasMoviles(entity.getTarifa().getLineasMoviles());
            tarifa.setLlamadasMovil(entity.getTarifa().getLlamadasMovil());
            tarifa.setGbMovil(entity.getTarifa().getGbMovil());
            tarifa.setPrecio(entity.getTarifa().getPrecio());
            tarifa.setServiciosAdicionales(serviciosAdicionales);
            tarifa.setTv(entity.getTarifa().isTv());
            tarifa.setStreaming(entity.getTarifa().isStreaming());
            
            if(entity.getDescuento() != null) {
                descuento.setId(entity.getDescuento().getId());
                descuento.setPorciento(entity.getDescuento().getPorciento());
                total += (entity.getTarifa().getPrecio() - ((entity.getTarifa().getPrecio()*entity.getDescuento().getPorciento())/100)) + fibra.getSobrecargo();
            } else {
                total += entity.getTarifa().getPrecio() + fibra.getSobrecargo();
            }
        }

        presupuesto.setId(entity.getId());
        presupuesto.setNombre(entity.getNombre());
        presupuesto.setTarifa(tarifa);
        presupuesto.setFibra(fibra);
        presupuesto.setStreaming(streaming);
        presupuesto.setCentralita(centralita);
        presupuesto.setPackFutbol(packFutbol);
        presupuesto.setDescuento(descuento);

        List<LineasPresupuestoDTO> lineasPresupuestoDTOs = new ArrayList<>();
        for (LineasPresupuestoEntity linea : lineaList) {
            LineasAdicionalesDTO lineasAdicionalesDTO = new LineasAdicionalesDTO();
            LineasPresupuestoDTO lineasPresupuestoDTO = new LineasPresupuestoDTO();

            lineasAdicionalesDTO.setId(linea.getLineaAdicional().getId());
            lineasAdicionalesDTO.setNombre(linea.getLineaAdicional().getNombre());
            lineasAdicionalesDTO.setTipo(linea.getLineaAdicional().getTipo());
            lineasAdicionalesDTO.setNumeroLineas(linea.getLineaAdicional().getNumLineas());
            lineasAdicionalesDTO.setLlamadas(linea.getLineaAdicional().getLlamadas());
            lineasAdicionalesDTO.setGb(linea.getLineaAdicional().getGb());
            lineasAdicionalesDTO.setFibra(linea.getLineaAdicional().getFibra());
            lineasAdicionalesDTO.setPrecio(linea.getLineaAdicional().getPrecio());

            lineasPresupuestoDTO.setId(linea.getId());
            lineasPresupuestoDTO.setCantidad(linea.getCantidad());
            lineasPresupuestoDTO.setLineaAdicional(lineasAdicionalesDTO);

            lineasPresupuestoDTOs.add(lineasPresupuestoDTO);
            total += lineasPresupuestoDTO.getCantidad() * lineasAdicionalesDTO.getPrecio();
        }
        
        dto.setPresupuesto(presupuesto);
        dto.setLineas(lineasPresupuestoDTOs);
        dto.setTotal(total);
        dto.setServiciosAdicionales(serviciosAdicionales);
        return dto;
    }
}
