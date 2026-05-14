import { ServiciosAdicionales } from "./ServiciosAdicionales.model";

export interface Tarifa {
    id: number;
    nombre: string;
    tipo: string;
    lineasMoviles: number;
    llamadasMovil: string;
    gbMovil: string;
    precio: number;
    serviciosAdicionales: ServiciosAdicionales;
    tv: boolean;
    streaming: boolean;
}