import { LineasAdicionales } from "./LineasAdicionales.model";

export interface LineasPresupuesto {
    id: number;
    cantidad: number;
    lineaAdicional: LineasAdicionales;
}