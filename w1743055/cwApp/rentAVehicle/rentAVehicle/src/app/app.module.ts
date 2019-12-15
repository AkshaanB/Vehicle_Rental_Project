import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { AllVehiclesComponent } from './all-vehicles/all-vehicles.component';
import {Router, RouterModule,Routes} from "@angular/router";
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule} from "@angular/forms";
import { LoginComponent } from './login/login.component';
import { LoginSignUpHomeComponent } from './login-sign-up-home/login-sign-up-home.component';
import { SearchComponent } from './login-sign-up-home/search/search.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ViewAllVehiclesComponent } from './login-sign-up-home/view-all-vehicles/view-all-vehicles.component';
import {HttpClientModule} from "@angular/common/http";

import { MainServiceService } from './mainService/main-service.service';
import { VehicleServiceService } from './servicesForModels/Vehicle/vehicle-service.service';
import { CarServiceService } from './servicesForModels/Car/car-service.service';
import { MotorbikeServiceService } from './servicesForModels/Motorbike/motorbike-service.service';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { MainBookingComponent } from './main-booking/main-booking.component';
import { ShowVehiclesComponent } from './show-vehicles/show-vehicles.component';
import {MatTableModule} from "@angular/material/table";
import { CarComponentComponent } from './show-vehicles/car-component/car-component.component';
import { MotorbikeComponentComponent } from './show-vehicles/motorbike-component/motorbike-component.component';
import {VehicleSelectionComponent} from "./vehicle-selection/vehicle-selection.component";
import {MatDialogModule,MatFormFieldModule,MatInputModule} from "@angular/material";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { from } from 'rxjs';
import {CarService} from "src/app/mainService/Car/car.service";
import { MotorbikeService } from './mainService/Motorbike/motorbike.service';
import { MakeFilterCarPipe } from './make-filter-car.pipe';
import { MakeFilterMotorbikePipe } from './make-filter-motorbike.pipe';
import { CapcityFilterPipe } from './vehicle-selection/capcity-filter.pipe';
import { PlateNumberFilterPipe } from './search-results/plateNumberFilter/plate-number-filter.pipe';
import { PlateNumberCarFilterPipe } from './search-results/plateNumberFilter/carplateNumberFilter/plate-number-car-filter.pipe';
import { PlateNumberMotorbikeFilterPipe } from './search-results/plateNumberFilter/motorbikeplateNumberFilter/plate-number-motorbike-filter.pipe';
const appRoutes:Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"search",
    component: SearchResultsComponent
  },
  {
    path:"viewAllVehicles",
    component: AllVehiclesComponent
  },
  {
    path:"login",
    component: LoginComponent
  },
  {
    path:"signUp",
    component: SignUpComponent
  },
  {
    path:"loginSignUp-home",
    component:LoginSignUpHomeComponent
  },
  {
    path:"loginSignUp-home/search",
    component:SearchComponent
  },
  {
    path:"loginSignUp-home/viewVehicles",
    component:ViewAllVehiclesComponent
  },
  {
    path:"thankyou",
    component:ThankyouComponent
  },
  {
    path:"booking",
    component:MainBookingComponent
  },
  {
    path:"car",
    component:CarComponentComponent,
    data:{title:"Cars"}
  },
  {
    path:"motorbike",
    component:MotorbikeComponentComponent
  },
  {
    path:"booking/:plateNumber",
    component:MainBookingComponent
  },
  {
    path:"**",
    component: NotFoundComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchResultsComponent,
    AllVehiclesComponent,
    NotFoundComponent,
    LoginComponent,
    LoginSignUpHomeComponent,
    SearchComponent,
    SignUpComponent,
    ViewAllVehiclesComponent,
    ThankyouComponent,
    MainBookingComponent,
    ShowVehiclesComponent,
    CarComponentComponent,
    MotorbikeComponentComponent,
    VehicleSelectionComponent,
    MakeFilterCarPipe,
    MakeFilterMotorbikePipe,
    MainBookingComponent,
    CapcityFilterPipe,
    PlateNumberFilterPipe,
    PlateNumberCarFilterPipe,
    PlateNumberMotorbikeFilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes,{
      enableTracing:true
    }),
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  providers: [MainServiceService,VehicleServiceService,CarService,MotorbikeService],
  bootstrap: [AppComponent],
  entryComponents:[VehicleSelectionComponent,CarComponentComponent,MotorbikeComponentComponent]
})
export class AppModule { }
