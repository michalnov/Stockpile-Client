package sk.akademiasovy.stockpile;

import sk.akademiasovy.stockpile.objects.*;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static Stockunits stockunits = new Stockunits();
    static String tokenfinal = "";
    static JComboBox comboBox = new JComboBox();
    public static void main(String[] args) {
        Communication communication = new Communication();

        StockFilter filter = new StockFilter();
        final
        StockManipulator manipulator = new StockManipulator();

        JFrame maiFrame=new JFrame("Stock Management");
        maiFrame.setSize(600,350);

        // CREATE elements

        JButton insertButton = new JButton("Insert");
        JButton removeButton = new JButton("Withdraw");
        JButton searchNameButton = new JButton("Search");
        JButton searchRecipientButton = new JButton("Search");

        JLabel errorLabel = new JLabel("");
        errorLabel.setBounds(250,55,200,20);
        maiFrame.add(errorLabel);

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
        loginButton.addActionListener(e -> {
            String username = usernaeField.getText();
            String password = passwordField.getText();
            if (username.equals("") || password.equals("")){
                return;
            } else {
                loginButton.disable();
                tokenfinal = communication.loginHandler(username,password);
                System.out.println(tokenfinal);
                if (tokenfinal.equals("")){
                    loginButton.enable();
                    errorLabel.setText("Communication error");
                } else {
                    stockunits = communication.getUpdate(tokenfinal) ;
                    loginButton.disable();
                    insertButton.enable();
                    removeButton.enable();
                    searchNameButton.enable();
                    searchRecipientButton.enable();
                    errorLabel.setText("");

                }
            }
        });
        maiFrame.add(loginButton);

        JLabel lableremoveQuantity = new JLabel("Quantity:");
        JTextField removeQuantity = new JTextField();
        JLabel lableremoveOrigin = new JLabel("origin:");
        JTextField removeOrigin = new JTextField();
        JLabel lableremoveRecipient = new JLabel("ecipient:");
        JTextField removeRecipient = new JTextField();

        JTextField newinsertName = new JTextField();
        newinsertName.setBounds(20,100,150,20);
        maiFrame.add(newinsertName);

        JLabel lableInsertName = new JLabel("New item name:");
        lableInsertName.setBounds(20,80,150,20);
        maiFrame.add(lableInsertName);

        JTextField newinsertRecipient = new JTextField();
        newinsertRecipient.setBounds(20,145,150,20);
        maiFrame.add(newinsertRecipient);

        JLabel lableInsertRecipient = new JLabel("New item recipient:");
        lableInsertRecipient.setBounds(20,125,150,20);
        maiFrame.add(lableInsertRecipient);

        JTextField newinsertOrigin = new JTextField();
        newinsertOrigin.setBounds(20,185,150,20);
        maiFrame.add(newinsertOrigin);

        JLabel lableInsertOrigin = new JLabel("New item origin:");
        lableInsertOrigin.setBounds(20,165,150,20);
        maiFrame.add(lableInsertOrigin);

        JTextField newinsertQuantity = new JTextField();
        newinsertQuantity.setBounds(20,225,150,20);
        maiFrame.add(newinsertQuantity);

        JLabel lableInsertQuantity = new JLabel("New item Quantity:");
        lableInsertQuantity.setBounds(20,205,150,20);
        maiFrame.add(lableInsertQuantity);


        insertButton.setBounds(50,250,80,20);
        insertButton.addActionListener(e -> {
            StockUnit newSwap = new StockUnit();
            newSwap.setName(newinsertName.getText().trim());
            newSwap.setRecipient(newinsertRecipient.getText().trim());
            newSwap.setOrigin(newinsertOrigin.getText().trim());
            newSwap.setQuantity(newinsertQuantity.getText().trim());
            if (communication.insertItem(newSwap,tokenfinal)){
                errorLabel.setText("");
                newinsertName.setText("");
                newinsertOrigin.setText("");
                newinsertQuantity.setText("");
                newinsertRecipient.setText("");

            } else {
                errorLabel.setText("Communication error");
            }
        });
        insertButton.disable();
        maiFrame.add(insertButton);

        JButton remove = new JButton("Remove");
        remove.enable(false);


        JTextField searchName = new JTextField();
        searchName.setBounds(300,100,150,20);
        maiFrame.add(searchName);

        JLabel lableSearchName = new JLabel("Search by name:");
        lableSearchName.setBounds(300,80,150,20);
        maiFrame.add(lableSearchName);

        searchNameButton.setBounds(455,100,100,20);
        searchNameButton.addActionListener(e -> {
            StockUnit found = filter.findByname(stockunits,searchName.getText().trim());
            removeOrigin.setText(found.getOrigin());
            removeQuantity.setText(found.getQuantity());
            removeRecipient.setText(found.getRecipient());
            remove.enable(true);
        });
        maiFrame.add(searchNameButton);



        //comboBox.setBounds(200,150,300,22);


        removeRecipient.setBounds(300,145,150,20);
        removeRecipient.disable();
        maiFrame.add(removeRecipient);


        lableremoveRecipient.setBounds(300,125,150,20);
        maiFrame.add(lableremoveRecipient);


        removeOrigin.disable();
        removeOrigin.setBounds(300,185,150,20);
        maiFrame.add(removeOrigin);


        lableremoveOrigin.setBounds(300,165,150,20);
        maiFrame.add(lableremoveOrigin);


        removeQuantity.disable();
        removeQuantity.setBounds(300,225,150,20);
        maiFrame.add(removeQuantity);


        lableremoveQuantity.setBounds(300,205,150,20);
        maiFrame.add(lableremoveQuantity);

        remove.setBounds(300,250,100,20);
        remove.addActionListener(e -> {
            communication.withdrawItem(filter.findByname(stockunits,searchName.getText().trim()),tokenfinal);
            searchName.setText("");
            removeOrigin.setText("");
            removeQuantity.setText("");
            removeRecipient.setText("");
        });
        maiFrame.add(remove);





        //END
        maiFrame.setLayout(null);
        maiFrame.setVisible(true);
    }
}
