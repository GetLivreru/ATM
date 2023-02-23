package basic.atm;

import java.sql.*;


public class Operation {
    private String cardNumber;

    private String pincode;

    private Integer balance;

    Operation(String cardNumber, String pincode) {
        this.cardNumber = cardNumber;
        this.pincode = pincode;
    }
