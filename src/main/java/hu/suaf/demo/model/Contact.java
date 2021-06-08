package hu.suaf.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Contact {

    private UUID id;
    private String name;
    private String phone;
    private String email;
    private Date birthDate;
    private String address;

    private Date createdAt;
}

