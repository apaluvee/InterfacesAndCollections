package io;

import java.io.Serializable;

public class BusinessCard implements Serializable { //implements Serializable (MARKER INTERFACE)

    private static final long serialVersionUID = 12342L; //see on unique number igale classile

    private String name;

    private String phoneNumber;

    private transient String email;

    private String website;


    public BusinessCard(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return name + "@" + website;
    }


    @Override
    public String toString() {
        return "BusinessCard{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
