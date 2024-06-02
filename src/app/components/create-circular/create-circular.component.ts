import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CircularDetails } from 'src/app/model/circular-details';
import { CircularService } from 'src/app/services/circular.service';

@Component({
  selector: 'app-create-circular',
  templateUrl: './create-circular.component.html',
  styleUrls: ['./create-circular.component.css']
})
export class CreateCircularComponent implements OnInit {
  circular: CircularDetails = new CircularDetails();

  constructor(private circularService: CircularService,
    private router: Router) { }

  ngOnInit(): void {

  }

  saveCirculars(): void {
    this.circularService.createCircular(this.circular).subscribe(data => {
      console.log(data);
      alert("Circular added successfully!!");
      this.navigateToAdmin(true);

    }, error => {
      console.error('Error adding circular', error);
      alert('Failed to add circualr. Please try again.');
    });
  }
  onSubmit() {
    
  }

 navigateToAdmin(isAdmin: boolean): void {
    this.router.navigate(['students'],
      { queryParams: { admin: isAdmin } });

  }


}

