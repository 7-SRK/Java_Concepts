package JDBC;

import java.sql.*;

public class Key {
    private static final String url = "jdbc:postgresql://localhost:5432/demo";
    private static final String user = "postgres";
    private static final String pass = "7059";

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        con.setAutoCommit(false);

        createTables(con);
        insertAuthors(con);
        insertBooks(con);
        insertOrders(con);
        queryBooksWithAuthors(con);

        con.commit();

    }


    private static void createTables(Connection con) throws SQLException {
        String createAuthors = "Create table authors(" + " author_id SERIAL PRIMARY KEY,"
                + "name varchar(30) not null)";

        String createBooks = "Create table books(" + " book_id SERIAL Primary Key,"
                + "title Text not null, " + " author_id Integer," + "CONSTRAINT fk_author " +
                "FOREIGN KEY (author_id) REFERENCES authors(author_id))";

        String createOrders = "CREATE TABLE orders (" +
                "order_id INTEGER, " +
                "product_id INTEGER, " +
                "quantity INTEGER, " +
                "PRIMARY KEY (order_id, product_id))";

        Statement st = con.createStatement();
        st.execute(createAuthors);
        st.execute(createOrders);
        st.execute(createBooks);

        System.out.println("Tables Created");

    }

    private static void insertAuthors(Connection con) throws SQLException {
        String insertAuthor = "INSERT INTO authors (name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(insertAuthor, Statement.RETURN_GENERATED_KEYS);
        String[] authors = {"A", "B", "C"};
        for (String author : authors) {
            ps.setString(1, author);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Author Inserted With ID : " + rs.getInt(1));
            }
        }
    }

    private static void insertBooks(Connection con) throws SQLException {
        String insertBook = "INSERT INTO books (title, author_id) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(insertBook, Statement.RETURN_GENERATED_KEYS);
        Object[][] books = {
                {"AAA", 1},
                {"BBB", 2},
                {"CCC", 3}
        };
        for (Object[] book : books) {
            ps.setString(1, (String) book[0]);
            ps.setInt(2, (int) book[1]);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Book Inserted With ID : " + rs.getInt(1));
            }
        }
    }
    private static void insertOrders(Connection con) throws SQLException {
        String insertOrder = "INSERT INTO orders (order_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertOrder);
            
            ps.setInt(1, 101);
            ps.setInt(2, 2001);
            ps.setInt(3, 5);
            ps.executeUpdate();

            ps.setInt(1, 101);
            ps.setInt(2, 2002);
            ps.setInt(3, 3);
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setInt(2, 2001);
            ps.setInt(3, 2);
            ps.executeUpdate();

            System.out.println("Orders Inserted With Composite Keys.");
        }

    private static void queryBooksWithAuthors(Connection con) throws SQLException {
        String query = "SELECT b.title, a.name FROM books b JOIN authors a ON b.author_id = a.author_id";
        PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
            System.out.println("\nBooks and their Authors:");
            while (rs.next()) {
                System.out.printf("Book: %s, Author: %s%n", rs.getString("title"), rs.getString("name"));
            }
        }
}

