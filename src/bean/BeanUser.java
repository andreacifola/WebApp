package bean;


import payment.IBAN;
import payment.IBANCredentialNotValid;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        private int scout;

        public BeanUser(String name, String surname, String city, String address, Date birthDate, String email,
                    String username, String password, String iban, int scout) throws IBANCredentialNotValid {
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

        public BeanUser(ResultSet resultSet) throws SQLException {
            this.name = resultSet.getString("name");
            this.surname = resultSet.getString("surname");
            this.city = resultSet.getString("city");
            this.address = resultSet.getString("address");
            this.birthDate = resultSet.getDate("birthdate");
            this.email = resultSet.getString("email");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
            this.scout = resultSet.getInt("scout");
            try {
                this.iban = new IBAN(resultSet.getString("iban"), this.name, this.surname);
            } catch (IBANCredentialNotValid ibanCredentialNotValid) {
                this.iban=null;
            }
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getCity() {
            return city;
        }

        public String getAddress() {
            return address;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public int getScout() { return scout; }

        public IBAN getIban() {
            return iban;
        }
    }