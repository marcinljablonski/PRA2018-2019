package xd.marcin.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xd.marcin.hotel.entities.Occupation;
import xd.marcin.hotel.entities.Room;
import xd.marcin.hotel.repositories.OccupationRepository;
import xd.marcin.hotel.repositories.RoomRepository;

@Service
public class OccupationServiceImpl implements OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    @Override
    public Occupation getOccupationById(Integer id) {
        return occupationRepository.findOne(id);
    }

    @Override
    public Occupation saveOccupation(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    @Override
    public void deleteOccupation(Integer id) {
        occupationRepository.delete(id);
    }

}
