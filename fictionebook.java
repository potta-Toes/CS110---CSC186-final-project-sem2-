public class fictionebook extends orderebook {
    private String genre;
    private String author;

    public fictionebook(String orderID, customer customerInfo,
                        String title, double price, int quantity,
                        String genre, String author) {
        super(orderID, customerInfo, title, price, quantity);
        this.genre = genre;
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double calculateTotalPrice() {
        return super.calculateTotalPrice();
    }

    public String toString() {
        return "Type        : Fiction Ebook\n" +
               super.toString() +
               "\nGenre       : " + genre +
               "\nAuthor      : " + author;
    }
}