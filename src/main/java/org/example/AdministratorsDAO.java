package org.example;
import org.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorsDAO {
    public void createAdministrator(String login, String password) throws SQLException{
        String query = "INSERT INTO administrators (login, password) VALUES(?, ?)";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.executeUpdate();
        }
    }

    public Administrators readAdministrator(int id) throws SQLException{
        Administrators administrator = null;
        String query = "SELECT * FROM administrators WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                administrator = new Administrators();
                administrator.setId(rs.getInt("id"));
                administrator.setLogin(rs.getString("login"));
                administrator.setPassword(rs.getString("password"));
            }
        }
        return administrator;
    }

    public void updateAdministrator(String login, String password) throws SQLException{
        String query = "UPDATE administrators SET login = ?, password = ? WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.executeUpdate();
        }
    }

    public void deleteAdministrator(int id) throws SQLException{
        String query = "DELETE FROM administrators WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
