package hu.suaf.demo.service;


import hu.suaf.demo.model.Contact;
import hu.suaf.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void addContact(Contact c) {
        contactRepository.addContact(c);
    }

    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }
}
