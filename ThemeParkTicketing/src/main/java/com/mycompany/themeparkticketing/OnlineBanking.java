/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class OnlineBanking extends Payment{
    private String bankName;
    private double bankBalance;

    public OnlineBanking(String bankName, double bankBalance, PaymentStatus status) {
        super(status);
        this.bankName = bankName;
        this.bankBalance = bankBalance;
    }

    
    
    
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    
    
    
    
    
    @Override
    public void pay() {
        bankBalance = bankBalance - 10;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\n------------------------------------------------------------\nOnlineBanking" + 
               "\nBank Name      : " + bankName + 
               "\nBank Balance   : RM " + String.format("%.2f", bankBalance) + 
               "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"; 
    }
  
}
