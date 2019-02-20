import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Reservation } from '../models/reservation';
import { ReservationService } from '../service/reservation.service';

@Component({
  selector: 'app-reservation-item',
  templateUrl: './reservation-item.component.html',
  styleUrls: ['./reservation-item.component.css']
})
export class ReservationItemComponent implements OnInit {
  @Input() reservation: Reservation;
  @Output() removeItem: EventEmitter<Reservation> = new EventEmitter();
  constructor(private reservationService: ReservationService) {}

  ngOnInit() {}

  remove() {
    this.removeItem.emit(this.reservation);
  }
}
