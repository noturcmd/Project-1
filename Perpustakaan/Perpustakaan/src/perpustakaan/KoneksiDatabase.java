/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer_
 */
public class KoneksiDatabase {
    private static KoneksiDatabase instance;
    private Connection connection;

    private KoneksiDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projectperpustakaan";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Koneksi gagal!");
            System.out.println(ex.getMessage());
        }
    }

    public static KoneksiDatabase getInstance() {
        if (instance == null) {
            instance = new KoneksiDatabase();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
