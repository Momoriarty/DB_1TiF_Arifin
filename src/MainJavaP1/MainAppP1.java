package MainJavaP1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
import koneksi.*;
import java.sql.Connection;

public class MainAppP1 {

    public static void main(String[] args) {
        // 1. Konfigurasi database
        DatabaseConfig config = new DatabaseConfig();
        // Optional: Bisa di-set ulang
        // config.setUrl("jdbc:mysql://localhost:3306/nama_db");
        // config.setUsername("root");
        // config.setPassword("password");

        // 2. Buat koneksi
        Connection conn = DatabaseConnection.connect(config);

        // 3. Cek apakah berhasil atau tidak
        if (conn != null) {
            System.out.println("Aplikasi berhasil terhubung ke database.");
        } else {
            System.out.println("Aplikasi gagal terhubung ke database.");
        }
    }
}
