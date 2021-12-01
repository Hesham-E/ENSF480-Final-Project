package Model;

public class Property {
    private int houseid; //should this be an iterating static number?
    private PropertyState status;
    private String address;
    private String type;
    private int bedroomNo;
    private int bathroomNo;
    private String furnished;
    private String cityQuad;
    private double cost;
    private Landlord landlord;
    private String dateListed;
    private RegRenter renter;
    private String dateRented;

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

    public String getFurnished() {
        return this.furnished;
    }

    public void setFurnished(String furnished) {
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

    public String getDateListed() {
        return this.dateListed;
    }

    public void setDateListed(String dateListed) {
        this.dateListed = dateListed;
    }

    public Renter getRenter() {
        return this.renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public String getDateRented() {
        return this.dateRented;
    }

    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }

}