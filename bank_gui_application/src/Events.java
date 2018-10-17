import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//First action listener to open new frames based on click
class event implements ActionListener {
    Pages p = new Pages();
    Frame homePage;
    TextField loggedInDetails;

    public event(Frame window) {
        homePage = window;
//        loggedInDetails = loggedInDetailsTxt;
    }

    public void actionPerformed(ActionEvent x) {
        Button btn;
        btn = (Button)x.getSource();
        String buttonLabel = btn.getLabel();

        if (buttonLabel.equals("Create Account")) {
            homePage.setVisible(false);
            p.createUser();
        } else if (buttonLabel.equals("Deposit")) {
            homePage.setVisible(false);
            p.deposit();
        } else if (buttonLabel.equals("Withdraw")) {
            homePage.setVisible(false);
            p.withdraw();
        } else if (buttonLabel.equals("Check Amount")) {
            homePage.setVisible(false);
            p.checkAmount();
        } else if (buttonLabel.equals("View Statement")) {
            homePage.setVisible(false);
            p.bankStatement();
        } else if (buttonLabel.equals("Login")) {
            homePage.setVisible(false);
        }
    }
}

//Second action listener used to create student account
class createUser implements ActionListener {
    TextField forenameTxt, surnameTxt, addressTxt;

    public createUser(TextField forename, TextField surname, TextField address) {
        forenameTxt = forename;
        surnameTxt = surname;
        addressTxt = address;
    }

    public void actionPerformed(ActionEvent x) {
        String forename = null, surname = null, address = null;

        forename = forenameTxt.getText();
        surname = surnameTxt.getText();
        address = addressTxt.getText();

        String query = "insert into Account values(null,'" + forename + "','" + surname +"','"+ address +"')";

        try {
            Database.stmt.executeUpdate(query);
        } catch(Exception E){
            System.out.println(E.toString());
        }
    }
}

//Third action listener used to deposit money
class depositAction implements ActionListener {
    TextField depositAmountTxt, accountNumTxt;

    public depositAction(TextField depositAmount, TextField accountNum) {
        depositAmountTxt = depositAmount;
        accountNumTxt = accountNum;
    }

    public void actionPerformed(ActionEvent x) {
        String depositAmount = null, accountNum = null, date = null;

        depositAmount = depositAmountTxt.getText();
        accountNum = accountNumTxt.getText();

        String query = "insert into Deposit values('"+ accountNum + "','" + depositAmount +"',now())";

        try {
            Database.stmt.executeUpdate(query);
        } catch(Exception E){
            System.out.println(E.toString());
        }

        depositAmountTxt.setText("");
        accountNumTxt.setText("");
    }
}

//Fourth action listener used to withdraw money
class withdrawAction implements ActionListener {
    TextField withdrawAmountTxt, accountNumTxt;

    public withdrawAction(TextField depositAmount, TextField accountNum) {
        withdrawAmountTxt = depositAmount;
        accountNumTxt = accountNum;
    }

    public void actionPerformed(ActionEvent x) {
        String withdrawAmount = null, accountNum = null;

        withdrawAmount = withdrawAmountTxt.getText();
        accountNum = accountNumTxt.getText();

        String query = "insert into Withdraw values('"+ accountNum + "','" + withdrawAmount +"',now())";

        try {
            Database.stmt.executeUpdate(query);
        } catch(Exception E){
            System.out.println(E.toString());
        }

        withdrawAmountTxt.setText("");
        accountNumTxt.setText("");
    }
}

//Fifth action listener used to check balance
class checkAccountAction implements ActionListener {
    TextField accountNumTxt, amountTxt;

    public checkAccountAction(TextField accountNum, TextField amount) {
        accountNumTxt = accountNum;
        amountTxt = amount;
    }

