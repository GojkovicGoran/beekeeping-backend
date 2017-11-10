package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.Chamber;
import c.ba.beekeeping.repositories.ChamberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamberServiceImpl implements ChamberService{

    private final ChamberRepository chamberRepository;

    @Autowired
    public ChamberServiceImpl(ChamberRepository chamberRepository) {

        this.chamberRepository = chamberRepository;
    }

    @Override
    public Chamber saveChamber(Chamber chamber) {

        return chamberRepository.save(chamber);
    }

    @Override
    public List<Chamber> getAllChambers() {
        return null;
    }

    @Override
    public void deleteChamber(Integer chamberId) {

    }
}
