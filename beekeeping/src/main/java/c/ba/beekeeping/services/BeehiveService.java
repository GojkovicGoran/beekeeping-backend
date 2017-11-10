package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.Beehive;
import c.ba.beekeeping.repositories.BeehiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeehiveService {

    private final BeehiveRepository beehiveRepository;

    @Autowired
    public BeehiveService(BeehiveRepository beehiveRepository) {
        this.beehiveRepository = beehiveRepository;
    }

    public Beehive saveBeehive(Beehive beehive) { return beehiveRepository.save(beehive); }

    public Beehive findById(Integer beehiveId) {
        return beehiveRepository.findOneById(beehiveId);
    }

    public List<Beehive> getAllBeehives() {
        return beehiveRepository.findAll();
    }
}
