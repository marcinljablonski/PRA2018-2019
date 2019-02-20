import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ReservationListComponent } from './reservation-list/reservation-list.component';
import { ReservationItemComponent } from './reservation-item/reservation-item.component';
import { ReservationService } from './service/reservation.service';
import { AddReservationComponent } from './add-reservation/add-reservation.component';

const ROUTES: Routes = [
  { path: '', redirectTo: 'reservation-list', pathMatch: 'full' },
  { path: 'reservation-list', component: ReservationListComponent },
  { path: 'add-reservation', component: AddReservationComponent }
];

@NgModule({
  declarations: [AppComponent, ReservationListComponent, ReservationItemComponent, AddReservationComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(ROUTES)],
  providers: [ReservationService],
  bootstrap: [AppComponent]
})
export class AppModule {}
