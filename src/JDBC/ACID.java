package JDBC;

import java.sql.*;

public class ACID {
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "7059";
        String query = "select * from accounts;";

        con = DriverManager.getConnection(url,user,pass);

        con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        con.setAutoCommit(false); //disables auto-commit, allowing manual transaction control (commit/rollback).

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));

}
        return con;
    }

    public static class BankTransaction {

        public void transferMoney(int fromAccountId, int toAccountId, double amount) {
            Connection conn = null;
            try {
                conn = ACID.getConnection();

                // Atomicity & Consistency: Both debit and credit succeed or fail together
                debitAccount(conn, fromAccountId, amount);
                creditAccount(conn, toAccountId, amount);

                // Commit transaction (Durability)
                conn.commit();
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                if (conn != null) {
                    try {
                        // Rollback on failure (Atomicity)
                        conn.rollback();
                        System.out.println("Transaction rolled back due to error.");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.setAutoCommit(true); // Reset auto-commit
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void debitAccount(Connection conn, int accountId, double amount) throws SQLException {
            String sql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, amount);
                pstmt.setInt(2, accountId);
                pstmt.setDouble(3, amount);
                int rows = pstmt.executeUpdate();
                if (rows == 0) {
                    throw new SQLException("Insufficient funds or account not found.");
                }
            }
        }

        private void creditAccount(Connection conn, int accountId, double amount) throws SQLException {
            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, amount);
                pstmt.setInt(2, accountId);
                int rows = pstmt.executeUpdate();
                if (rows == 0) {
                    throw new SQLException("Account not found.");
                }
            }
        }
    }
    public static void main(String[] args) {
        BankTransaction transaction = new BankTransaction();

        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 50.00;

        try {
            transaction.transferMoney(fromAccountId, toAccountId, amount);
            System.out.println("Money transferred successfully.");
        } catch (Exception e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }

}
