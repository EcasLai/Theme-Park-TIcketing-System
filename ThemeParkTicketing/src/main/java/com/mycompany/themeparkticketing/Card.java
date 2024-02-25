/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class Card extends Payment{
    private String cardType;
    private String cardNo;
    private double cardBalance;

    public Card(String cardType, String cardNo, double amount, PaymentStatus status) {
        super(status);
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.cardBalance = amount;
    }

    public String getCardType() {
        return cardType;
    }

    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }
    

    @Override
    public void pay() {
        cardBalance = cardBalance - 10;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\n------------------------------------------------------------\nCard" + 
               "\nCardType       : " + cardType + 
               "\nCard No        : " + cardNo + 
               "\nCardBalance    : RM " + String.format("%.2f", cardBalance) +
               "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    }

}
