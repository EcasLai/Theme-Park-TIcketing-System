/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class Ewallet extends Payment{
    private String eWalletType;
    private double eWalletBalance;

    public Ewallet(String eWalletType, double eWalletBalance, PaymentStatus status) {
        super(status);
        this.eWalletType = eWalletType;
        this.eWalletBalance = eWalletBalance;
    }

    
    public String geteWalletType() {
        return eWalletType;
    }

    public void seteWalletType(String eWalletType) {
        this.eWalletType = eWalletType;
    }
    

    public double geteWalletBalance() {
        return eWalletBalance;
    }

    public void seteWalletBalance(double eWalletBalance) {
        this.eWalletBalance = eWalletBalance;
    }

    

    
    
    @Override
    public void pay() {
        eWalletBalance = eWalletBalance - 10;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\n------------------------------------------------------------\nEWallet" + 
               "\nEWalletType    : " + eWalletType + 
               "\nEWalletBalance : RM " + String.format("%.2f", eWalletBalance) + 
               "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    }
    
}

