package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {

    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                String url = "jdbc:mysql://localhost/db_perpustakaan";
                String user = "root";
                String pass = "";

                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection(url, user, pass);
//                System.out.println("Koneksi berhasil");
            } catch (ClassNotFoundException | SQLException e) {
//                System.err.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return con;
    }
}
