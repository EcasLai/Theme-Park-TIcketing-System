/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

/**
 *
 * @author Lenovo
 */
public class Facility{
    private String name;
    private String facilityDesc;
    private FacilityStatus status = FacilityStatus.OPEN;

    public Facility(String name, String facilityDesc) {
        this.name = name;
        this.facilityDesc = facilityDesc;
    }
    
    public Facility() {
    
    }

    public String getName() {
        return name;
    }

    public String getFacilityDesc() {
        return facilityDesc;
    }

    public FacilityStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacilityDesc(String facilityDesc) {
        this.facilityDesc = facilityDesc;
    }

    public void setStatus(FacilityStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "\nFacility name = " + name + "\nFacility Descrebtion = " + facilityDesc + "\nStatus = " + status;
    }
}
