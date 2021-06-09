package hu.suaf.demo.controller;

import hu.suaf.demo.model.Contact;
import hu.suaf.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/create")
    public String createContactForm() {
        return "contact-create";
    }

    @GetMapping
    public String lisContacts() {
        return "contact-list";
    }

    @PostMapping("/create")
    public String createContact(Contact c) {

        contactService.addContact(c);
        return "redirect:/contact";
    }
}
