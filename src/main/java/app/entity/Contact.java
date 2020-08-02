package app.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String email;

    private String subject;

    @Column(length = 1000)
    private String content;

    public Contact(String fullName, String email, String subject, String content) {
        this.fullName = fullName;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }
}
