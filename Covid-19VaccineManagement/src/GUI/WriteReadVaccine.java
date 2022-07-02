/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.Vaccine;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class WriteReadVaccine {
    public static void main(String[] args) {
        writeVaccine();
    }
    public static void writeVaccine() {
        try {
            String fileName = "vaccine.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            ArrayList<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("Covid-V001", "AstraZeneca"));
            list.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            list.add(new Vaccine("Covid-V003", "Vero Cell"));
            list.add(new Vaccine("Covid-V004", "Pfizer"));
            list.add(new Vaccine("Covid-V005", "Moderna"));
            for (Vaccine vaccine : list) {
                oStream.writeObject(vaccine);
            }
            oStream.close();
            file.close();
        } catch (Exception e) {
        }
    }
    public static ArrayList<Vaccine> readVaccine() {
        try {
            String fileName = "vaccine.dat";
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream oStream = new ObjectInputStream(file);
            ArrayList<Vaccine> list = new ArrayList<>();
            while(file.available() != 0){
                list.add((Vaccine)(oStream.readObject()));
            }
            oStream.close();
            file.close();
            return list;
        } catch (Exception e) {
            System.out.println((char)27 + "[31m" + "File Fail!");
            return null;
        }
    }
}
