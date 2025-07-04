package JDBC;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "7059";
        String query = "select * from student order by sid;";

        //Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,user,pass);
        System.out.println("Connection Established");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);


//          rs.next();
//          String name = rs.getString("sname");
//          System.out.println(name);
//          con.close();

        while(rs.next()){
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System .out.println(rs.getInt(3));
        }

    }
}





