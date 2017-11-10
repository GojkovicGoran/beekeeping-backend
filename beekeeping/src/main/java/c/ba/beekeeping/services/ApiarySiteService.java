package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.ApiarySite;
import c.ba.beekeeping.repositories.ApiarySiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiarySiteService {

   private final ApiarySiteRepository apiarySiteRepository;

   @Autowired
   public ApiarySiteService(ApiarySiteRepository apiarySiteRepository) {
      this.apiarySiteRepository = apiarySiteRepository;
   }

   public ApiarySite saveApiarySite(ApiarySite apiarySite) {
      return apiarySiteRepository.save(apiarySite);
   }

   public ApiarySite findById(Integer apiaryId) {
      return apiarySiteRepository.findOne(apiaryId);
   }

   public ApiarySite getApiarySite() {
      return apiarySiteRepository.findFirstByOrderById();
   }
}
