import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ChartsModule } from 'ng2-charts';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VeiculoCreateComponent } from './components/veiculo-create/veiculo-create.component';
import { VeiculoEditComponent } from './components/veiculo-edit/veiculo-edit.component';
import { VeiculoListComponent } from './components/veiculo-list/veiculo-list.component';
import {HttpClientModule} from  '@angular/common/http';
import { FormsModule }   from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    VeiculoCreateComponent,
    VeiculoEditComponent,
    VeiculoListComponent
  ],
  imports: [
    BrowserModule,
    ChartsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
