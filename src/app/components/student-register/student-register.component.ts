import { Component, OnInit } from '@angular/core';
import { ParentDetails } from 'src/app/model/parent-details';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-register',
  templateUrl: './student-register.component.html',
  styleUrls: ['./student-register.component.css']
})
export class StudentRegisterComponent implements OnInit {
  student: ParentDetails=new ParentDetails();

  constructor(private studentService:StudentService) { }

  ngOnInit(): void {
  }

  saveStudents(){
    this.studentService.registerStudent(this.student).subscribe(data=>{
       console.log(data);
    },error=>console.log(error));
  }
onSubmit(){
  this.saveStudents();
}
}
