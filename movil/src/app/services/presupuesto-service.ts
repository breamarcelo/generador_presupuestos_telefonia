
import { Injectable } from '@angular/core';
import { CapacitorHttp, HttpOptions } from '@capacitor/core';
import { from } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PresupuestoService {

  getList() {
    const options: HttpOptions = {
      url: 'http://10.0.2.2:8080/api/presupuestos',
      params: {}
    }
    return from(CapacitorHttp.get(options));
  }

  getSelected(id: number) {
    const options: HttpOptions = {
      url: `http://10.0.2.2:8080/api/presupuestos/${id}`,
      params: {}
    }
    return from(CapacitorHttp.get(options));
  }

}
