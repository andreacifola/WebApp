package model;

import model.payment.IBAN;
import model.payment.IBANCredentialNotValid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class User {

    private String name;
    private String surname;
    private String city;
    private String address;
    private Date birthDate;
    private String email;
    private String username;
    private String password;
    private IBAN iban;
    private Boolean scout;

    public User() {
    }

    public User(String name, String surname, String city, String address, Date birthDate, String email,
                String username, String password, String iban, Boolean scout) throws IBANCredentialNotValid {
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

    public User(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString("name");
        this.surname = resultSet.getString("surname");
        this.city = resultSet.getString("city");
        this.address = resultSet.getString("address");
        this.birthDate = resultSet.getDate("birthdate");
        this.email = resultSet.getString("email");
        this.username = resultSet.getString("username");
        this.password = resultSet.getString("password");
        try {
            this.iban = new IBAN(resultSet.getString("iban"), this.name, this.surname);
        } catch (IBANCredentialNotValid ibanCredentialNotValid) {
            this.iban=null;
        }
        this.scout = resultSet.getBoolean("scout");
    }

    /**
     * @return the name of the logged user
     */
    public String getName() {
        return name;
    }

    /**
     * @return the surname of the logged user
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the city of the logged user
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the address of the logged user
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the birthdate of the logged user
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return the email of the logged user
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the username of the logged user
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password of the logged user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the IBAN of the logged user
     */
    public IBAN getIban() {
        return iban;
    }

    /**
     * @return if the user is a scout
     */
    public Boolean getScout() {
        return scout;
    }
}
