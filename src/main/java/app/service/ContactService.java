package app.service;

import app.entity.Contact;
import app.repo.ContactRepo;
import app.repo.PostRepo;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepo contactRepo;

    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void saveContact(Contact contact){
        contactRepo.save(contact);
    }


}
