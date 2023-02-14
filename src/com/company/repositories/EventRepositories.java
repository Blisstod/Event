package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Event;
import com.company.entities.User;
import com.company.repositories.interfaces.IEventRepositories;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;

public class EventRepositories implements IEventRepositories {
    private final IDB db;
    public EventRepositories(IDB db){this.db = db;}

    @Override
    public boolean CreateEvent(Event event) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO events(name,price,description, date) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            Date dateSql = Date.valueOf(event.getDate());
            st.setString(1, event.getName());
            st.setDouble(2, event.getPrice());
            st.setString(3, event.getDescription());
            st.setDate(4, dateSql);

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

    @Override
    public List<Event> getAllEvents() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,description,date FROM events";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Event> events = new LinkedList<>();
            while (rs.next()) {
                Event event = new Event(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getDate("date").toLocalDate());

                events.add(event);
            }

            return events;
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
