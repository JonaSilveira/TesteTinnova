import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChartType } from 'chart.js';
import { Veiculo } from 'src/app/models/veiculo';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-veiculo-list',
  templateUrl: './veiculo-list.component.html',
  styleUrls: ['./veiculo-list.component.css']
})
export class VeiculoListComponent implements OnInit {

  veiculos:Veiculo[]
  marca:any[] = []
  decade:any[] = []
  lastWeek:Veiculo[] = []
  searchText:string =""
  constructor(public apiService: ApiService,public router: Router,) {
    this.veiculos = [];
   }

  ngOnInit(): void {
    this.getAll();
    this.getLastWeek();
    this.getByMarca();
    this.byDecade()
  }

  getAll(){
    this.apiService.getAll().subscribe(
      res=>{
        this.veiculos = res
      }
    )
  }

  byDecade(){
    this.apiService.listAno().subscribe(
      res=>{
        this.decade = res
        console.log(res)
      }
    )
  }

  findByQuery(){
    this.apiService.getByQuery(this.searchText).subscribe(res=>{
      this.veiculos = res;
    })
  }
  edit(id:string, veiculo:Veiculo){
    veiculo.vendido = !veiculo.vendido;
    this.apiService.updateSomeFields(id, veiculo).subscribe(
      res=>console.log(res)
    )
  }

  getLastWeek(){
    this.apiService.listWeek().subscribe(
      res=>{
        this.lastWeek = res

      }
    )
  }
  getByMarca(){
    this.apiService.listMarca().subscribe(
      res=>{
        this.marca = res
      }
    )

  }

  delete(id:string) {
    //Delete item in Student data
    this.apiService.delete(id).subscribe(Response => {
      //Update list after delete is successful
      this.ngOnInit();
    },
    error=>{
      this.ngOnInit ();
    }
    );
  }
  update(id:string){
    this.router.navigate([`/edit/${id}`])
  }



}
