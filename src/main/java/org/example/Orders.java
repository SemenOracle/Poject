package org.example;
import java.sql.Date;

public class Orders {
    private int id;
    private int clients_id;
    private Date receipt_date;
    private Date execution_date;
    private int price;

    public void setId(int id) {
        this.id = id;
    }
    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }
    public void setReceipt_date(Date receipt_date) {
        this.receipt_date = receipt_date;
    }
    public void setExecute_date(Date execute_date) {
        this.execution_date = execute_date;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public int getClients_id() {
        return clients_id;
    }
    public Date getReceipt_date() {
        return receipt_date;
    }
    public Date getExecute_date() {
        return execution_date;
    }
    public int getPrice() {
        return price;
    }

}

