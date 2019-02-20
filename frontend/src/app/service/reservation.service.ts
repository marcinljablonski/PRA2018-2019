import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const apiUrl: String = 'https://localhost:8443/api';

@Injectable()
export class ReservationService {
  constructor(private http: HttpClient) {}

    getAllReservations(page: number): Observable<any> {
    return this.http.get(`${apiUrl}/reservation/page`);
  }

    createNewReservation(id: number, beds: number, commnets: string, client: any[], fromData: string, toDate: string) {
        const data = {
            id: id,
            beds: beds,
            comments: commnets,
            client: client,
            fromDate: fromData,
            toDate: toDate
    };
    const reservation = new Reservation(data);
    return this.http.post(`${apiUrl}/reservation`, reservation).subscribe(res => {
      console.log(res);
    });
  }
  removeReservation(reservation: Reservation) {
    return this.http.delete(`${apiUrl}/reservation/${reservation.id}`);
  }

  updateTodo(reservation: Reservation) {
    return this.http.put(`${apiUrl}/reservation/${reservation.id}`, reservation);
  }
}
