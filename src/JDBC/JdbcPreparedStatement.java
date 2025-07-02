package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcPreparedStatement {
    public static void main(String[] args) throws Exception {

        int sid = 7;
        String sname = "F";
        int marks = 75;


        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "qwerty";
        //String query = "select * from student;";
        //String query = "update student set sname='?' where sid =?;";
        //String query = "delete from student where sid =?;";
        String query = "insert into student values(?,?,?);";

        Connection con = DriverManager.getConnection(url,user,pass);


        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        st.execute();

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


