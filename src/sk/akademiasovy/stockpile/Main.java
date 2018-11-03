package sk.akademiasovy.stockpile;

import okhttp3.*;
import sk.akademiasovy.stockpile.objects.Communication;
import sk.akademiasovy.stockpile.objects.StockFilter;
import sk.akademiasovy.stockpile.objects.StockList;
import sk.akademiasovy.stockpile.objects.StockManipulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        Communication communication = new Communication();
        StockList stockList = new StockList();
        StockFilter filter = new StockFilter();
        StockManipulator manipulator = new StockManipulator();

        JFrame maiFrame=new JFrame("Password Field Example");
        maiFrame.setSize(600,600);

        // CREATE elements

        JTextField usernaeField = new JTextField();
        usernaeField.setBounds(100,20,100,20);
        maiFrame.add(usernaeField);

        JLabel lableUsername = new JLabel("Username");
        lableUsername.setBounds(20,20,80,20);
        maiFrame.add(lableUsername);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(300,20,100,20);
        maiFrame.add(passwordField);

        JLabel labelPassword=new JLabel("Password:");
        labelPassword.setBounds(220,20, 80,20);
        maiFrame.add(labelPassword);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(410,20,80,20);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernaeField.getText();
                String password = passwordField.getText();
                if (username.equals("") || password.equals("")){
                    return;
                } else {
                    loginButton.disable();
                    String token = communication.loginHandler(username,password);
                    if (token.equals("")){
                        loginButton.enable();
                    } else {

                    }
                }
            }
        });
        maiFrame.add(loginButton);

        


        //END
        maiFrame.setLayout(null);
        maiFrame.setVisible(true);
    }
}
