import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'book-network-ui';
  data: any;

  constructor(private http: HttpClient) { // Inject HttpClient
    this.fetchData(); // Call the function to fetch data (e.g., in ngOnInit)
  }

  fetchData() {
    this.http.get('https://jsonplaceholder.typicode.com/todos/1') // Example API URL
      .subscribe({
        next: (data) => {
          this.data = data;
          console.log(this.data); // Or use it in your template
        },
        error: (error) => {
          console.error('Error fetching data:', error);
          // Handle errors, maybe display a message to the user
        }
      });
  }
}
