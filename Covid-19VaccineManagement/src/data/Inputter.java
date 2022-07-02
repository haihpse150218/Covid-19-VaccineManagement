/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Hai Hoang
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg) {
        int data;
        do {
            System.out.print((char) 27 + "[34m" + msg + (char) 27 + "[30m");
            try {
                data = Integer.parseInt(sc.nextLine());
                return data;
            } catch (Exception e) {
                System.err.println("Invalid");
            }
        } while (true);
    }

    public static int getInt(String msg, int min, int max) {
        int data;
        do {
            System.out.print((char) 27 + "[34m" + msg + (char) 27 + "[30m");
            try {
                data = Integer.parseInt(sc.nextLine());
                if (data < min || data > max) {
                    throw new Exception();
                }
                return data;
            } catch (Exception e) {
                System.err.println("Invalid!");
            }
        } while (true);

    }

    public static String getString(String msg) {
        String data;
        System.out.print((char) 27 + "[34m" + msg + (char) 27 + "[30m");
        data = sc.nextLine().trim();
        return data;
    }

    public static Date getDate(String msg) {
        Date data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        do {
            try {
                data = df.parse(Inputter.getString(msg));
                return data;
            } catch (Exception e) {
                System.err.println("Invalid!");
            }
        } while (true);
    }
    public static Date getDate(String msg, Date now){
        Date data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        do{
            try {
                data = df.parse(Inputter.getString(msg));
                now = df.parse(df.format(now));
                if(!(now.compareTo(data) <= 0)){
                    throw new Exception();
                }
                return data;
            } catch (Exception e) {
                System.err.println("Invalid!");
            }
        }while(true);
    }


    public static String getNonBlankStr(String msg) {
        String data;
        do {
            System.out.print((char) 27 + "[34m" + msg + (char) 27 + "[30m");
            data = sc.nextLine().trim();
            if (data.length() == 0) {
                System.err.println("Invalid!");
            }
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print((char) 27 + "[34m" + msg + (char) 27 + "[30m");
            data = sc.nextLine().trim().toUpperCase();
            if (!data.matches(pattern)) {
                System.err.println("Invalid!");
            }
        } while (!data.matches(pattern));
        return data;
    }
    
    public static Date getDate(String msg, String dateMin, Date now) {
        Date data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date min;

        do {
            try {
                data = df.parse(Inputter.getString(msg));
                min = df.parse(dateMin);
                now = df.parse(df.format(now));
                if (!(min.compareTo(data) <= 0)) {
                    throw new Exception();
                }
                if ((now.compareTo(data) < 0)) {
                    throw new Exception();
                }
                return data;
            } catch (Exception e) {
                System.out.println((char)27 + "[31m" + "Invalid!");
            }
        } while (true);
    }
    
    public static boolean caculateDate(Date date1, Date date2, int max, int min) {
        
        Calendar cMax = Calendar.getInstance();
        Calendar cMin = Calendar.getInstance();
        cMax.setTime(date1);
        cMin.setTime(date1);
        cMin.add(Calendar.DATE, min * 7);
        cMax.add(Calendar.DATE, max * 7);
        
        int check1 = date2.compareTo(cMin.getTime());
        int check2 = date2.compareTo(cMax.getTime());
        
        if (check1 < 0 && !(check2 < 0)) {
            return true;     
        }
        return false;
    }
    
    public static String getAChoice(String msg) {
        String n;
        while (true) {
            try {
                n = getNonBlankStr(msg);
                n = n.toLowerCase();
                if (n.matches("y|n$")) {

                } else {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println("Invalid!");
            }
        }
    }
    
}
