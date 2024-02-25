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
public class ThemePark implements Menu{
    private String name;
    private String description;
    private Facility[] facility;
    private double parkCharges;
    public int length;

    public ThemePark(String name, String description, Facility[] facility, double parkCharges) {
        this.name = name;
        this.description = description;
        this.facility = facility;
        this.parkCharges = parkCharges;
    }

    public ThemePark() {
        
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Facility[] getFacility() {
        return facility;
    }

    public double getParkCharges() {
        return parkCharges;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFacility(Facility[] facility) {
        this.facility = facility;
    }

    public void setParkCharges(double parkCharges) {
        this.parkCharges = parkCharges;
    }
    
    //display themepark menu header
    public void displayMenu(){
        System.out.println("\n\tTHEMEPARK LISTING");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| NO | ThemePark                 | Description                                        | Price(RM)  |");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
    }
    
    //Loop all themepark
    public static void displayThemePark(ThemePark[] themeparkList){
        //loop display all
        for(int i = 0; i < themeparkList.length; i++){
            System.out.printf ("| %2d | %-25s | %-50s | %10.2f |\n",i+1, themeparkList[i].getName(), themeparkList[i].getDescription(), themeparkList[i].getParkCharges());
            System.out.println("|____|___________________________|____________________________________________________|____________|");
        }
        System.out.print("\n");
    }
    
    //choice input & validation
    public int inputChoice(int max){
        Scanner sc = new Scanner(System.in);
        int num;
        do{
            num = 0;
            num = sc.nextInt();
            sc.nextLine();
            if(!(num >= 1 && num <= max)){
                System.out.println("Invalid choice, Please try again");
                System.out.print(" Choose the themePark (1-" + max +"): ");
            }
        }while(!(num >= 1 && num <= max));
        
        return num;
    }
            
    
    @Override
    public String toString() {
        return "\nThemePark name = " + name + "\nDescription = " + description + "\nPark Charges = " + parkCharges;
    }
}
