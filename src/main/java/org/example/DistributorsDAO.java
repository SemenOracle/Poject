package org.example;
import org.example.database.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistributorsDAO {
    public void createDistributor(String name, String login, String password) throws SQLException {
        String query = "INSERT INTO distributors (name, login, password) VALUES (?, ?, ?)";
        try(Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.executeUpdate();
        }
    }

    public Distributors readDistributor(int id) throws SQLException {
        String query = "SELECT * FROM distributors WHERE id = ?";
        Distributors distributor = null;
        try(Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                distributor = new Distributors();
                distributor.setId(rs.getInt("id"));
                distributor.setName(rs.getString("name"));
                distributor.setLogin(rs.getString("login"));
            }
        }
        return distributor;
    }

    public void updateDistributor(int id, String name, String login, String password) throws SQLException {
        String query = "UPDATE distributors SET name = ?, login = ?, password = ? WHERE id = ?";
        try(Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.executeUpdate();
        }
    }

    public void deleteDistributor(int id) throws SQLException {
        String query = "DELETE FROM distributors WHERE id = ?";
        try(Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
