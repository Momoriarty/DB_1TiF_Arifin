/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainJavaP1;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import koneksi.*;

public class InsertDataBuku {

    public static void main(String[] args) {
        // 1. Konfigurasi dan Koneksi database
        DatabaseConfig config = new DatabaseConfig();
        Connection conn = DatabaseConnection.connect(config);

        // 3. Insert data ke tabel buku
        if (conn != null) {
            try {
                String sql = "INSERT INTO buku (judul, penulis, penerbit, tahun_terbit, isbn, jumlah_stok) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, "Belajar Java untuk Pemula");
                stmt.setString(2, "Ivan Chatisya");
                stmt.setString(3, "Andi Publisher");
                stmt.setInt(4, 2023);
                stmt.setString(5, "9786021234567");
                stmt.setInt(6, 10);

                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Data buku berhasil ditambahkan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal menambahkan data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database gagal.");
        }
    }
}
