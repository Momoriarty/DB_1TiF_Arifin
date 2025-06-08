package MainJavaP1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import koneksi.*;

public class DeleteDataBuku {

    public static void main(String[] args) {
        // 1. Konfigurasi dan Koneksi database
        DatabaseConfig config = new DatabaseConfig();
        Connection conn = DatabaseConnection.connect(config);

        // 2. DELETE data buku berdasarkan id_buku
        if (conn != null) {
            try {
                String sql = "DELETE FROM buku WHERE id_buku = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, 4); // Ganti dengan ID buku yang ingin dihapus

                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Data buku berhasil dihapus.");
                } else {
                    System.out.println("Data dengan ID tersebut tidak ditemukan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal menghapus data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi database gagal.");
        }
    }
}
