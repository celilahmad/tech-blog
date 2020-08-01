package app.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;

    public Email(String email) {
        this.email = email;
    }
}
