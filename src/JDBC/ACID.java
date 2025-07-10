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
        //Prevents dirty and non-repeatable reads;  A Dirty read is a situation when a transaction reads data that has not yet been committed.
        // phantom reads prevented in PostgreSQL.   Non-repeatable read occurs when a transaction reads the same row twice and gets a different value each time.
        //Phantom Read occurs when two same queries are executed, but the rows retrieved by the two, are different.

        //con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //Default in PostgreSQL. Prevents dirty reads;
        //allows non-repeatable and phantom reads.

        //con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        //Strictest level; transactions appear fully isolated,
        // preventing all anomalies.

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


// Pessimistic Locking

//Assumes conflicts will happen, so it locks the data at the database level before any transaction modifies it.
// The lock prevents other transactions from reading or writing the locked data until the lock is released.

//When a transaction reads or updates a record, it acquires a lock (shared or exclusive).
// Other transactions trying to access the same record must wait until the lock is released.

//entityManager.find(Account.class, accountId, LockModeType.PESSIMISTIC_WRITE);

//Optimistic Locking

//Assumes conflicts are rare and does not lock data when reading.
// Instead, it detects conflicts when committing by checking if the data was modified by another transaction since it was read.

//Each entity has a version attribute annotated with @Version. When updating, the version is checked;
// if it changed, an OptimisticLockException is thrown, indicating a conflict.

//@Entity
//public class Account {
//    @Id
//    private Long id;
//
//    @Version
//    private Long version;
//
//    private double balance;
//    // getters/setters
//}

//When updating, JPA automatically checks the version and throws OptimisticLockException if it changed.