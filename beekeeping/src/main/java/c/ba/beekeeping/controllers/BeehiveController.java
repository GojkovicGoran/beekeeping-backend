package c.ba.beekeeping.controllers;

import c.ba.beekeeping.domain.Beehive;
import c.ba.beekeeping.services.BeehiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class BeehiveController {

 private final BeehiveService beehiveService;

 @Autowired
    public BeehiveController(BeehiveService beehiveService) {
     this.beehiveService = beehiveService;
 }

    @RequestMapping(value = "/beehive", method = RequestMethod.POST)
    public void saveBeehive(@RequestBody Beehive beehive) {
     beehiveService.saveBeehive(beehive);
    }

}
