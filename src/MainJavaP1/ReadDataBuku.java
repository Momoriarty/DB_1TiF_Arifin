/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainJavaP1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.*;

/**
 *
 * @author LENOVO
 */
public class ReadDataBuku {

    public static void main(String[] args) {
        // 1. Konfigurasi database
        DatabaseConfig config = new DatabaseConfig();
        // 2. Membuat koneksi
        Connection conn = DatabaseConnection.connect(config);

        // 3. Menampilkan data dari tabel buku
        if (conn != null) {
            System.out.println("Daftar Buku di Perpustakaan:");
            try {
                String query = "SELECT * FROM buku";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id_buku");
                    String judul = rs.getString("judul");
                    String penulis = rs.getString("penulis");
                    String penerbit = rs.getString("penerbit");
                    int tahun = rs.getInt("tahun_terbit");
                    String isbn = rs.getString("isbn");
                    int stok = rs.getInt("jumlah_stok");

                    System.out.println(id + " | " + judul + " | " + penulis + " | " + penerbit + " | " + tahun + " | ISBN: " + isbn + " | Stok: " + stok);
                }

            } catch (SQLException e) {
                System.out.println("Gagal membaca data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database gagal.");
        }
    }
}
