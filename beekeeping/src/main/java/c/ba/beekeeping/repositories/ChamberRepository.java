package c.ba.beekeeping.repositories;

import c.ba.beekeeping.domain.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamberRepository extends JpaRepository<Chamber, Integer> {

}