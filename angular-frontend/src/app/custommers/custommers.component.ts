import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-custommers',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './custommers.component.html',
  styleUrl: './custommers.component.css'
})
export class CustommersComponent implements OnInit{
  constructor(private http: HttpClient) {
  }
  customers: any;

  ngOnInit(): void {
      this.http.get('http://localhost:8888/CUSTOMER-SERVICE/customers')
        .subscribe({
          next: data => {
            this.customers = data;
          },
          error: error => {
            console.error('There was an error!', error);
          }
        });
  }
}
