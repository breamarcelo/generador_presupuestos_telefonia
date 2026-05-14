import { LineasPresupuesto } from "./LineasPresupuesto.model";
import { Presupuesto } from "./Presupuesto.model";
import { ServiciosAdicionales } from "./ServiciosAdicionales.model";

export interface Result {
    presupuesto: Presupuesto;
    lineas: LineasPresupuesto[];
    serviciosAdicionales: ServiciosAdicionales;
    total: number;
}