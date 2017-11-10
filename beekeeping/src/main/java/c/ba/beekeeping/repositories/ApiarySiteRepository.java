package c.ba.beekeeping.repositories;

import c.ba.beekeeping.domain.ApiarySite;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApiarySiteRepository extends JpaRepository<ApiarySite, Integer> {

    ApiarySite findFirstByOrderById();
}
