package c.ba.beekeeping.services;

import c.ba.beekeeping.domain.Frame;

import java.util.List;

public interface FrameService {

    Frame saveFrame(Frame frame);

    List<Frame> getAllFrames();

    void deleteFrame(Integer frameId);
}
