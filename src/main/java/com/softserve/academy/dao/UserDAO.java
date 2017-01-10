package com.softserve.academy.dao;

import com.softserve.academy.factory.ConnectionFactory;
import com.softserve.academy.factory.ConnectionType;
import com.softserve.academy.model.User;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    Connection connect = ConnectionFactory.getDBConnection(ConnectionType.SIMPLE_CONNECTION);

    public void addUser(User user) {

        try {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO user(login, password, createDate) VALUES (?, ?, ?)");
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setTimestamp(3, new Timestamp(user.getCreateDate().getTime()));
            int rowCount = pstmt.executeUpdate();

            System.out.println(rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {

        User user = null;
        try {
            PreparedStatement pstmt = connect.prepareStatement("SELECT id, login, password, createDate FROM user WHERE id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateDate(rs.getTimestamp(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(int id, User user) {

        try {
            PreparedStatement pstmt = connect.prepareStatement("UPDATE user SET login = ?, password = ?, createDate = ? WHERE id = ?");
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setTimestamp(3, user.getCreateDate());
            pstmt.setInt(4, id);

            int rowCount = pstmt.executeUpdate();

            System.out.println(rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        try {
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM user WHERE id = ?");
            pstmt.setInt(1, id);

            int rowCount = pstmt.executeUpdate();

            System.out.println(rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {

        List<User> users = null;
        User user = null;

        try {
            PreparedStatement pstmt = connect.prepareStatement("SELECT id, login, password, createDate FROM user");
            ResultSet rs = pstmt.executeQuery();

            if (!rs.wasNull()) {
                users = new ArrayList<>();
            }

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateDate(rs.getTimestamp(4));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

