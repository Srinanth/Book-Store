import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Register a new user");
            System.out.println("2. Login");
            System.out.println("3. Buy a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Register New User");
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                User user = new User(name, email, phone, password);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/userdb", "touya", "nandhu");

                    String sql = "INSERT INTO users (name, email, phone, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, user.getName());
                    stmt.setString(2, user.getEmail());
                    stmt.setString(3, user.getPhone());
                    stmt.setString(4, user.getPassword());

                    int rowsInserted = stmt.executeUpdate();
                    System.out.println(rowsInserted > 0 ? "User added!" : "Insert failed.");

                    stmt.close();
                    conn.close();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 2) {
                System.out.println("Login");
                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/userdb", "touya", "nandhu");

                    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);
                    stmt.setString(2, password);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful! Welcome, " + rs.getString("name"));
                    } else {
                        System.out.println("Invalid email or password.");
                    }

                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 3) {
                System.out.println("Order New Book");

                try {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter ISBN (format: xxx-x-xxxxx-xxxxx-x): ");
                    String isbn = sc.nextLine();

                    System.out.print("Enter publication year: ");
                    int year = sc.nextInt();
                    sc.nextLine(); 

                    Books book = new Books(title, author, isbn, year);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/userdb", "touya", "nandhu");

                    String sql = "INSERT INTO books (title, author, isbn, publication_year) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, book.getTitle());
                    stmt.setString(2, book.getAuthor());
                    stmt.setString(3, book.getIsbn());
                    stmt.setInt(4, book.getPublicationYear());

                    int rowsInserted = stmt.executeUpdate();
                    System.out.println(rowsInserted > 0 ? "Order Submitted!!" : "Order failed.");

                    stmt.close();
                    conn.close();

                } catch (IllegalArgumentException e) {
                    System.out.println("Validation error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 4) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
