package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.Chamber;

import java.util.List;

public interface ChamberService {

    Chamber saveChamber(Chamber chamber);

    List<Chamber> getAllChambers();

    void deleteChamber(Integer chamberId);
}
