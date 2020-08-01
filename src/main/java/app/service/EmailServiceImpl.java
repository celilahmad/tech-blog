package app.service;

import app.entity.Email;
import app.repo.EmailRepo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailServiceImpl {

    private final JavaMailSender emailSender;
    private final EmailRepo emailRepo;

    public EmailServiceImpl(JavaMailSender emailSender, EmailRepo emailRepo) {
        this.emailSender = emailSender;
        this.emailRepo = emailRepo;
    }



    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tech.blog.smtp@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailRepo.save(new Email(to));
        emailSender.send(message);
    }

    public boolean isBeforeSubscribed(String email) {
        return emailRepo.findByEmail(email);
    }
}

