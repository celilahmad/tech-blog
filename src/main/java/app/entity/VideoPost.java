package app.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="video")
public class VideoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length = 10000)
    private String content;

    private String date;

    private String author;

    private String link;
}
