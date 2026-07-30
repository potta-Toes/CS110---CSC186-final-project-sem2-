public abstract class orderebook {
    private String orderID;
    private customer customerInfo;
    private String title;
    private double price;
    private int quantity;

    public orderebook(String orderID, customer customerInfo,
                      String title, double price, int quantity) {
        this.orderID = orderID;
        this.customerInfo = customerInfo;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public customer getCustomerInfo() {
        return customerInfo;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCustomerInfo(customer customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

    public String toString() {
        return "Order ID    : " + orderID +
               "\n" + customerInfo.toString() +
               "\nEbook Title : " + title +
               "\nPrice       : RM" + price +
               "\nQuantity    : " + quantity +
               "\nTotal Price : RM" + String.format("%.2f", calculateTotalPrice());
    }
}