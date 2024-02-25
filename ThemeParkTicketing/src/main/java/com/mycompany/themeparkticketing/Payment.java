/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public abstract class Payment {
    private static int paymentID = 1000;
    PaymentStatus status;
    
    LocalDateTime myDateObj = LocalDateTime.now();  
    DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
    DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatDate); 
    String formattedTime = myDateObj.format(myFormatTime); 

    
    
    public Payment(PaymentStatus status) {
        this.status = status;
        paymentID++;
    }

    public static int getPaymentID() {
        return paymentID;
    }

    

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    
    
    public abstract void pay();

    
    
    
    @Override
    public String toString() {
        return "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\nPayment " + 
               "\nPayment ID     : " + paymentID + 
               "\nPayment Status : " + status + 
               "\nDate           : " + formattedDate + 
               "\nTime           : " + formattedTime +
               "\nGrand Total    : RM " + 10;
    }
    
}
