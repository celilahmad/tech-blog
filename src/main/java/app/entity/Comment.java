package app.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String comment;

    private String date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
