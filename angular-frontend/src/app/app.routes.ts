import { Routes } from '@angular/router';
import {CustommersComponent} from "./custommers/custommers.component";
import {AccountsComponent} from "./accounts/accounts.component";

export const routes: Routes = [
  {path: "customers", component: CustommersComponent},
  {path: "accounts", component: AccountsComponent}
];
