import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Veiculo } from 'src/app/models/veiculo';
import { ApiService } from 'src/app/services/api.service';
@Component({
  selector: 'app-veiculo-create',
  templateUrl: './veiculo-create.component.html',
  styleUrls: ['./veiculo-create.component.css']
})
export class VeiculoCreateComponent implements OnInit {

  veiculo:Veiculo;

  constructor(
    public apiService: ApiService,
    public router: Router
  ) {
    this.veiculo = new Veiculo();
  }

  ngOnInit(): void {
  }

  submitForm() {
    if(!this.apiService.getNomesMarcas(this.veiculo.marca))
      alert('Nome incorreto, por favor digite um nome valido')
    else
      this.apiService.create(this.veiculo).subscribe((response) => {
        this.router.navigate(['list']);
      });

  }

}
