import java.awt.*;
import  java.awt.event.*;

public class Pages {
    public void logIn() {
        Frame window = new Frame();
        Panel usernamePnl = new Panel();
        Panel passwordPnl = new Panel();
        Panel buttonPnl = new Panel();

        Label usernameLbl, passwordLbl;
        TextField usernameTxt;
        Button loginBtn, createAccountBtn;
        TextField passwordTxt;

        usernameLbl = new Label("Account Number: ");
        passwordLbl = new Label("Password: ");
        usernameTxt = new TextField(30);
        passwordTxt = new TextField(30);
        loginBtn = new Button("Login");
        createAccountBtn = new Button("Create Account");

        GridLayout layout = new GridLayout(3,1);

        window.add(usernamePnl);
        window.add(passwordPnl);
        window.add(buttonPnl);
        usernamePnl.add(usernameLbl);
        usernamePnl.add(usernameTxt);
        passwordPnl.add(passwordLbl);
        passwordPnl.add(passwordTxt);
        buttonPnl.add(loginBtn);
        buttonPnl.add(createAccountBtn);

        window.setLayout(layout);
        window.setSize(600, 600);
        window.setVisible(true);

        login l = new login(usernameTxt, passwordTxt);
        loginBtn.addActionListener(l);

        event e = new event(window);
        createAccountBtn.addActionListener(e);

        loginBtn.addActionListener(e);

    }

    public void homePage() {
        Frame window = new Frame();
        Button depositBtn, withdrawBtn, checkBtn, statementBtn;
        TextField loggedInDetailsTxt;

        depositBtn = new Button("Deposit");
        withdrawBtn= new Button("Withdraw");
        checkBtn = new Button("Check Amount");
        statementBtn = new Button("View Statement");
        loggedInDetailsTxt = new TextField("Welcome: Dan Higgins! (this is placeholder text)");

        window.addWindowListener (
            new WindowAdapter(){
                public  void windowClosing(WindowEvent t){
                    System.exit(0);
                }
                public void windowIconified(WindowEvent t){
                }
            }
        );

        GridLayout layout = new GridLayout(5,1);

        window.add(loggedInDetailsTxt);
        window.add(depositBtn);
        window.add(withdrawBtn);
        window.add(checkBtn);
        window.add(statementBtn);

        window.setLayout(layout);
        window.setSize(600, 600);
        window.setVisible(true);

        event e = new event(window);

        depositBtn.addActionListener(e);
        withdrawBtn.addActionListener(e);
        checkBtn.addActionListener(e);
        statementBtn.addActionListener(e);
    }

    public void createUser() {
        Frame window = new Frame();
        Label forenameLbl, surnameLbl, addressLbl, passwordLbl;
        TextField forenameTxt, surnameTxt, addressTxt, passwordTxt;
        Button submitBtn;

        forenameLbl = new Label("Forename: ");
        forenameTxt = new TextField();
        surnameLbl = new Label("Surname: ");
        surnameTxt = new TextField();
        addressLbl = new Label("Address: ");
        addressTxt = new TextField();
        passwordLbl = new Label("Password: ");
        passwordTxt = new TextField();
        submitBtn = new Button("Submit");

        GridLayout layout = new GridLayout(5,2);

        window.add(forenameLbl);
        window.add(forenameTxt);
        window.add(surnameLbl);
        window.add(surnameTxt);
        window.add(addressLbl);
        window.add(addressTxt);
        window.add(passwordLbl);
        window.add(passwordTxt);
        window.add(submitBtn);

        window.setLayout(layout);
        window.setSize(600, 600);
        window.setVisible(true);

        createUser c = new createUser(forenameTxt, surnameTxt, addressTxt);
        submitBtn.addActionListener(c);
    }

