/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class Customer extends User{
    private String customerID;

    public Customer(String customerID, String name, String email, String contactNo, Account acc) {
        super(name, email, contactNo, acc);
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    } 
    


    //customer class
    @Override
    public String toString() {
        return "Customer ID = " + customerID + "\n" + super.toString();
    }


}
