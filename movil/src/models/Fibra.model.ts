import { Tarifa } from "./Tarifa.model";

export interface Fibra {
    id: number;
    nombre: string;
    sobrecargo: number;
    tarifa: Tarifa;
}