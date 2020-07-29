package app.service;

import app.entity.Post;
import app.entity.VideoPost;
import app.repo.VideoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private final VideoRepo videoRepo;

    public VideoService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public List<VideoPost> allVideoPosts(){
        return videoRepo.findAll();
    }

    public List<VideoPost> frontPosts(){
        return videoRepo
                .findAll()
                .stream()
                .limit(4)
                .collect(Collectors.toList());
    }

    public VideoPost getVideo(int id){
        return videoRepo.findById(id).get();
    }
}
