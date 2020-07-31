package app.service;

import app.entity.Post;
import app.entity.VideoPost;
import app.repo.VideoRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<VideoPost> listAll(int pageNumber){
        return videoRepo.findAll(PageRequest.of(pageNumber - 1, 3));
    }

}
