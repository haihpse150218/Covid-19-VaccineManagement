/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class FileIO {

     public static boolean save(String nameFile, ArrayList list){
        File file = new File(nameFile + ".txt");
        PrintStream printStream;
        try {
            printStream = new PrintStream(new FileOutputStream(file));
            for (Object inj : list) {
                printStream.println(inj.toString());
            }
            printStream.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
    public static void writeObjectInject(ManInjection listInjection) {
        try {
            String fileName = "injection.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            for (Injection inj : listInjection) {
                oStream.writeObject(inj);
            }
            oStream.close();
            file.close();
        } catch (Exception e) {
        }
    }

    public static ManInjection readInjection() {
        try {
            String fileName = "injection.dat";
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream iSream = new ObjectInputStream(file);
            ManInjection list = new ManInjection();
            while (file.available() != 0) {
                list.add((Injection) (iSream.readObject()));
            }
            iSream.close();
            file.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
