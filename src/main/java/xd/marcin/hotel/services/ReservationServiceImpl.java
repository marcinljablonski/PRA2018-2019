package xd.marcin.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import xd.marcin.hotel.entities.Reservation;
import xd.marcin.hotel.repositories.AddressRepository;
import xd.marcin.hotel.repositories.ClientRepository;
import xd.marcin.hotel.repositories.ReservationRepository;
import xd.marcin.hotel.repositories.RoomRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AddressRepository addressRepository;

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
    public void saveManyReservations(Iterable<Reservation> reservations) {
//        for (Reservation r : reservations) {
//            addressRepository.save((r.getClient()).getAddress());
//            clientRepository.save(r.getClient());
//        }
        reservationRepository.save(reservations);
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationRepository.delete(id);
    }

    @Override
    public List<Reservation> getByLastName(String lastName) {
        return reservationRepository.findsByLastName(lastName);
    }

    @Override
    public Iterable<Reservation> listAllReservationsPaging(Integer pageNr, Integer howManyOnPage) {
        return reservationRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (reservationRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
