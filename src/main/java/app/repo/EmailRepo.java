package app.repo;

import app.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepo extends JpaRepository<Email, Integer> {

    Email findByEmail(String email);

}
