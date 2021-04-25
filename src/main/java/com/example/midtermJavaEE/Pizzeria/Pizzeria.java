package com.example.midtermJavaEE.Pizzeria;

import com.example.midtermJavaEE.Pizzeria.Collections.OrdersCollection;
import com.example.midtermJavaEE.Pizzeria.Collections.PizzasCollection;
import com.example.midtermJavaEE.Pizzeria.Collections.Token;
import com.example.midtermJavaEE.Pizzeria.Collections.UsersCollection;
import com.example.midtermJavaEE.Pizzeria.Collections.Messages;
import com.example.midtermJavaEE.Pizzeria.Models.Message;
import com.example.midtermJavaEE.Pizzeria.Models.Order;
import com.example.midtermJavaEE.Pizzeria.Models.Pizza;
import com.example.midtermJavaEE.Pizzeria.Models.User;

import java.util.ArrayList;

public class Pizzeria {

    private OrdersCollection ordersCollection;
    private PizzasCollection pizzasCollection;
    private UsersCollection usersCollection;
    private Messages messages;
    private Token token;
    private User user;

    public Pizzeria() {
        this.messages = new Messages();
        this.ordersCollection = new OrdersCollection();
        this.pizzasCollection = new PizzasCollection();
        this.usersCollection = new UsersCollection();
        this.token = new Token();
    }

    public void login(String username, String password) {
        User user = usersCollection.getUser(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                this.user = user;
            }
        }
    }

    public void auth(int token) {
        String username = this.token.getToken(token);
        if (username != null) {
            this.user = usersCollection.getUser(username);
        }
    }

    public int createToken(String username) {
        Integer token = this.token.getTokens();
        this.token.insert(token, username);
        return token;
    }

    public String MakeOrder(ArrayList<String> pizzas) {
        if (user == null) {
            return "You didn't auth";
        }
        Double price = 0.0;
        for (String i : pizzas) {
            Pizza pizza = pizzasCollection.getPizza(i);
            price += pizza.getPrice();
        }
        Order order = new Order(this.user.getUsername(), pizzas, price);
        ordersCollection.insert(order);
        ArrayList<Order> orders = ordersCollection.getOrdersByUsername(order.getUsername());
        int id = orders.get(orders.size()-1).getId();
        order.setId(id);

        ordersCollection.insertPizzas(order);

        return "Done";
    }

    public String doOrder()  {
        if (user == null) {
            return "You didn't auth";
        }
        if (!user.isAdmin()) {
            return "You are not admin";
        }
        ArrayList<Order> orders = ordersCollection.getOrders();
        for (Order i : orders) {
            if (i.isDone()) continue;
            else {
                ordersCollection.doOrder(i);
                return "Order" + i.getId() + " is done!";
            }
        }
        return "No orders!";
    }

    public void writeMessage (String text) {
        if (user != null) messages.insert(new Message(0, text, user.getUsername()));
    }

    public ArrayList<Message> getMessages () {
        return messages.getMessages();
    }

    public User getUser() {
        return user;
    }

    public OrdersCollection getOrdersCollection() {
        return ordersCollection;
    }

    public PizzasCollection getPizzasCollection() {
        return pizzasCollection;
    }

    public UsersCollection getUsersCollection() {
        return usersCollection;
    }

    public Token getToken() {
        return token;
    }
}

















