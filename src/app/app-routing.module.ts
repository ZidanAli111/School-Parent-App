import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './components/student-list/student-list.component';
import { StudentRegisterComponent } from './components/student-register/student-register.component';
import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { HomeComponent } from './components/home/home.component';
import { CircularsComponent } from './components/circulars/circulars.component';
import { CreateCircularComponent } from './components/create-circular/create-circular.component';

const routes: Routes = [
  {path:'',redirectTo:'students',pathMatch:'full'},
  {path:'students',component:StudentListComponent},
  {path:'student-register',component:StudentRegisterComponent},
  {path:'update-student/:parentId',component: UpdateStudentComponent},
  {path:'home',component:HomeComponent},
  {path:'circular',component:CircularsComponent},
  {path:'create-circular',component:CreateCircularComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
