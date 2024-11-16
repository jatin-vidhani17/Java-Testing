package FlatPack;

public class Flat {
    private String apartmentName;
    private String flatNo;
    private int noOfBedrooms;

    // Constructor to initialize Flat
    public Flat(String apartmentName, String flatNo, int noOfBedrooms) {
        this.apartmentName = apartmentName;
        this.flatNo = flatNo;
        this.noOfBedrooms = noOfBedrooms;
    }

    // Getter and setter for apartmentName
    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    // Getter and setter for flatNo
    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    // Getter and setter for noOfBedrooms
    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    // Method to display flat information
    public void dispFlatInfo() {
        System.out.println("Apartment Name : " + apartmentName);
        System.out.println("Flat Number : " + flatNo);
        System.out.println("Number of Bedrooms : " + noOfBedrooms);
    }
}