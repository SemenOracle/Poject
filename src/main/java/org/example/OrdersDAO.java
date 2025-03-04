package org.example;
import org.example.database.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;

public class OrdersDAO {
    public void createOrder(int clients_id, Date receipt_date, Date execute_date, int price) throws SQLException {
        String query = "INSERT INTO Orders VALUES(?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.connect()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, clients_id);
            ps.setDate(2, receipt_date);
            ps.setDate(3, execute_date);
            ps.setInt(4, price);
            ps.executeUpdate();
        }
    }

    public Orders readOrder(int order_id) throws SQLException {
        Orders order = null;
        String query = "SELECT * FROM Orders WHERE id=?";
        try(Connection conn = DatabaseConnection.connect()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                order = new Orders();
                order.setId(rs.getInt("order_id"));
                order.setClients_id(rs.getInt("clients_id"));
                order.setReceipt_date(rs.getDate("receipt_date"));
                order.setExecute_date(rs.getDate("execute_date"));
                order.setPrice(rs.getInt("price"));
            }
        }
        return order;
    }

    public void updateOrder(int id, int clients_id, Date receipt_date, Date execute_date, int price) throws SQLException {
        String query = "UPDATE orders SET clients_id = ?, receipt_date = ?, execution_date = ?, price = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.connect()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, clients_id);
            ps.setDate(2, receipt_date);
            ps.setDate(3, execute_date);
            ps.setInt(4, price);
            ps.executeUpdate();
        }
    }

    public void deleteOrder(int order_id) throws SQLException {
        String query = "DELETE FROM Orders WHERE id = ?";
        try(Connection conn = DatabaseConnection.connect()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);
            ps.executeUpdate();
        }
    }
}
