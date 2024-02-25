/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class Admin extends User{
    private String adminID;

    public Admin() {
    }

    public Admin(String adminID, String name, String email, String contactNo, Account acc) {
        super(name, email, contactNo, acc);
        this.adminID = adminID;
    } 
    
// add new facility into array


    public Facility[] addFacility(Facility[] facility, Facility newFacility){
        
        Facility[] newFacilityList = new Facility[facility.length+1];
        for(int i=0; i<facility.length; i++){
            newFacilityList[i] = facility[i];

        }
        newFacilityList[facility.length] = newFacility;
        facility = newFacilityList;
        return facility;
    }

        
// add new theme park into array
    public ThemePark[] addThemePark(ThemePark[] themePark, ThemePark newThemePark){
        ThemePark[] newThemeParkList = new ThemePark[themePark.length+1];
        for(int i=0; i<themePark.length; i++){
            newThemeParkList[i] = themePark[i];
        }
        newThemeParkList[themePark.length] = newThemePark;
        themePark = newThemeParkList;
        return themePark;
    }

    
    // Admin class

    @Override
    public String toString() {
        return "Admin ID = " + adminID + "\n" + super.toString();
    }
    
}
    
