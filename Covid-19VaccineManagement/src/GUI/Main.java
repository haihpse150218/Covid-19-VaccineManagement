/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.FileIO;
import data.Injection;
import data.ManInjection;
import data.Menu;
import data.Student;
import data.Vaccine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WriteReadStudent.main(args);
        WriteReadVaccine.main(args);
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent = WriteReadStudent.readStudent();
        ArrayList<Vaccine> listVaccines = new ArrayList<>();
        listVaccines = WriteReadVaccine.readVaccine();

        String fileName = "injection.dat";
        File filecheck = new File(fileName);
        ManInjection mn = new ManInjection();
        if (filecheck.exists()) {
            mn = FileIO.readInjection();
        }
        for (int i = 0; i < mn.size(); i++) {
            Student stu = mn.get(i).getStudent();
            Student delstu = null;
            for (Student student : listStudent) {
                if(student.compareTo(stu) == 0){
                    delstu = student;
                }
            }
            listStudent.remove(delstu);
        }
        final int QUIT_KEY = 0;
        int key;
        do {
            System.out.println((char) 27 + "[31m" + "=========================Menu=========================" + (char) 27 + "[30m");
            key = Menu.getChoice(Menu.menuList);

            switch (key) {
                case 1:
                    mn.printInjection();
                    break;
                case 2:

                    mn.addInjection(listStudent, listVaccines);
                    mn.printInjection();
                    break;
                case 3:
                    mn.update();
                    break;
                case 4:
                    Injection delInject = mn.delete();
                    if (delInject != null) {
                        listStudent.add(delInject.getStudent());
                        System.out.println((char) 27 + "[32m" + "Success...");
                    } else {
                        System.out.println((char) 27 + "[31m" + "Fail!");
                    }
                    break;
                case 5:
                    mn.searchByStudentID();
                    break;
                case 6:
                    String fileSave;
                    fileSave = "injection";
                    FileIO.save(fileSave, mn);
                    FileIO.writeObjectInject(mn);
                    System.out.println((char) 27 + "[32m" + "Success...");
                    break;
                case 7:
                    key = QUIT_KEY;
                    break;
                default:

                    break;
            }
        } while (key != QUIT_KEY);

    }
}
