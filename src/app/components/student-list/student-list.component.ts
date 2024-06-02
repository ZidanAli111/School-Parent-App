import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ParentDetails } from 'src/app/model/parent-details';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students!: ParentDetails[];
  isAdmin: boolean = false;
  isApproved: boolean = false;
  buttonText:string="REVIEW";

  approvalStatus: { [key: number]: boolean } = {};

  constructor(
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.isAdmin = params['admin'] === 'true';
      this.getStudents();
    });
  }

  private getStudents(): void {
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
      console.log(this.students);
    });
  }

  updateStudent(parentId: number): void {
     if (this.isAdmin) {
        this.approvalStatus[parentId] = true;
        console.log("Admin Update Logic: ", parentId);
    } else {
        this.router.navigate(['update-student', parentId]);
    }
  }

  

  navigateToAddCircular() {
    if (this.isAdmin) {
      this.router.navigate(['create-circular']);
    }
  }

  navigateToCircular() {
    if (this.isAdmin) {
      this.router.navigate(['circular']);
    }
  }
}
