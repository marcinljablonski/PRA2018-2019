import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../service/reservation.service';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {
    id: number;
    beds: number;
    comments: string;
    client: any[];
    fromDate: string;
    toDate: string;

  constructor(private reservationService: ReservationService) {}

  ngOnInit() {
      this.id = null;
      this.beds = null;
      this.comments = null;
      this.client = null;
      this.fromDate = null;
      this.toDate = null;
  }

  createNewReservation() {
      if (this.id !== null && this.beds !== null && this.comments !== null &&
          this.client !== null && this.fromDate !== null && this.toDate !== null) {
          this.reservationService.createNewReservation(this.id, this.beds, this.comments,
                                                       this.client, this.fromDate, this.toDate);
    } else {
      window.alert('upssss');
    }
  }
}
