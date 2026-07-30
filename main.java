import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        orderebook[] orderList = new orderebook[50];
        int count = 0;

        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);

            String indata;

            while ((indata = br.readLine()) != null && count < orderList.length) {
                StringTokenizer st = new StringTokenizer(indata, "|");

                String type = st.nextToken();
                String orderID = st.nextToken();
                String customerID = st.nextToken();
                String name = st.nextToken();
                String phoneNo = st.nextToken();
                String title = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                  String extra1 = st.nextToken();
                String extra2 = st.nextToken();

                customer c = new customer(customerID, name, phoneNo);

                if (type.equalsIgnoreCase("ACADEMIC")) {
                    orderList[count] = new academicebook(orderID, c, title, price, quantity, extra1, extra2);
                    count++;
                } else if (type.equalsIgnoreCase("FICTION")) {
                    orderList[count] = new fictionebook(orderID, c, title, price, quantity, extra1, extra2);
                    count++;
                }
            }

            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Input file not found.");
        } catch (Exception e) {
            System.out.println("Error reading input file.");
        }

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("           EBOOK ORDER SYSTEM");
         
            System.out.println("========================================");
            System.out.println("1. Add New Ebook Order");
            System.out.println("2. Display All Ebook Orders");
            System.out.println("3. Update Ebook Order Information");
            System.out.println("4. Calculate Total Price by Order ID");
            System.out.println("5. Generate Sales Summary Report");
            System.out.println("6. Save Output File");
            System.out.println("7. Exit");
            System.out.println("========================================");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (count < orderList.length) {
                    System.out.println("\n===== ADD NEW EBOOK ORDER =====");

                    System.out.print("Enter ebook type (ACADEMIC/FICTION): ");
                    String type = input.nextLine();

                    System.out.print("Enter order ID              : ");
                    String orderID = input.nextLine();

                    System.out.print("Enter customer ID           : ");
                    String customerID = input.nextLine();

                    System.out.print("Enter customer name         : ");
                    String name = input.nextLine();

                    System.out.print("Enter customer phone number : ");
                    String phoneNo = input.nextLine();

                    System.out.print("Enter ebook title           : ");
                    String title = input.nextLine();

                    System.out.print("Enter ebook price           : RM");
                    double price = input.nextDouble();

                    System.out.print("Enter quantity              : ");
                    int quantity = input.nextInt();
                    input.nextLine();

                    customer c = new customer(customerID, name, phoneNo);

                    if (type.equalsIgnoreCase("ACADEMIC")) {
                        System.out.print("Enter subject               : ");
                        String subject = input.nextLine();

                        System.out.print("Enter level                 : ");
                        String level = input.nextLine();

                        orderList[count] = new academicebook(orderID, c, title, price, quantity, subject, level);
                        count++;

                        System.out.println("Academic ebook order added successfully.");
                    } else if (type.equalsIgnoreCase("FICTION")) {
                        System.out.print("Enter genre                 : ");
                        String genre = input.nextLine();

                        System.out.print("Enter author                : ");
                        String author = input.nextLine();

                        orderList[count] = new fictionebook(orderID, c, title, price, quantity, genre, author);
                        count++;

                        System.out.println("Fiction ebook order added successfully.");
                    } else {
                        System.out.println("Invalid ebook type.");
                    }
                } else {
                    System.out.println("Order list is full.");
                }
            }

            else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No ebook order found.");
                } else {
                    System.out.println("\n========================================");
                    System.out.println("          LIST OF EBOOK ORDERS");
                    System.out.println("========================================");

                    for (int i = 0; i < count; i++) {
                        System.out.println("\n----------------------------------------");
                        System.out.println("Order Number: " + (i + 1));
                        System.out.println("----------------------------------------");
                        System.out.println(orderList[i].toString());
                    }
                }
            }

            else if (choice == 3) {
                            System.out.print("Enter order ID to update: ");
                            String orderID = input.nextLine();
            
                            boolean found = false;
            
                            for (int i = 0; i < count; i++) {
                                if (orderList[i].getOrderID().equalsIgnoreCase(orderID)) {
                                    found = true;
                                    int updateChoice;
                                    
                                    do {
                                        System.out.println("\n========================================");
                                        System.out.println("       CURRENT ORDER INFORMATION");
                                        System.out.println("========================================");
                                        System.out.println(orderList[i].toString());
                                        System.out.println("----------------------------------------");
                                        System.out.println("What would you like to update?");
                                        System.out.println("1. Customer ID");
                                        System.out.println("2. Customer Name");
                                        System.out.println("3. Phone Number");
                                        System.out.println("4. Ebook Title");
                                        System.out.println("5. Price");
                                        System.out.println("6. Quantity");
                                        
                                        if (orderList[i] instanceof academicebook) {
                                            System.out.println("7. Subject");
                                            System.out.println("8. Level");
                                        } else if (orderList[i] instanceof fictionebook) {
                                            System.out.println("7. Genre");
                                            System.out.println("8. Author");
                                        }
                                        System.out.println("9. Finish Updating / Return to Main Menu");
                                        System.out.println("----------------------------------------");
                                        System.out.print("Enter choice (1-9): ");
                                        
                                        updateChoice = input.nextInt();
                                        input.nextLine();
            
                                        if (updateChoice == 1) {
                                            System.out.print("Enter new customer ID: ");
                                            String newCustomerID = input.nextLine();
                                            orderList[i].getCustomerInfo().setCustomerID(newCustomerID);
                                            System.out.println("Customer ID updated successfully.");
                                        } 
                                        else if (updateChoice == 2) {
                                            System.out.print("Enter new customer name: ");
                                            String newName = input.nextLine();
                                            orderList[i].getCustomerInfo().setName(newName);
                                            System.out.println("Customer Name updated successfully.");
                                        } 
                                        else if (updateChoice == 3) {
                                            System.out.print("Enter new phone number: ");
                                            String newPhone = input.nextLine();
                                            orderList[i].getCustomerInfo().setPhoneNo(newPhone);
                                            System.out.println("Phone Number updated successfully.");
                                        } 
                                        else if (updateChoice == 4) {
                                            System.out.print("Enter new ebook title: ");
                                            String newTitle = input.nextLine();
                                            orderList[i].setTitle(newTitle);
                                            System.out.println("Ebook Title updated successfully.");
                                        } 
                                        else if (updateChoice == 5) {
                                            System.out.print("Enter new price: RM");
                                            double newPrice = input.nextDouble();
                                            input.nextLine();
                                            orderList[i].setPrice(newPrice);
                                            System.out.println("Price updated successfully.");
                                        } 
                                        else if (updateChoice == 6) {
                                            System.out.print("Enter new quantity: ");
                                            int newQuantity = input.nextInt();
                                            input.nextLine();
                                            orderList[i].setQuantity(newQuantity);
                                            System.out.println("Quantity updated successfully.");
                                        } 
                                        else if (updateChoice == 7) {
                                            if (orderList[i] instanceof academicebook) {
                                                System.out.print("Enter new subject: ");
                                                String newSubject = input.nextLine();
                                                ((academicebook) orderList[i]).setSubject(newSubject);
                                                System.out.println("Subject updated successfully.");
                                            } else if (orderList[i] instanceof fictionebook) {
                                                System.out.print("Enter new genre: ");
                                                String newGenre = input.nextLine();
                                                ((fictionebook) orderList[i]).setGenre(newGenre);
                                                System.out.println("Genre updated successfully.");
                                            }
                                        } 
                                        else if (updateChoice == 8) {
                                            if (orderList[i] instanceof academicebook) {
                                                System.out.print("Enter new level: ");
                                                String newLevel = input.nextLine();
                                                ((academicebook) orderList[i]).setLevel(newLevel);
                                                System.out.println("Level updated successfully.");
                                            } else if (orderList[i] instanceof fictionebook) {
                                                System.out.print("Enter new author: ");
                                                String newAuthor = input.nextLine();
                                                ((fictionebook) orderList[i]).setAuthor(newAuthor);
                                                System.out.println("Author updated successfully.");
                                            }
                                        } 
                                        else if (updateChoice == 9) {
                                            System.out.println("Finished updating order " + orderID + ".");
                                        } 
                                        else {
                                            System.out.println("Invalid choice. Please enter 1 to 9.");
                                        }
            
                                    } while (updateChoice != 9);
            
                                    break;
                                }
                            }
            
                            if (found == false) {
                                System.out.println("Order ID not found.");
                            }
                        }
            else if (choice == 4) {
                System.out.print("Enter order ID: ");
                String orderID = input.nextLine();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (orderList[i].getOrderID().equalsIgnoreCase(orderID)) {
                        System.out.println("\n===== ORDER PRICE DETAILS =====");
                        System.out.println("Order ID    : " + orderList[i].getOrderID());
                        System.out.println("Ebook Title : " + orderList[i].getTitle());
                        System.out.println("Total Price : RM" + String.format("%.2f", orderList[i].calculateTotalPrice()));
                        found = true;
                    }
                }

                if (found == false) {
                    System.out.println("Order ID not found.");
                }
            }

            else if (choice == 5) {
                int academicCount = 0;
                int fictionCount = 0;
                int totalQuantity = 0;
                double totalSales = 0;

                for (int i = 0; i < count; i++) {
                    totalQuantity = totalQuantity + orderList[i].getQuantity();
                    totalSales = totalSales + orderList[i].calculateTotalPrice();

                    if (orderList[i] instanceof academicebook) {
                        academicCount++;
                    } else if (orderList[i] instanceof fictionebook) {
                        fictionCount++;
                    }
                }

                System.out.println("\n========================================");
                System.out.println("        SALES SUMMARY REPORT");
                System.out.println("========================================");
                System.out.println("Total Orders          : " + count);
                System.out.println("Academic Ebook Orders : " + academicCount);
                System.out.println("Fiction Ebook Orders  : " + fictionCount);
                System.out.println("Total Quantity Sold   : " + totalQuantity);
                System.out.println("Total Sales           : RM" + String.format("%.2f", totalSales));
                System.out.println("========================================");
            }

            else if (choice == 6) {
        
            try {
        
                PrintWriter pw = new PrintWriter("input.txt");
        
                for (int i = 0; i < count; i++) {
        
                    if (orderList[i] instanceof academicebook) {
        
                        pw.println(
                            "ACADEMIC|" +
                            orderList[i].getOrderID() + "|" +
                            orderList[i].getCustomerInfo().getCustomerID() + "|" +
                            orderList[i].getCustomerInfo().getName() + "|" +
                            orderList[i].getCustomerInfo().getPhoneNo() + "|" +
                            orderList[i].getTitle() + "|" +
                            orderList[i].getPrice() + "|" +
                            orderList[i].getQuantity() + "|" +
                            ((academicebook) orderList[i]).getSubject() + "|" +
                            ((academicebook) orderList[i]).getLevel()
                        );
        
                    } 
        
                    else if (orderList[i] instanceof fictionebook) {
        
                        pw.println(
                            "FICTION|" +
                            orderList[i].getOrderID() + "|" +
                            orderList[i].getCustomerInfo().getCustomerID() + "|" +
                            orderList[i].getCustomerInfo().getName() + "|" +
                            orderList[i].getCustomerInfo().getPhoneNo() + "|" +
                            orderList[i].getTitle() + "|" +
                            orderList[i].getPrice() + "|" +
                            orderList[i].getQuantity() + "|" +
                            ((fictionebook) orderList[i]).getGenre() + "|" +
                            ((fictionebook) orderList[i]).getAuthor()
                        );
                    }
                }
        
                pw.close();
        
                System.out.println("Data saved successfully.");
        
            } catch (FileNotFoundException fnfe) {
        
                System.out.println("Cannot save output file.");
        
            }
        }

            else if (choice == 7) {
                System.out.println("Thank you for using Ebook Order System.");
            }

            else {
                System.out.println("Invalid choice. Please enter 1 until 7.");
            }

        } while (choice != 7);
    }
}