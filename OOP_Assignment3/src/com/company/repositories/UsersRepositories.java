package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UsersRepositories {
    private final IDB db;
    public UsersRepositories(IDB db){this.db = db;}

    public boolean CreateUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO tbl_users(name,surname,balance,login,password) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            ResultSet keys = st.getGeneratedKeys();
            int id = keys.getInt(1);
            user.setId(id);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setDouble(3, user.getBalance());
            st.setString(4, user.getLogin());
            st.setString(5, user.getPassword());

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
    public boolean ValidUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id FROM tbl_users WHERE login ="+user.getLogin()  + "AND"+user.getPassword();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            user.setId(rs.getInt("id"));
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


    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,login,password,name,surname,balance FROM tbl_users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getDouble("balance"));

                users.add(user);
            }

            return users;
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
