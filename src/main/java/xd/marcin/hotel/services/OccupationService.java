package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Occupation;

public interface OccupationService {

    Iterable<Occupation> listAllOccupations();

    Occupation getOccupationById(Integer id);

    Occupation saveOccupation(Occupation occupation);

    void deleteOccupation(Integer id);

}
