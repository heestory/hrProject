import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {IndexComponent} from './index/index.component';
import {AdminComponent} from './admin/admin.component';

import {CustomersComponent} from './customers/customers.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {CustomerDetailsComponent} from './customer-details/customer-details.component';

const routes: Routes = [
   { path: '', redirectTo: 'index', pathMatch: 'full' },
   { path: 'index',  component: IndexComponent },
   { path: 'admin',  component: AdminComponent },
   { path: 'customer',  component: CustomersComponent },
   { path: 'add', component: CreateCustomerComponent },
   { path: 'detail/:id', component: CustomerDetailsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
