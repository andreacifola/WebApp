package bean;

/**
 * Created by andreacifola on 21/12/16.
 */

import java.util.Date;

public class BeanUser {

    private String name;
    private String surname;
    private String city;
    private String address;
    private Date birthDate;
    private String email;
    private String username;
    private String password;
    private IBAN iban;
    private Integer scout;

    public BeanUser(String name, String surname, String city, String address, Date birthDate,
                    String email, String username, String password, String iban, Integer scout) throws IBANCredentialNotValid {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        this.username = username;
        this.password = password;
        this.iban = new IBAN(iban, name, surname);
        this.scout = scout;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IBAN getIban() {
        return iban;
    }

    public void setIban(IBAN iban) {
        this.iban = iban;
    }

    public Integer getScout() {
        return scout;
    }

    public void setScout(Integer scout) {
        this.scout = scout;
    }
}