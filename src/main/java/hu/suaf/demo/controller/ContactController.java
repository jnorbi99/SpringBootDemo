package hu.suaf.demo.controller;

import hu.suaf.demo.model.Contact;
import hu.suaf.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/create")
    public String createContactForm(Contact contact) {
        return "contact-create";
    }

    @GetMapping
    public String lisContacts(Model model) {
        model.addAttribute("contacts", contactService.getContacts());
        return "contact-list";
    }

    @PostMapping("/create")
    public String createContact(Contact contact) {

        contactService.addContact(contact);
        return "redirect:/contact";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
