export class Veiculo {

    id:string;
    created: string;
    updated: string;
    veiculo: string;
    marca: string;
    ano: number;
    descricao: string;
    vendido: boolean

  constructor(){
    this.id = "";
    this.created  = "";
    this.updated  = "";
    this.veiculo  = "";
    this.marca  = "";
    this.ano = 0;
    this.descricao  = "";
    this.vendido = false;
  }

}
