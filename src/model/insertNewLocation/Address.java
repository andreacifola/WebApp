package model.insertNewLocation;

/**
 * Created by tizianoditoma on 05/09/16.
 */
public class Address {
    private String CAP;
    private String city;
    private String houseNum;
    private String region;
    private String address;

    public Address(String region, String city, String address, String houseNum, String CAP) {

        this.region = region;
        this.city = city;
        this.address = address;
        this.houseNum = houseNum;
        this.CAP = CAP;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address + " " + houseNum + ", " + CAP + ", " + city + ", " + region;
    }
}
