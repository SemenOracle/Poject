package org.example;
import org.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientsDAO {

    public void createClient(Clients client) throws SQLException{
        String query = "INSERT INTO clients (name, distributor_id) VALUES(?,?,?,?)";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setInt(2, client.getDistributor_id());
            ps.executeUpdate();
        }
    }

    public Clients readClient(int id) throws SQLException{
        Clients client = null;
        String query = "SELECT * FROM clients WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                client = new Clients();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setDistributor_id(rs.getInt("distributor_id"));
            }
        }
        return client;
    }

    public void updateClient(Clients client) throws SQLException{
        String query = "UPDATE clients SET name = ?, distributor_id = ? WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setInt(2, client.getDistributor_id());
            ps.executeUpdate();
        }
    }

    public void deleteClient(int id) throws SQLException{
        String query = "DELETE FROM clients WHERE id = ?";
        try (Connection db = DatabaseConnection.connect()){
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
