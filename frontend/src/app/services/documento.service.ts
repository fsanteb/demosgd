import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Resultado} from '../models/resultado.model';
import {BusquedaRequestDto} from '../dto/busquedaRequest.dto';
import {RegistroRequestDto} from '../dto/registroRequest.dto';

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {

  private _urlService = environment.URL_SVC_GDPNP;
  url = `${this._urlService}/documento`;

  constructor(private http: HttpClient) { }

  listarTiposDocumentos() {
    return this.http.get<Resultado>(`${this.url}/tipos`);
  }

  listarDocumentosTabla(params: BusquedaRequestDto) {
    return this.http.post<Resultado>(`${this.url}/busqueda`, params);
  }

  getDocumento(idDocumento: string) {
    return this.http.get<Resultado>(`${this.url}/detalle/${idDocumento}`);
  }

  removeDocumento(idDocumento: string) {
    return this.http.delete<Resultado>(`${this.url}/eliminar/${idDocumento}`);
  }

  getCalculaSigla(tipoDocumento: string) {
    return this.http.get<Resultado>(`${this.url}/calcularSigla/${tipoDocumento}`);
  }

  registrar(dto: RegistroRequestDto) {
    return this.http.post<Resultado>(`${this.url}/registrar`, dto);
  }
}
