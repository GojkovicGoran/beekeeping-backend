package c.ba.beekeeping.controllers;

import c.ba.beekeeping.domain.ApiarySite;
import c.ba.beekeeping.services.ApiarySiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiarySiteController {

    private final ApiarySiteService apiarySiteService;

    @Autowired
    public ApiarySiteController(ApiarySiteService apiarySiteService) {
        this.apiarySiteService = apiarySiteService;
    }

    @RequestMapping(value = "/apiary", method = RequestMethod.POST)
    public void saveApiarySite(@RequestBody ApiarySite apiarySite) {
       apiarySiteService.saveApiarySite(apiarySite);
    }

}
