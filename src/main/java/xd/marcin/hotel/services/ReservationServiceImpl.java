package xd.marcin.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xd.marcin.hotel.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

//    @Override
//    public Iterable<Seller> listAllSellers() {
//        return sellerRepository.findAll();
//    }
//
//    @Override
//    public Seller getSellerById(Integer id) {
//        return sellerRepository.findOne(id);
//    }
//
//    @Override
//    public Seller saveSeller(Seller seller) {
//        return sellerRepository.save(seller);
//    }
//
//    @Override
//    public void deleteSeller(Integer id) {
//        sellerRepository.delete(id);
//    }
//
//    @Override
//    public List<> getByPESEL(String pesel) {
//       reservationRepository.fin
//        return reservationRepository.findByName(name);
//    }

}
