import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomersComponent } from './customers/customers.component';
import { DataService } from './data.service';
import { CreateCustomerComponent } from './create-customer/create-customer.component';

import {enableProdMode} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { IndexComponent } from './index/index.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailsComponent,
    CustomersComponent,
    CreateCustomerComponent,
    IndexComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    NgbModule.forRoot()
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
