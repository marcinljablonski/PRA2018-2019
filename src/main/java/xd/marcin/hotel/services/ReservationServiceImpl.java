package xd.marcin.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xd.marcin.hotel.entities.Reservation;
import xd.marcin.hotel.repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Iterable<Reservation> listAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationRepository.delete(id);
    }

    @Override
    public List<Reservation> getByLastName(String lastName) {
        return reservationRepository.findsByLastName(lastName);
    }

}
