package MainApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class Buku {

    public static Connection conn;
    public static StringBuilder data;

    public static void koneksi() throws SQLException {
        conn = koneksi.getConnection();
    }

    public static void select() throws SQLException {
        koneksi();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM buku");

        StringBuilder data = new StringBuilder();

        data.append(String.format("| %-23s | %-18s | %-17s | %-26s | %-11s | %-15s | %-10s |\n",
                "Id", "ISBN", "Judul", "Penulis", "Penerbit", "Tahun", "Stok"));
        data.append("|--------------------|----------------------------|--------------------------|-------------------------|-----------------|-----------------|----------|\n");

        while (rs.next()) {
            data.append(String.format("| %-23d | %-18s | %-17s | %-26s | %-11s | %-15d | %-10d |\n",
                    rs.getInt("id_buku"),
                    rs.getString("isbn"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getString("penerbit"),
                    rs.getInt("tahun_terbit"),
                    rs.getInt("jumlah_stok")
            ));
        }

        JOptionPane.showMessageDialog(null, data.toString());
    }

    public static void insert(String isbn, String judul, String penulis, String penerbit, int tahun_terbit, int jumlah_stok) throws SQLException {
        koneksi();
        String sql = "INSERT INTO buku (isbn, judul, penulis, penerbit, tahun_terbit, jumlah_stok) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, isbn);
        pstmt.setString(2, judul);
        pstmt.setString(3, penulis);
        pstmt.setString(4, penerbit);
        pstmt.setInt(5, tahun_terbit);
        pstmt.setInt(6, jumlah_stok);

        pstmt.executeUpdate();
        System.out.println("Data berhasil ditambahkan.");
    }

    public static void update(int id_buku, String judulBaru, int stokBaru) throws SQLException {
        koneksi();
        String sql = "UPDATE buku SET judul = ?, jumlah_stok = ? WHERE id_buku = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, judulBaru);
        pstmt.setInt(2, stokBaru);
        pstmt.setInt(3, id_buku);

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Data buku berhasil diperbarui.");
        }
    }

    public static void delete(int id_buku) throws SQLException {
        koneksi();

        select();
        String sql = "DELETE FROM buku WHERE id_buku = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id_buku);

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Data buku berhasil dihapus.");
        }
    }

    public static void main(String[] args) throws SQLException {
        String isbn;
        String judul;
        String penulis;
        String penerbit;
        int tahun_terbit;
        int jumlah_stok;
        int id;

        boolean status = true;
        int pilihan;
        while (status) {
            pilihan = Integer.parseInt(JOptionPane.showInputDialog("Opsi\n"
                    + "1. Menampilkan Tabel\n"
                    + "2. Tambah Data Buku\n"
                    + "3. Update Data Buku\n"
                    + "4. Hapus Data Buku\n"
                    + "5. Exit"));
            switch (pilihan) {
                case 1:
                    select();
                    break;
                case 2:
                    isbn = JOptionPane.showInputDialog("Input Isbn");
                    judul = JOptionPane.showInputDialog("Input Judul");
                    penulis = JOptionPane.showInputDialog("Input Penulis");
                    penerbit = JOptionPane.showInputDialog("Input Penerbit");
                    tahun_terbit = Integer.parseInt(JOptionPane.showInputDialog("Input Tahun terbit"));
                    jumlah_stok = Integer.parseInt(JOptionPane.showInputDialog("Input Jumlah Stok"));
                    insert(isbn, judul, penulis, penerbit, tahun_terbit, jumlah_stok);
                    break;
                case 3:
                    update(1, "Algoritma Lanjut", 10);
                    break;
                case 4:
                    id = Integer.parseInt(JOptionPane.showInputDialog(data.toString()));
                    delete(id);
                    break;
                case 5:
                    status = false;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }

    }

}
