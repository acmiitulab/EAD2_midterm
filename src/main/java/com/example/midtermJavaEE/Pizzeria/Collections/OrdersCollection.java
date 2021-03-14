package com.example.midtermJavaEE.Pizzeria.Collections;

import com.example.midtermJavaEE.Pizzeria.Models.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersCollection {

    private static String url = "jdbc:mysql://localhost:3306/EADmidterm?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    private Connection conn;
    private Pizzas_toOrder pizzas_toOrder;

    public OrdersCollection() {
        pizzas_toOrder = new Pizzas_toOrder();
        System.out.println("Init databasecon");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Boolean isDone = resultSet.getBoolean(4);
                ArrayList<String> pizzas;
                pizzas = pizzas_toOrder.getPizzasInOrder(id, conn);
                Order order = new Order(id, username, pizzas, price);
                order.setDone(isDone);
                orders.add(order);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return orders;
    }

    public ArrayList<Order> getOrdersByUsername(String username) {

        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders where username = ?";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                 username = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Boolean isDone = resultSet.getBoolean(4);
                ArrayList<String> pizzas;
                pizzas = pizzas_toOrder.getPizzasInOrder(id, conn);
                Order order = new Order(id, username, pizzas, price);
                System.out.println(order.getPizzas());
                order.setDone(isDone);
                orders.add(order);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return orders;

    }



    public Order getOrderByID(Integer id) {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Boolean isDone = resultSet.getBoolean(4);
                ArrayList<String> pizzas;
                pizzas = pizzas_toOrder.getPizzasInOrder(id, conn);
                order = new Order(id, username, pizzas, price);
                order.setDone(isDone);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return order;
    }


    public int insert(Order order) {
        String sql = "INSERT INTO orders (username, price, isdone) Values (?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, order.getUsername());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setBoolean(3, order.isDone());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public void insertPizzas(Order order) {
        pizzas_toOrder.insert(order, conn);
    }

    public int doOrder(Order order) {
        String sql = "UPDATE orders SET isdone = ?  WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, order.getId());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

}