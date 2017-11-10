package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.Frame;
import c.ba.beekeeping.repositories.FrameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FrameServiceImpl implements FrameService {

    private final FrameRepository frameRepository;

    @Autowired
    public FrameServiceImpl(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Override
    @Transactional
    public Frame saveFrame(Frame frame) {
        return frameRepository.save(frame);
    }

    @Override
    @Transactional
    public void deleteFrame(Integer frameId) {
        frameRepository.delete(frameId);
    }

    @Override
    @Transactional
    public List<Frame> getAllFrames() {
        return frameRepository.findAll();
    }

}
