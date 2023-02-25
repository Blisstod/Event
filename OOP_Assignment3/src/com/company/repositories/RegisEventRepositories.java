package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegisEventRepositories {
    private final IDB db;
    public RegisEventRepositories(IDB db){this.db = db;}
    public boolean register(int userID, int eventID, double userBalancePayed){

        Connection con = null;
        try {
            con = db.getConnection();
            String update_balance = "UPDATE tbl_users set balance = ? WHERE id =" + Integer.toString(userID);
            String sql = "INSERT INTO user_registered_events(userid,eventid) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            PreparedStatement st2 = con.prepareStatement(update_balance);

            st2.setDouble(1, userBalancePayed);
            st.setInt(1, userID);
            st.setInt(2, eventID);

            st2.executeUpdate();
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }
    public boolean unregister(int userID, int eventID, double userBalanceRefunded){
        Connection con = null;
        try {
            con = db.getConnection();
            String update_balance = "UPDATE tbl_users set balance = ? WHERE id =" + Integer.toString(userID);
            String sql = "DELETE FROM user_registered_events WHERE userid = ? AND  eventid = ?" ;
            PreparedStatement st = con.prepareStatement(sql);
            PreparedStatement st2 = con.prepareStatement(update_balance);

            st2.setDouble(1, userBalanceRefunded);
            st.setInt(1, userID);
            st.setInt(2, eventID);
            st2.executeUpdate();
            st.executeUpdate();

            st.close();
            con.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error unregistering event: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public List <Integer> getAllRegisEvents(int userID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String converted = Integer.toString(userID);
            String sql = "SELECT id, userid, eventid FROM user_registered_events WHERE userid=" + converted;
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Integer> regEventsId = new ArrayList<>();
            while (rs.next()) {
                regEventsId.add(rs.getInt("eventid"));
            }

            return regEventsId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
