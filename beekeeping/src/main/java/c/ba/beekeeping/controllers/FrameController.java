package c.ba.beekeeping.controllers;

import c.ba.beekeeping.domain.Frame;
import c.ba.beekeeping.services.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FrameController {

	private final FrameService frameService;

	@Autowired
	public FrameController(FrameService frameService) {
		this.frameService = frameService;
	}

	@PostMapping(value = "/frames")
    public Frame saveFrame(@RequestBody Frame frame) {
	    return frameService.saveFrame(frame);
    }

    @GetMapping(value = "/frames")
    public List<Frame> getAllFrames() {
	    return frameService.getAllFrames();
    }

    @DeleteMapping(value = "/frame/{id}")
    public void deleteFrame(@PathVariable Integer id) throws Exception {
	    frameService.deleteFrame(id);
    }
}
