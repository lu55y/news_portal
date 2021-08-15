package by.it.academy.beans;

import java.util.Objects;

public class RegistrationInfo extends Entity {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String dateOfRegistration;

    public RegistrationInfo(int id, String name, String surname, String email, String password, String dateOfRegistration) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationInfo that = (RegistrationInfo) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(dateOfRegistration, that.dateOfRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, dateOfRegistration);
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                '}';
    }
}
