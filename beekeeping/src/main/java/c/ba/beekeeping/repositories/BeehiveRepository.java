package c.ba.beekeeping.repositories;

import c.ba.beekeeping.domain.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BeehiveRepository extends JpaRepository<Beehive, Integer> {
    Beehive findOneById(Integer id);
}
