package c.ba.beekeeping.repositories;

import c.ba.beekeeping.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
