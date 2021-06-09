package hu.suaf.demo.repository;

import hu.suaf.demo.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
