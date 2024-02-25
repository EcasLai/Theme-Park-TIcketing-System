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
public class Ticket implements Menu{
    private static int cur_TicketNo = 10000;
    private LocalDate validDate;
    private String durationType;
    private double subtotal;
    private TicketCategory category;
    private ThemePark themePark;

    public Ticket(LocalDate validDate, String durationType, double subtotal, TicketCategory category, ThemePark themePark) {
        this.validDate = validDate;
        this.durationType = durationType;
        this.subtotal = subtotal;
        this.category = category;
        this.themePark = themePark;
        cur_TicketNo++;
    }
   
    public Ticket(){
        
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public String getDurationType() {
        return durationType;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public ThemePark getThemePark() {
        return themePark;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public void setThemePark(ThemePark themePark) {
        this.themePark = themePark;
    }
    
    
    
    //Implement Interface
    public void displayMenu(){
        System.out.println("------------------------------------------------------------|");
        System.out.println("|  TICKET LIST                                              |");
        System.out.println("------------------------------------------------------------|");
        System.out.println("| 1  |                    | Description                     |");
        System.out.println("|____|____________________|_________________________________|");
    }
    
    public int inputChoice(int max){
        int num = 0;
        return num;
    }
       
    //Display Ticket Pass
    public static void displayTicketPass(){
        System.out.println("\n---------------------------");
        System.out.println(" Select ticket pass type"  );
        System.out.println("---------------------------");
        System.out.println("1. 1-day pass   |    -    ");
        System.out.println("2. 3-day pass   |(+RM  30)");
        System.out.println("3. 1-week pass  |(+RM 100)");
        System.out.println("---------------------------");
        System.out.print(" Enter(1-3): ");
    }
    
    @Override
    public String toString() {
        return String.format(" ========================================\n") +
               String.format(" || TicketNo: %-24s || \n",this.cur_TicketNo) +
               String.format(" ||--------------------                ||\n") +
               String.format(" || ThemePark: %-23s || \n",this.themePark.getName()) + 
               String.format(" ||                                    ||\n") +
               String.format(" || ValidDate: %-23s || \n",this.validDate) + 
               String.format(" ||                                    ||\n") +
               String.format(" || Pass     : %-23s || \n",this.durationType) +
               String.format(" ||                                    ||\n") +
               String.format(" || Type     : %-23s || \n",this.category.getName()) + 
               String.format(" ||                                    ||\n") +
               String.format(" || Subtotal : RM %-20.2f || \n",this.subtotal) +
               String.format(" ========================================\n\n");
    }
    

}
