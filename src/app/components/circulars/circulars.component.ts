import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CircularDetails } from 'src/app/model/circular-details';
import { CircularService } from 'src/app/services/circular.service';

@Component({
  selector: 'app-circulars',
  templateUrl: './circulars.component.html',
  styleUrls: ['./circulars.component.css']
})
export class CircularsComponent implements OnInit {
  circulars: CircularDetails[]=[];
  

  constructor(
    private circularService: CircularService,
    private router: Router
    
  ) { }

  ngOnInit(): void {
   this.displayCirculars();
  }

  displayCirculars():void{
     this.circularService.getCirculars().subscribe(data=>{
      this.circulars=data;
      console.log(data);
     });
  }

  navigateToAdmin(isAdmin: boolean): void {
    this.router.navigate(['students'],
      { queryParams: { admin: isAdmin } });

  }
}
