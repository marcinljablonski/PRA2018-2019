import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../service/reservation.service';
import { Reservation } from '../models/reservation';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  reservations: Reservation[];
    page: number;

  constructor(private reservationService: ReservationService) {}

  ngOnInit() {
      this.page = 1;
      this.getReservations();
  }

  public removeReservation(reservation: Reservation) {
    this.reservationService.removeReservation(reservation).subscribe(res => {
      this.reservations = this.reservations.filter(el => el.id !== reservation.id);
    });
  }
  private getReservations() {
    this.reservationService.getAllReservations(this.page).subscribe(res => {
      this.reservations = res.map(el => new Reservation(el));
    });
  }
}
