package com.example.midtermJavaEE.Pizzeria.Collections;

import com.example.midtermJavaEE.Pizzeria.Models.Message;
import com.example.midtermJavaEE.Pizzeria.Models.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Messages {

    private static String url = "jdbc:mysql://localhost:3306/EADmidterm?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    private Connection conn;

    public Messages() {
        System.out.println("Init databasecon");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Message> getMessages() {
        ArrayList<Message> messages = new ArrayList<>();

        String sql = "SELECT * FROM message";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String message = resultSet.getString(2);
                String author = resultSet.getString(3);
                messages.add(new Message(id, message, author));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return messages;
    }

    public Message getMessage(int id) {

        Message message = null;

        String sql = "SELECT * FROM message WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
                String text = resultSet.getString(2);
                String author = resultSet.getString(3);
                int likes = resultSet.getInt(4);
                message = new Message(id, text, author);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return message;

    }


    public int insert(Message message) {

        String sql = "INSERT INTO message (message, author) Values (?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, message.getMessage());
            preparedStatement.setString(2, message.getAuthor());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;

    }

    public int update(Message message) {

        String sql = "UPDATE message SET message = ?, author = ?  WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, message.getMessage());
            preparedStatement.setString(2, message.getAuthor());
            preparedStatement.setInt(3, message.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

}
