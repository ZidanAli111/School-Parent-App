import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ParentDetails } from 'src/app/model/parent-details';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
   student:ParentDetails=new ParentDetails();
   id!: number;
  constructor(private studentService:StudentService,private route:ActivatedRoute, private router: Router) { }


  ngOnInit(): void {
    this.id=this.route.snapshot.params['parentId'];
    this.studentService.getStudentById(this.id).subscribe(data=>{
      this.student=data; 
      console.log(this.student);
    },
    error=>console.log(error));
  }
  onSubmit(){
    this.studentService.updateStudent(this.id,this.student).subscribe(data=>{
      console.log(data);
      this.router.navigate(['students'])
    })

  }

}
