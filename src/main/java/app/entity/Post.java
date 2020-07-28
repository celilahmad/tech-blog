package app.entity;

import lombok.Data;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String header;

    private String content;

    private String image;

    private String author;

    private String date;

    private String category;
}
