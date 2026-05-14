import { Centralita } from "./Centralita.model";
import { Descuento } from "./Descuento.model";
import { Fibra } from "./Fibra.model";
import { PackFutbol } from "./PackFutbol.model";
import { Streaming } from "./Streaming.model";
import { Tarifa } from "./Tarifa.model";

export interface Presupuesto {
    id: number;
    nombre?: string;
    tarifa?: Tarifa;
    fibra?: Fibra;
    streaming?: Streaming;
    centralita?: Centralita;
    packFutbol?: PackFutbol;
    descuento?: Descuento;
}