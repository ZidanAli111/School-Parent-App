import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './components/student-list/student-list.component';
import { StudentRegisterComponent } from './components/student-register/student-register.component';
import { FormsModule } from '@angular/forms';

import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { HomeComponent } from './components/home/home.component';
import { CircularsComponent } from './components/circulars/circulars.component';
import { CreateCircularComponent } from './components/create-circular/create-circular.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentRegisterComponent,
    UpdateStudentComponent,
    HomeComponent,
    CircularsComponent,
    CreateCircularComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
