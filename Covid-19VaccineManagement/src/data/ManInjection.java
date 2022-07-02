/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author USER
 */
public class ManInjection extends ArrayList<Injection> implements Serializable {

    public static final int MAX_WEEK = 12;
    public static final int MIN_WEEK = 4;

    public ManInjection() {
        super();
    }

    public Injection addInjection(ArrayList<Student> listStudent, ArrayList<Vaccine> listVaccines) {
        String injectID = null;
        Vaccine vaccine;
        Student student;
        String place1;
        Date date1;
        if (listStudent.isEmpty()) {
            System.out.println((char) 27 + "[31m" + "Have no Student to add injection");
            return null;
        }
        injectID = getInjectID(injectID);
        student = Menu.refGetChoice(listStudent);
        listStudent.remove(student);//
        vaccine = Menu.refGetChoice(listVaccines);
        place1 = Inputter.getString("Enter 1st Palce: ");
        date1 = Inputter.getDate("Enter 1st Date: ", "8/3/2021", new Date());
        Injection injection = new Injection(injectID, place1, student, vaccine, date1);
        this.add(injection);
        if (Inputter.getAChoice("Continue add 2nd injection?(Y/N): ").equalsIgnoreCase("Y")) {
            updateInjection(injection, Inputter.getNonBlankStr("Input 2nd Injection's place: "));
        }

        return injection;
    }

    private String getInjectID(String injectID) {
        do {
            injectID = Inputter.getNonBlankStr("Input injectionID: ");
        } while (isDupplicated(injectID));
        return injectID;
    }

    private void updateInjection(Injection injection, String place2) {
        Date date2;
        boolean check;
        do {
            Calendar cMax = Calendar.getInstance();
            Calendar cMin = Calendar.getInstance();
            cMax.setTime(injection.getDate1());
            cMin.setTime(injection.getDate1());
            cMin.add(Calendar.DATE, MIN_WEEK * 7);
            cMax.add(Calendar.DATE, MAX_WEEK * 7);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String recommend = "" + df.format(cMin.getTime()) + "-" + df.format(cMax.getTime());
            date2 = Inputter.getDate("Input 2nd injection's date " + recommend + ": ", "8/3/2021", new Date());
            check = Inputter.caculateDate(injection.getDate1(), date2, MIN_WEEK, MAX_WEEK);

            if (!check) {
                System.out.println("Invalid");
            }
        } while (!check);
        injection.setDate2(date2);
        injection.setPlace2(place2);
    }

    public void update() {
        boolean check;
        Injection injection;
        do {
            check = false;
            injection = searchbyID();
            if (injection == null) {
                System.out.println("Injection does not exist");
                if (Inputter.getAChoice("Do you want to continue(y/n): ").equalsIgnoreCase("y")) {
                    check = true;
                }
            } else if (injection.getDate2() != null) {
                System.out.println("Student has completed 2 injections!");
                if (Inputter.getAChoice("Do you want to continue(y/n): ").equalsIgnoreCase("y")) {
                    check = true;
                }
            }
        } while (check);
        if (injection != null) {
            updateInjection(injection, Inputter.getNonBlankStr("Input 2nd Injection's place: "));
        }
    }

    private Injection searchbyID() {
        String inputID = Inputter.getString("Input ID: ");
        for (Injection injection : this) {
            if (inputID.equalsIgnoreCase(injection.getInjectID())) {
                return injection;
            }
        }
        return null;
    }

    private boolean isDupplicated(String id) {
        for (Injection inject : this) {
            if (inject.getInjectID().equalsIgnoreCase(id)) {
                System.out.println((char) 27 + "[31m" + "ID is exicted");
                return true;
            }
        }
        return false;

    }

    public Injection delete() {
        Injection delInjection = null;
        if (this.isEmpty()) {
            System.out.println((char) 27 + "[31m" + "List is empty");
            return null;
        }
        delInjection = getDelInjection(delInjection);
        if (delInjection != null) {
            delInjection.printInjectTitle();
            delInjection.printInject();
            if (Inputter.getAChoice("Do you want to Delete?(y/n): ").equalsIgnoreCase("y")) {
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i).getInjectID().equalsIgnoreCase(delInjection.getInjectID())) {

                        this.remove(i);
                        return delInjection;
                    }
                }
            }
        }

        return null;
    }
    

    private Injection getDelInjection(Injection delInjection) {
        boolean check;
        do {
            check = false;
            delInjection = searchByStudentName();
            if (delInjection == null) {
                System.out.println("Injection does not exist");
                if (Inputter.getAChoice("Do you want to continue?(y/n): ").equalsIgnoreCase("y")) {
                    check = true;
                }
            }
        } while (check);
        return delInjection;
    }

    public void printInjection() {
        if (this.isEmpty()) {
            System.out.println((char) 27 + "[31m" + "List is empty");
        } else {
            this.get(0).printInjectTitle();
            for (Injection inj : this) {
                inj.printInject();
            }
        }

    }

    public void searchByStudentID() {
        if (this.isEmpty()) {
            System.out.println((char) 27 + "[31m" + "List Injection is Empty!");
            return;
        }
        String studentID = Inputter.getNonBlankStr("Input student ID: ");
        for (Injection inj : this) {
            if ((inj.getStudent().getStudentId()).equalsIgnoreCase(studentID)) {
                System.out.println((char) 27 + "[34m" + inj.getStudent());
                inj.printInjectTitle();
                inj.printInject();
            } else {
                System.out.println((char) 27 + "[31m" + "Not Found!");
            }
        }
    }

    private Injection searchByStudentName() {
        if (this.isEmpty()) {
//            System.out.println((char) 27 + "[31m" + "List Injection is Empty!");
            return null;
        }
        String studentName = Inputter.getNonBlankStr("Input student Name: ");
        for (Injection inj : this) {
            if ((inj.getStudent().getName()).equalsIgnoreCase(studentName)) {
//                System.out.println((char) 27 + "[34m" + inj.getStudent());
//                inj.printInjectTitle();
//                inj.printInject();
                return inj;
            } else {
//                System.out.println((char) 27 + "[31m" + "Not Found!");
                return null;
            }
        }
        return null;
    }

//    public void printLess60() {
//        for (int i = 0; i < this.size(); i++) {
//            if ((this.get(i).getDate2() != null)) {
//                if ((this.get(i).getDate2().getDate() - this.get(i).getDate2().getDate()) < 60) {
//                    (this.get(i)).printInjectTitle();
//                    (this.get(i)).printInject();
//                }
//            }
//        }
//    }
}
