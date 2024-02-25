/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private String contactNo;
    private Account acc;

    public User() {
    }

    public User(String name, String email, String contactNo, Account acc) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.acc = acc;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Account getAcc() {
        return acc;
    }


    // User class
    @Override
    public String toString() {
        return "User name = " + name + "\nEmail = " + email + "\nContact No = " + contactNo + "\nAccount = " + acc;
    }
    
}

