/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class TicketCategory implements Menu{
    private String name;
    private char type;
    private double price;

    public TicketCategory(String name, char type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public TicketCategory() {
        
    }

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    
    public void displayMenu(){
        System.out.println("\n-------------------------");
        System.out.println(" Select ticket category"  );
        System.out.println("---------------------------");
        System.out.println("1. Adult   | (+RM 10) ");
        System.out.println("2. Child   |     -    ");
        System.out.println("-------------------------");
        System.out.print(" Enter (1-2): ");
    }
    
    public int inputChoice(int max){
        Scanner sc = new Scanner(System.in);
        int num;
        do{
            num = 0;
            num = sc.nextInt();
            sc.nextLine();
            if(!(num >= 1 && num <= max)){
                System.out.println("Invalid choice, Please try again");
                System.out.print(" Enter (1-" + max +"): ");
            }
        }while(!(num >= 1 && num <= max));
        
        return num;
    }
    
}
