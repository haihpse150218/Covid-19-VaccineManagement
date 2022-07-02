/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WriteReadStudent {
    public static void main(String[] args) {
        writeStudent();
        
    }
    public static void writeStudent() {
        try {
            String fileName = "student.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            List<Student> list = new ArrayList<>();
            list.add(new Student("SE150000", "Hoa Doan"));
            list.add(new Student("SE150001", "Van A"));
            list.add(new Student("SE150002", "Van B"));
            list.add(new Student("SE150003", "Van C"));
            list.add(new Student("SE150004", "Van D"));
            list.add(new Student("SE150005", "Van E"));
            for (Student student : list) {
                oStream.writeObject(student);
            }
            oStream.close();
            file.close();
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<Student> readStudent(){
        try {
            String fileName = "student.dat";
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream iSream = new ObjectInputStream(file);
            ArrayList<Student> list = new ArrayList<>();
            while(file.available() != 0){
                list.add((Student)(iSream.readObject()));
            }
            iSream.close();
            file.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
