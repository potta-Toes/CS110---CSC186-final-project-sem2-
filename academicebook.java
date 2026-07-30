public class academicebook extends orderebook {
    private String subject;
    private String level;

    public academicebook(String orderID, customer customerInfo,
                         String title, double price, int quantity,
                         String subject, String level) {
        super(orderID, customerInfo, title, price, quantity);
        this.subject = subject;
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public String getLevel() {
        return level;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double calculateTotalPrice() {
        return super.calculateTotalPrice() * 0.90;
    }

    public String toString() {
        return "Type        : Academic Ebook\n" +
               super.toString() +
               "\nSubject     : " + subject +
               "\nLevel       : " + level +
               "\nDiscount    : 10%";
    }
}