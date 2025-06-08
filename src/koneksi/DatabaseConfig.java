/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author LENOVO
 */
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;

    public DatabaseConfig() {
        // Konfigurasi default
        this.url = "jdbc:mysql://localhost:3306/db_perpustakaan"; // Ganti sesuai DB Anda
        this.username = "root"; // Ganti sesuai user DB Anda
        this.password = ""; // Ganti sesuai password DB Anda
    }

    // Getter
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}