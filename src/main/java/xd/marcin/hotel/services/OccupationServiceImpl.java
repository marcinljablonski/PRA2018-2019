package xd.marcin.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xd.marcin.hotel.entities.Occupation;
import xd.marcin.hotel.repositories.OccupationRepository;

@Service
public class OccupationServiceImpl implements OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    @Override
    public Iterable<Occupation> listAllOccupations() {
        return occupationRepository.findAll();
    }

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
