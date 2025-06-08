/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainJavaP1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import koneksi.*;

/**
 *
 * @author LENOVO
 */
public class UpdateDataBuku {

    public static void main(String[] args) {
        // 1. Konfigurasi dan Koneksi database
        DatabaseConfig config = new DatabaseConfig();
        Connection conn = DatabaseConnection.connect(config);

        // 2. UPDATE data buku berdasarkan id_buku
        if (conn != null) {
            try {
                String sql = "UPDATE buku SET judul = ?, penulis = ?, penerbit = ?, tahun_terbit = ?, isbn = ?, jumlah_stok = ? "
                        + "WHERE id_buku = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, "Belajar Java Lanjutan");
                stmt.setString(2, "Ivan Chatisya");
                stmt.setString(3, "Andi Publisher");
                stmt.setInt(4, 2024);
                stmt.setString(5, "9786027654321");
                stmt.setInt(6, 15);
                stmt.setInt(7, 1); // Ganti dengan id_buku yang ingin diupdate

                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Data buku berhasil diperbarui.");
                } else {
                    System.out.println("Data dengan id tersebut tidak ditemukan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal mengupdate data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database gagal.");
        }
    }
}
