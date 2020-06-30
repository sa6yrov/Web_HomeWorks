package com.Classwork55.dao;

import com.Classwork55.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDb {
    public boolean addUser(User user){
        String SQL = "insert into users (name, password, date_created) values(?,?, now()) ";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        String SQL = "select * from users";
        try(Connection conn = DbConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)){
                while (rs.next()){
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getTimestamp("created_date")
                    );
                    userList.add(user);
                }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return userList;
    }

    public User getUserById(Integer id){
        String SQL = "select * from users where id = ?";
        User user = null;
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()) user = new User(
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getTimestamp("created_date")
                );
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return user;
    }

    public boolean deleteUser(Integer id){
        String SQL = "delete from users where id = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean updateUser(Integer id, String name, String password){
        String SQL = "update users set name = ?, password = ? where id = ?";
        try(Connection conn = DbConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
}
