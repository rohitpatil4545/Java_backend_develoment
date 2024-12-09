// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class Connect_Database_Mysql {
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
