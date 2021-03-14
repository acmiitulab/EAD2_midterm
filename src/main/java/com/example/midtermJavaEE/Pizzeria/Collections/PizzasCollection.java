package com.example.midtermJavaEE.Pizzeria.Collections;


import com.example.midtermJavaEE.Pizzeria.Models.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PizzasCollection {

    private static String url = "jdbc:mysql://localhost:3306/EADmidterm?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    private Connection conn;

    public PizzasCollection() {
        System.out.println("Init databasecon");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public ArrayList<Pizza> getPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT * FROM pizzas";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                Double price = resultSet.getDouble(2);
                Pizza pizza = new Pizza(name, price);
                pizzas.add(pizza);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return pizzas;
    }



    public Pizza getPizza(String name) {
        Pizza pizza = null;
        String sql = "SELECT * FROM pizzas WHERE name = ?";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString(1);
                Double price = resultSet.getDouble(2);
                pizza = new Pizza(name, price);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return pizza;
    }

    public int insert(Pizza pizza) {
        String sql = "INSERT INTO pizzas (name, price) Values (?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setDouble(2, pizza.getPrice());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return 0;
    }

    public int update(Pizza pizza) {
        String sql = "UPDATE pizzas SET price = ?  WHERE name = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, pizza.getName());
            preparedStatement.setDouble(1, pizza.getPrice());
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

}