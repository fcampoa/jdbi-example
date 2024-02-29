package org.model;

public class Person {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String dni;

    public Person() {
    }

    public Person(int id, String name, String lastname, String email, String dni) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.dni = dni;
    }

    public Person(String name, String lastname, String email, String dni) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
