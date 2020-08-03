package app.service;

import app.entity.Category;
import app.repo.CategoryRepo;
import app.repo.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final PostRepo postRepo;

    public CategoryService(CategoryRepo categoryRepo, PostRepo postRepo) {
        this.categoryRepo = categoryRepo;
        this.postRepo = postRepo;
    }

    public List<Category> allCategory() {
        return categoryRepo.findAll().stream().sorted().collect(Collectors.toList());
    }

    /*public List<Long> countCategory(){
        Map<Category, Long> mapping = categoryRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));


        return mapping.values().stream().collect(Collectors.toList());
    }

    public List<Long> count(){
        return postRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(x-> x , Collectors.counting()))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Category> all(){
        categoryRepo.findAll().stream()
                .collect(Collectors.groupingBy(x -> x, count()))
    }

}*/
}