    public void deposit() {
        Frame window = new Frame();
        Button submitDepositBtn, backBtn;
        Label amountLbl, accountNumLbl;
        TextField depositAmountTxt, accountNumTxt;

        amountLbl = new Label("Deposit Amount: ");
        depositAmountTxt = new TextField();
        accountNumLbl = new Label("Account Number: ");
        accountNumTxt = new TextField();
        submitDepositBtn = new Button("Submit");
        backBtn = new Button("Back");

        GridLayout layout = new GridLayout(3,2);

        window.add(accountNumLbl);
        window.add(accountNumTxt);
        window.add(amountLbl);
        window.add(depositAmountTxt);
        window.add(backBtn);
        window.add(submitDepositBtn);

        window.setLayout(layout);
        window.setSize(600, 600);
        window.setVisible(true);

        depositAction d = new depositAction(depositAmountTxt, accountNumTxt);
        submitDepositBtn.addActionListener(d);

        back b = new back(window);
        backBtn.addActionListener(b);
    }

    public void withdraw() {
        Frame window = new Frame();
        Button submitWithdrawBtn, backBtn;
        Label withdrawAmountLbl, accountNumLbl;
        TextField withdrawAmountTxt, accountNumTxt;


        submitWithdrawBtn = new Button("Submit");
        backBtn = new Button("Back");
        withdrawAmountLbl = new Label("Withdraw Amount: ");
        withdrawAmountTxt = new TextField();
        accountNumLbl = new Label("Account Number: ");
        accountNumTxt = new TextField();

        GridLayout layout = new GridLayout(3, 2);

        window.add(accountNumLbl);
        window.add(accountNumTxt);
        window.add(withdrawAmountLbl);
        window.add(withdrawAmountTxt);
        window.add(backBtn);
        window.add(submitWithdrawBtn);

        window.setLayout(layout);
        window.setSize(600,600);
        window.setVisible(true);

        withdrawAction w = new withdrawAction(withdrawAmountTxt, accountNumTxt);
        submitWithdrawBtn.addActionListener(w);

        back b = new back(window);
        backBtn.addActionListener(b);
    }

    public void checkAmount() {
        Frame window = new Frame();
        Button submitCheck, backBtn;
        Label amountLbl, accountNumLbl;
        TextField amountTxt, accountNumTxt;

        submitCheck = new Button("Submit");
        amountLbl= new Label("Balance: ");
        amountTxt = new TextField();
        accountNumLbl = new Label("Account Number: ");
        accountNumTxt = new TextField();
        backBtn = new Button("Back");

        GridLayout layout = new GridLayout(3,2);

        window.add(accountNumLbl);
        window.add(accountNumTxt);
        window.add(amountLbl);
        window.add(amountTxt);
        window.add(backBtn);
        window.add(submitCheck);

        window.setLayout(layout);
        window.setSize(600, 600);
        window.setVisible(true);

        checkAccountAction check = new checkAccountAction(accountNumTxt, amountTxt);
        submitCheck.addActionListener(check);

        back b = new back(window);
        backBtn.addActionListener(b);
    }

    public void bankStatement() {
        Frame window = new Frame();
        Panel panel = new Panel();
        TextField accountTxt;
        TextArea statementTxt;
        Label statementLbl, accountLbl;
        Button bankStatementCheckBtn, backBtn;

        accountLbl = new Label("Account Number:");
        accountTxt = new TextField(30);
        statementTxt = new TextArea();
        statementLbl = new Label("Statement:");
        bankStatementCheckBtn = new Button("View Statement");
        backBtn = new Button("Back");

        GridLayout layout = new GridLayout(4, 1);

        window.add(panel);
        panel.add(accountLbl);
        panel.add(accountTxt);
        panel.add(bankStatementCheckBtn);

        window.add(statementLbl);
        window.add(statementTxt);
        window.add(backBtn);
        window.setLayout(layout);
        window.setSize(600,600);
        window.setVisible(true);

        getStatement g = new getStatement(accountTxt, statementTxt);
        bankStatementCheckBtn.addActionListener(g);

        back b = new back(window);
        backBtn.addActionListener(b);
    }

}