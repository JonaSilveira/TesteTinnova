import { VeiculoListComponent } from './components/veiculo-list/veiculo-list.component';
import { VeiculoEditComponent } from './components/veiculo-edit/veiculo-edit.component';
import { VeiculoCreateComponent } from './components/veiculo-create/veiculo-create.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'create' },
  { path: 'create', component: VeiculoCreateComponent },
  { path: 'edit/:id', component: VeiculoEditComponent},
  { path: 'list', component: VeiculoListComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
