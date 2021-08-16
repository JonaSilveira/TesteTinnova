import { Veiculo } from './../../models/veiculo';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-veiculo-edit',
  templateUrl: './veiculo-edit.component.html',
  styleUrls: ['./veiculo-edit.component.css']
})
export class VeiculoEditComponent implements OnInit {

  id:string = "";
  veiculo:Veiculo;

  constructor(
    public activatedRoute: ActivatedRoute,
    public router: Router,
    public apiService: ApiService
  ) {
    this.veiculo = new Veiculo();
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params["id"]
    this.apiService.getById(this.id).subscribe(response => {
      console.log(response);
      this.veiculo = response;
    })
  }
  update() {
    if(!this.apiService.getNomesMarcas(this.veiculo.marca))
      alert('Nome incorreto, por favor digite um nome valido')
    else{
      //Update item by taking id and updated data object
      this.apiService.updateAllFields(this.id, this.veiculo).subscribe(response => {
        this.router.navigate(['list']);
      })
    }
  }

}
