public class customer {
    private String customerID;
    private String name;
    private String phoneNo;

    public customer(String customerID, String name, String phoneNo) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String toString() {
        return "Customer ID : " + customerID +
               "\nName        : " + name +
               "\nPhone No    : " + phoneNo;
    }
}