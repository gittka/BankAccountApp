import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [HttpClientModule, CommonModule
  ],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{
  constructor(private http: HttpClient) {
  }
  accounts: any;

  ngOnInit(): void {
    this.http.get('http://localhost:8888/ACCOUNT-SERVICE/accounts')
      .subscribe({
        next: data => {
          this.accounts = data;
        },
        error: error => {
          console.error('There was an error!', error);
        }
      });
  }

}
