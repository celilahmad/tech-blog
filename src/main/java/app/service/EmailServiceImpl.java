package app.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailServiceImpl {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }



    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tech.blog.smtp@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        /*emailRepo.save(new Email(to));*/
        emailSender.send(message);
    }

    public void sendEmailToMe(String to,String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        /*emailRepo.save(new Email(to));*/
        emailSender.send(message);
    }

    /*public boolean isAlreadySubscribed(String email) {
        Email em = emailRepo.findByEmail(email);
        return em != null && email.equals(em.getEmail());
    }*/
}

