package com.example.adminassist;

public class User {
    public String id, email, name, sec_name, phone, location, office;
    public Boolean admin_permissions;

    public User() {
    }

    public User(String id, String email, String name, String sec_name, String phone, String location, String office) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.sec_name = sec_name;
        this.phone = phone;
        this.location = location;
        this.office = office;
        this.admin_permissions = false;
    }
}
