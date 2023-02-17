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
    public boolean register(int userID, int eventID ){

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO user_registered_events(user_id,event_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, userID);
            st.setInt(2, eventID);

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
    public boolean unregister(int userID, int eventID){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM user_registered_events WHERE user_id = ? AND  event_id = ?" ;
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, userID);
            st.setInt(1, eventID);
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
    public ArrayList <Integer> getAllRegisEvents(int userID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT event_id FROM user_registered_events WHERE user_id=" +  Integer.toString(userID);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            ArrayList <Integer> regEventsId = new ArrayList<>();
            while (rs.next()) {
                regEventsId.add(rs.getInt("id"));
            }

//            List<Integer> al = new ArrayList<Integer>();
//            al.add(10);
//            al.add(20);
//            al.add(30);
//            al.add(40);
//
//            Integer[] arr = new Integer[al.size()];
//            arr = al.toArray(arr);

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
