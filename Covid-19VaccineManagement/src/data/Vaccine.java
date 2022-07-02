/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Vaccine implements Comparable<Vaccine>, Serializable{
    public String vaccineID, name;

    public Vaccine(String vaccineID, String name) {
        this.vaccineID = vaccineID;
        this.name = name;
    }

    public Vaccine() {
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "vaccineID=" + vaccineID + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Vaccine o) {
        return this.vaccineID.compareToIgnoreCase(o.vaccineID);
    }
}
