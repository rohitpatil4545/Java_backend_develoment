// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class Connect_Database {
//     public static void main(String[] args) {
//         String url = "jdbc:mysql://localhost:3306/Students";
//         String user = "root";
//         String password = "root";

//         try (Connection connection = DriverManager.getConnection(url, user, password)) {
//             System.out.println("Connection Successful");

//             // Corrected SQL Query String
//             String q = "CREATE TABLE table8 (" +
//                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                         // "name VARCHAR(200) NOT NULL, " +
//                         // "city VARCHAR(200)" +
//                         "image MEDIUMBLOB"+
//                         ");";
            
//             // Execute the query
//             try (Statement stmt = connection.createStatement()) {
//                 stmt.executeUpdate(q);
//                 System.out.println("Table created successfully.");
//             }

//         } catch (SQLException e) {
//             System.out.println("Connection failed");
//             e.printStackTrace();
//         }
//     }
// }


// Insert data in my sql database 

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// public class Connect_Database {
//     public static void main(String[] args) {
//         String url = "jdbc:mysql://localhost:3306/Students";
//         String user = "root";
//         String password = "root";

//         try (Connection connection = DriverManager.getConnection(url, user, password)) {
//             System.out.println("Connection Successful");

//             // Insert data SQL query
//             String q = "INSERT INTO table1 (name,city) VALUES (?,?)";
            
//             // Using PreparedStatement to insert values into the table
//             try (PreparedStatement pstmt = connection.prepareStatement(q)) {
//                 // Set the values for the placeholders (?)
//                 pstmt.setString(1, "Rohit");
//                 pstmt.setString(2, "Dhule"); 
//                 //  pstmt.setString(3, "Dhule");

//                 // Execute the insert query
//                 int rowsAffected = pstmt.executeUpdate();
//                 System.out.println(rowsAffected + " row(s) inserted successfully.");
//             }

//         } catch (SQLException e) {
//             System.out.println("Connection failed");
//             e.printStackTrace();
//         }
//     }
// }


// Insert Dynamic data  in mysql database ;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.Scanner;

// public class Connect_Database {
//     public static void main(String[] args) {
//         String url = "jdbc:mysql://localhost:3306/Students";
//         String user = "root";
//         String password = "root";

//         // Create a Scanner object for user input
//         Scanner scanner = new Scanner(System.in);

//         try (Connection connection = DriverManager.getConnection(url, user, password)) {
//             System.out.println("Connection Successful");

//             // Insert data SQL query with placeholders
//             String q = "INSERT INTO table1 (name,city) VALUES (?, ?)";
            
//             // Prepare statement for inserting values
//             try (PreparedStatement pstmt = connection.prepareStatement(q)) {
                
//                 // Get user input for each column
//                 System.out.print("Enter name: ");
//                 String name = scanner.nextLine();
                
//                 // System.out.print("Enter sir_name: ");
//                 // String sirName = scanner.nextLine();
                
//                 System.out.print("Enter city: ");
//                 String city = scanner.nextLine();
                
//                 // Set values in the prepared statement
//                 pstmt.setString(1, name);
//                 // pstmt.setString(2, sirName);
//                 pstmt.setString(2, city);

//                 // Execute the insert query
//                 int rowsAffected = pstmt.executeUpdate();
//                 System.out.println(rowsAffected + " row(s) inserted successfully.");
//             }

//         } catch (SQLException e) {
//             System.out.println("Connection failed");
//             e.printStackTrace();
//         } finally {
//             scanner.close();
//         }
//     }
// }

// Insert Image in mysql database 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class Connect_Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Students";
        String user = "root";
        String password = "root";

        // Path to the image file (replace with your image file path)
        String imagePath = "C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot (191).png";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection Successful");

            // SQL query to insert only the image
            String q = "INSERT INTO table8 (image) VALUES (?)";

            // Read the image as binary data and insert it
            try (PreparedStatement pstmt = connection.prepareStatement(q);
                 FileInputStream fis = new FileInputStream(new File(imagePath))) {

                // Set the image as binary data
                pstmt.setBinaryStream(1, fis, (int) new File(imagePath).length());

                // Execute the insert query
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted successfully with only the image.");
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File not found or unable to read image.");
            e.printStackTrace();
        }
    }
}
