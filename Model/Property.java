package Model;

import java.util.Date;


//Data container for a property
//All attributes are accessible through getters and setters
public class Property {
    private int houseid; 
    private PropertyState status;
    private String address;
    private String type;
    private int bedroomNo;
    private int bathroomNo;
    private boolean furnished;
    private String cityQuad;
    private double cost;
    private Landlord landlord;
    private Date dateListed; //switched to Date from String
    private RegRenter renter;
    private Date dateRented; //switched to Date from String

    public int getHouseid() {
        return this.houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }

    public PropertyState getStatus() {
        return this.status;
    }

    public void setStatus(PropertyState status) {
        this.status = status;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedroomNo() {
        return this.bedroomNo;
    }

    public void setBedroomNo(int bedroomNo) {
        this.bedroomNo = bedroomNo;
    }

    public int getBathroomNo() {
        return this.bathroomNo;
    }

    public void setBathroomNo(int bathroomNo) {
        this.bathroomNo = bathroomNo;
    }

    public boolean getFurnished() {
        return this.furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public String getCityQuad() {
        return this.cityQuad;
    }

    public void setCityQuad(String cityQuad) {
        this.cityQuad = cityQuad;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Landlord getLandlord() {
        return this.landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Date getDateListed() {
        return this.dateListed;
    }

    public void setDateListed(Date dateListed) {
        this.dateListed = dateListed;
    }

    public RegRenter getRenter() {
        return this.renter;
    }

    public void setRenter(RegRenter renter) {
        this.renter = renter;
    }

    public Date getDateRented() {
        return this.dateRented;
    }

    public void setDateRented(Date dateRented) {
        this.dateRented = dateRented;
    }

}