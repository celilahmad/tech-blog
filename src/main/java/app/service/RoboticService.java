package app.service;

import app.repo.PostRepo;
import org.springframework.stereotype.Service;

@Service
public class RoboticService {

    private final PostRepo postRepo;

    public RoboticService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }


}
