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
