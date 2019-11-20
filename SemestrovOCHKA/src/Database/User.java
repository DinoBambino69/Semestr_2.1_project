package Database;

import java.sql.Timestamp;

public class User {
    private int id;
    private String name, surname, country, email, password, photo;
    private Timestamp date_birth;

    public User(int id, String name, String surname, String country, String email, String password, String photo, Timestamp date_birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.date_birth = date_birth;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public Timestamp getDate_birth() {
        return date_birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", date_birth=" + date_birth +
                '}';
    }
}