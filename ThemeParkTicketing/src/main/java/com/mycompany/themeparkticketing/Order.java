/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;
import java.time.LocalDate; 
/**
 *
 * @author Lenovo
 */
public class Order {
    public static int orderNo = 100000;
    private int qty;
    private LocalDate OrderDate;
    private OrderStatus status;
    private double amount;
    Payment payment;

    public Order(int qty, LocalDate OrderDate, OrderStatus status, double amount, Payment payment) {
        this.qty = qty;
        this.OrderDate = OrderDate;
        this.status = status;
        this.amount = amount;
        this.payment = payment;
        orderNo++;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setOrderDate(LocalDate OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
   
    
    
   private void addTicket(){
       
   }
   
   private void checkout(){
       
   }
   
   private void discount(){
       
   }
}
