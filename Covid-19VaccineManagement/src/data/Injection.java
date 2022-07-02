/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Injection implements Serializable {

    private String injectID, place1, place2;
    private Student student;
    private Vaccine vaccine;
    private Date date1, date2;

    public Injection() {
    }

    public Injection(Student student) {
        this.student = student;
    }

    public Injection(String injectID, Student student) {
        this.injectID = injectID;
        this.student = student;
    }

    public Injection(String injectID, String place1, Student student, Vaccine vaccine, Date date1) {
        this.injectID = injectID;
        this.place1 = place1;
        this.student = student;
        this.vaccine = vaccine;
        this.date1 = date1;
    }

    public Injection(String injectID, String place1, String place2, Student student, Vaccine vaccine, Date date1, Date date2) {
        this.injectID = injectID;
        this.place1 = place1;
        this.place2 = place2;
        this.student = student;
        this.vaccine = vaccine;
        this.date1 = date1;
        this.date2 = date2;
    }

    public String getInjectID() {
        return injectID;
    }

    public void setInjectID(String injectID) {
        this.injectID = injectID;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date2String = null;
        if (date2 != null) {
            date2String = df.format(date2);
        }
        return "Injection{" + "injectID=" + injectID + ", place1=" + place1 + ", place2=" + place2 + ", student=" + student.getName() + ", vaccine=" + vaccine.getName() + ", date1=" + date1 + ", date2=" + date2String + '}';
    }

    public void printInjectTitle() {
        System.out.printf((char) 27 + "[31m" + "|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "InjectID", "Student", "Vaccine", "1st Palace", "1st Date", "2nd Place", "2nd Date");
    }

    public void printInject() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date2String = null;
        if (date2 != null) {
            date2String = df.format(date2);
        }
        System.out.printf((char) 27 + "[35m" + "|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                injectID, student.getName(), vaccine.getName(), place1, df.format(date1), place2, date2String);
    }
}