    public void actionPerformed(ActionEvent x) {
        String accountNum = null, stringAmount = null;
        int totalDeposit = 0;
        int totalWithdraw = 0;
        int balance = 0;

        accountNum = accountNumTxt.getText();

        String query = "select sum(DepositAmount) as Total from Deposit where AccountNumber="+accountNum;
        String query2 = "select sum(WithdrawAmount) as Total from Withdraw where AccountNumber="+accountNum;

        try {
            ResultSet rs = Database.stmt.executeQuery(query);
            rs.next();
            totalDeposit = rs.getInt("Total");

            rs = Database.stmt.executeQuery(query2);
            rs.next();
            totalWithdraw = rs.getInt("Total");

            balance = totalDeposit - totalWithdraw;

            stringAmount = Integer.toString(balance);
            amountTxt.setText(stringAmount);

        } catch(Exception E){
            System.out.println(E.toString());
        }
    }
}

//Sixth action listener used to create student account
class back implements ActionListener {
    Pages p = new Pages();
    Frame currentPage;

    public back(Frame window) {
        currentPage = window;
    }

    public void actionPerformed(ActionEvent x) {
        Button btn;
        btn = (Button)x.getSource();
        String buttonLabel = btn.getLabel();

        currentPage.setVisible(false);
        p.homePage();
    }
}

//Sixth action listener used to create user account
class login implements ActionListener {
    TextField usernameTxt;
    TextField passwordTxt;
    String accountNumber;
    String accountPass;
    Pages p = new Pages();

    public login(TextField username, TextField password) {
        usernameTxt = username;
        passwordTxt = password;
    }

    public void actionPerformed(ActionEvent x) {
        String username = null, password = null;

        username = usernameTxt.getText();
        password = passwordTxt.getText();

        String query = "select AccountNumber, Password from Account where AccountNumber="+ username;

        try {
            ResultSet rs = Database.stmt.executeQuery(query);
            rs.next();
            accountNumber = rs.getString("AccountNumber");
            accountPass = rs.getString("Password");

            if (username.equals(accountNumber) && password.equals(accountPass)) {
                p.homePage();
            } else {
            }
        } catch(Exception E){
            System.out.println(E.toString());
        }
    }

    public String usernameReturn() {
        return accountNumber;
    }
}

class getStatement implements ActionListener {
    TextField accountTxt;
    TextArea statementTxt;
    String forenameFill;
    String surnameFill;
    String addressFill;
    String withdrawAmount;
    String withdrawDate;
    String depositAmount;
    String depositDate;

    public getStatement(TextField account, TextArea statement) {
        accountTxt = account;
        statementTxt = statement;
    }

    public void actionPerformed(ActionEvent e) {
        String account, name, statement;

        account = accountTxt.getText();
        statement = statementTxt.getText();

        String query = "select Forename, Surname, Address from Account where AccountNumber="+ account;
        String allWithdraw = "select WithdrawAmount, WithdrawDate from Withdraw where AccountNumber="+ account + " order by WithdrawAmount";
        String allDeposit = "select DepositAmount, DepositDate from Deposit where AccountNumber="+ account + " order by DepositAmount";
//        String all = "select AccountNumber as AccountNumber, DepositAmount as Amount, DepositDate as Date from (select * from Deposit union select * from Withdraw) as Total where AccountNumber="+ account + " order by 3";

        try {
            statementTxt.setText("");
            //Outputs user details
            ResultSet rs = Database.stmt.executeQuery(query);
            rs.next();
            forenameFill = rs.getString("Forename");
            surnameFill = rs.getString("Surname");
            addressFill = rs.getString("Address");
            statementTxt.setText("Name: " + forenameFill + " " + surnameFill + "\n" + "Address: " + addressFill + "\n\n");

            //Display all withdraws
            rs = Database.stmt.executeQuery(allWithdraw);

            while (rs.next()) {
                withdrawDate = rs.getString("WithdrawDate");
                withdrawAmount = rs.getString("WithdrawAmount");
                statementTxt.setText(statementTxt.getText()+"Withdraw Amount: " + withdrawAmount + ", Withdraw Date: " + withdrawDate + "\n");
            }

            //Display all deposits
            rs = Database.stmt.executeQuery(allDeposit);

            while (rs.next()) {
                depositDate = rs.getString("DepositDate");
                depositAmount = rs.getString("DepositAmount");
                statementTxt.setText(statementTxt.getText()+"Deposit Amount: " + depositAmount + ", Deposit Date: " + depositDate + "\n");
            }

        } catch(Exception E){
            System.out.println(E.toString());
        }
    }
}
