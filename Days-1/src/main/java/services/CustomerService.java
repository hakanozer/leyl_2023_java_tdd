package services;

import models.Customer;
import utils.DB;

import java.sql.PreparedStatement;

public class CustomerService {

    public int save(Customer customer) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "insert into customer values( default, ?, ?, ? )";
            PreparedStatement pre = db.conn().prepareStatement(sql);
            pre.setString(1, customer.getName());
            pre.setString(2, customer.getEmail());
            pre.setString(3, customer.getPassword());
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("Save Error :"+ ex);
        }finally {
            db.close();
        }
        return status;
    }

}
