import { Veiculo } from './../models/veiculo';
import { HttpHeaderService } from './http-header.service';
import { Injectable } from '@angular/core';

import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class ApiService {
  nomesMarcas:string[]
  constructor(private http: HttpClient,private httpService:HttpHeaderService){
    this.nomesMarcas = ['Acura','Agrale','Alfa','Alpine','Amazon','Asa','Asia','Aston martin','Astra','Audi','Beach','Beijing','Bentley','Bmw','Bramont','Brilliance','Brm','Bugre','Buick','Busscar','Byd','Cadillac','Camc','Caoa chery','Caterham','Chamonix','Changan','Changhe','Chevrolet','Chrysler','Citroen','Cnhtc','Comil','Corvette','Daf','Daihatsu','Dfac','Dfm','Dfsk','Dodge','Dongfeng','Edra','Effa','Emisul','Faw','Fercar','Ferrari','Fiat','Fibravan','Fisker','Ford','Foton','Freightliner','Fyber','Gamma','Geely','Gmw','Gonow','Great','Grove','Guang','Hafei','Haima','Hino','Honda','Hualing','Hummer','Hyundai','Infiniti','International','Irisbus','Iveco','J.silva','Jac','Jag','Jaguar','Jeep','Jianghuai','Jiangxi','Jiayuan','Jinbei','Jmc','Jonway','Kaltec','Kamaz','Kenworth','Khaltec','Kia','Lada','Lamborghini','Land rover','Landwind','Ldv','Lexus','Lifan','Lincoln','Lobini','Lotus','Luzz','Mahindra','Man','Marcopolo','Maserati','Mazda','Mclaren','Mercedes-Benz','Mg','Mini','Mitsubishi','Morgan','Newtrack','Nissan','Peugeot','Pontiac','Porsche','Puma','Rely','Renault','Reva','Rolls royce','Saturn','Scania','Scion','Selvagem','Shacman','Shandong','Shelby','Sinotruck','Sinotruk','Skoda','Smart','Spartan','Spyker','SS Fiberglass','Ssangyong','Subaru','Suzuki','Tac','Tesla','Think','Tiffin','Toyota','Trazo','Triway','Troller','Tutto','Uri','Victory','Volkswagen','Volvo','Wake','Walk','Wheego','Wiesmann','Zhejiang','Zna','Zotye','Zxauto']
  }
  baseUrl: string = '/api/veiculos';


  getNomesMarcas(compare:string){
    if(this.nomesMarcas.includes(compare))
      return true
    return false
  }

  getAll():Observable<Veiculo[]>{
    return this.http.get<Veiculo[]>(this.baseUrl).pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  getById(id: string):Observable<Veiculo>{
    return this.http.get<Veiculo>(this.baseUrl+'/'+id).pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  getByQuery(q: string):Observable<Veiculo[]>{
    return this.http.get<Veiculo[]>(this.baseUrl+'/find?q='+q).pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  create(veiculo: Veiculo):Observable<Veiculo>{
    return this.http
      .post<Veiculo>(this.baseUrl, veiculo, this.httpService.httpOptions).pipe(
        retry(2),
        catchError(this.httpService.handleError)
      );
  }
  updateAllFields(id: string, veiculo: Veiculo):Observable<Veiculo>{
    return this.http
      .put<Veiculo>(this.baseUrl + '/' + id, veiculo, this.httpService.httpOptions)
      .pipe(
        retry(2),
        catchError(this.httpService.handleError)
      )
  }
  updateSomeFields(id: string, veiculo:Veiculo):Observable<Veiculo>{
    return this.http
      .patch<Veiculo>(this.baseUrl + '/' + id,veiculo, this.httpService.httpOptions)
      .pipe(
        tap(res=>console.log(res)),
        retry(2),
        catchError(this.httpService.handleError)
      )
  }
  delete(id: string):Observable<Veiculo>{
    return this.http
    .delete<Veiculo>(this.baseUrl + '/' + id, this.httpService.httpOptions)
    .pipe(
      catchError(this.httpService.handleError)
    )
  }
  listWeek():Observable<Veiculo[]>{
    return this.http.get<Veiculo[]>(this.baseUrl+"/lastWeek").pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  listAno():Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl+"/listDecade").pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  listMarca():Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl+"/listMarca").pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
  listAllfromLastWeek():Observable<Veiculo>{
    return this.http.get<Veiculo>(this.baseUrl+"/listDecada").pipe(
      retry(2),
      catchError(this.httpService.handleError)
    );
  }
}
