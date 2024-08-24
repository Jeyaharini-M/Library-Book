package jdbcprgm;
import java.sql.*;
import java.util.Scanner;

public class library {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "Harini**2003";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            createUserTable(); 
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            if (login(username, password)) {
                System.out.println("Login successful!");
                System.out.println("------------------");
                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Add a book");
                    System.out.println("2. Borrow a book");
                    System.out.println("3. Update book title");
                    System.out.println("4. List available books");
                    System.out.println("5. Exit");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (choice) {
                        case 1:
                            addBookInterface(scanner);
                            break;
                        case 2:
                            borrowBookInterface(scanner);
                            break;
                        case 3:
                            updateBookTitleInterface(scanner);
                            break;
                        case 4:
                            listAvailableBooks();
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            scanner.close();
                            return; 
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private static void addBookInterface(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of the book to add: ");
            String isbn = scanner.nextLine();
            System.out.println("Enter title of the book: ");
            String title = scanner.nextLine();
            System.out.println("Enter author of the book: ");
            String author = scanner.nextLine();
            addBook(isbn, title, author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    private static void borrowBookInterface(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of the book to borrow: ");
            String borrowISBN = scanner.nextLine();
            System.out.println("Enter your username for borrowing: ");
            String borrower = scanner.nextLine();
            borrowBook(borrowISBN, borrower);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void updateBookTitleInterface(Scanner scanner) {
        try {
            System.out.println("Enter ISBN of the book to update title: ");
            String updateISBN = scanner.nextLine();
            System.out.println("Enter new title for the book: ");
            String newTitle = scanner.nextLine();
            updateBookTitle(updateISBN, newTitle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createUserTable() throws SQLException {
        String createUserTableSQL = "CREATE TABLE IF NOT EXISTS usertable (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL UNIQUE," +
                "password VARCHAR(50) NOT NULL)";
        statement.execute(createUserTableSQL);
    }

    private static void registerUser(String username, String password) throws SQLException {
        String registerUserSQL = "INSERT INTO usertable (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(registerUserSQL);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.executeUpdate();
    }

   
    private static boolean login(String username, String password) throws SQLException {
        String loginSQL = "SELECT * FROM usertable WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginSQL);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

  
    private static void createBooksTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS books (" +
                "isbn VARCHAR(13) PRIMARY KEY," +
                "title VARCHAR(100) NOT NULL," +
                "author VARCHAR(100) NOT NULL," +
                "available BOOLEAN DEFAULT TRUE)";
        statement.execute(createTableSQL);
    }

    private static void addBook(String isbn, String title, String author) throws SQLException {
        String addBookSQL = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addBookSQL);
        preparedStatement.setString(1, isbn);
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, author);
        preparedStatement.executeUpdate();
        System.out.println("Book with ISBN " + isbn + "title"+title+"author"+author+"is added");
    }

    
    private static void borrowBook(String isbn, String borrower) throws SQLException {
        String borrowBookSQL = "UPDATE books SET available = FALSE WHERE isbn = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(borrowBookSQL);
        preparedStatement.setString(1, isbn);
        preparedStatement.executeUpdate();
        System.out.println("Book with ISBN " + isbn + " is borrowed by " + borrower);
    }

    private static void updateBookTitle(String isbn, String newTitle) throws SQLException {
        String updateBookSQL = "UPDATE books SET title = ? WHERE isbn = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateBookSQL);
        preparedStatement.setString(1, newTitle);
        preparedStatement.setString(2, isbn);
        preparedStatement.executeUpdate();
        System.out.println("Book with ISBN " + isbn + " is updated with title: " + newTitle);
    }

   
    private static void listAvailableBooks() throws SQLException {
        String listBooksSQL = "SELECT * FROM books WHERE available = TRUE";
        resultSet = statement.executeQuery(listBooksSQL);
        System.out.println("Available Books:");
        while (resultSet.next()) {
            String isbn = resultSet.getString("isbn");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author);
        }
    }
    private static void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}

