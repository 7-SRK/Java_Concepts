package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcCRUD {
    public static void main(String[] args) throws Exception {

        int sid = 6;
        String sname = "E";
        int marks = 65;


        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "qwerty";

        //String query = "select * from student;";
        //String query = "insert into student values(6,'E',55);";
        //String query = "update student set sname='R' where sid =1;";
        //String query = "delete from student where sid =6;";
        String query = "insert into student values("+ sid +",'"+ sname +"'," + marks +");";

        //Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,user,pass);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(query);
        st.execute(query);

/*        rs.next();
          String name = rs.getString("sname");
          System.out.println(name);
*/        con.close();

//        while(rs.next()){
//            System.out.print(rs.getInt(1) + " - ");
//            System.out.print(rs.getString(2) + " - ");
//            System .out.println(rs.getInt(3));
//        }

    }
}















// public void createTable() throws SQLException {
//        String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                     "id SERIAL PRIMARY KEY, " +
//                     "name VARCHAR(100), " +
//                     "email VARCHAR(100))";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement stmt = conn.createStatement()) {
//            stmt.execute(sql);
//            System.out.println("Table created.");
//        }
//    }
//
//    // Create (Insert)
//    public void insertUser(String name, String email) throws SQLException {
//        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, name);
//            pstmt.setString(2, email);
//            int rows = pstmt.executeUpdate();
//            System.out.println(rows + " row(s) inserted.");
//        }
//    }
//
//    // Read (Select)
//    public void getUsers() throws SQLException {
//        String sql = "SELECT * FROM users";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                System.out.printf("ID: %d, Name: %s, Email: %s%n",
//                                  rs.getInt("id"), rs.getString("name"), rs.getString("email"));
//            }
//        }
//    }
//
//    // Update
//    public void updateUserEmail(int id, String newEmail) throws SQLException {
//        String sql = "UPDATE users SET email = ? WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, newEmail);
//            pstmt.setInt(2, id);
//            int rows = pstmt.executeUpdate();
//            System.out.println(rows + " row(s) updated.");
//        }
//    }
//
//    // Delete
//    public void deleteUser(int id) throws SQLException {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            int rows = pstmt.executeUpdate();
//            System.out.println(rows + " row(s) deleted.");
//        }
//    }
//
//    public static void main(String[] args) throws SQLException {
//        PostgresCRUD crud = new PostgresCRUD();
//        crud.createTable();
//        crud.insertUser("Alice", "alice@example.com");
//        crud.getUsers();
//        crud.updateUserEmail(1, "alice_new@example.com");
//        crud.getUsers();
//        crud.deleteUser(1);
//        crud.getUsers();
//    }
//}


