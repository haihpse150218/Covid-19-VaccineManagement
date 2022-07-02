/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Hai Hoang
 */
public class Menu {
    // ========menu==============
    public static String[] menuList = {
        "Show information all students have been injected",
        "Add student's vaccine injection information",
        "Updating information of students' vaccine injection",
        "Delete student vaccine injection information",
        "Search for injection information by studentID",
        "Save",
        "Quit"};
    
    

    public static int getChoice(String[] option) {
        for (int i = 1; i <= option.length; i++) {
            System.out.println((char) 27 + "[32m" + i + "-" + (char) 27 + "[34m" + option[i - 1]);
        }
        return Inputter.getInt("Choice 1..." + option.length+": ", 1, option.length);
    }
    
    public static int getChoice(ArrayList option) {
        for (int i = 0; i < option.size(); i++) {
            System.out.println((char) 27 + "[32m" + (i + 1) + (char) 27 + "[30m" + "-" + option.get(i));
        }
        return Inputter.getInt("choose 1.." + option.size() + ":", 1, option.size());
    }

    public static <E> E refGetChoice(ArrayList<E> options) {
        int response;
        int n = options.size();
        do {
            response = getChoice(options);
        } while (response < 0 || response > n);
        return options.get(response - 1);
    }
     public static String[] dict63 = {
        "Ha Noi","Ho Chi Minh","Da Nang","Hai Phong","An Giang","Ba Ria Vung Tau",
         "Bac Giang","Bac Kan","Bac Lieu","Bac Ninh","Ben Tre","Binh Dinh",
         "Binh Duong","Binh Phuoc","Binh Thuan","Ca Mau","Can Tho","Cao Bang",
         "Dak Lak","Dak Nong","Dien Bien","Dong Nai","Dong Thap","Gia Lai",
         "Ha Giang","Ha Nam","Ha Tinh","Hai Duong","Hau Giang","Hoa Binh","Hung Yen",
         "Khanh Hoa","Kien Giang","Kon Tum","Lai Chau","Lam Dong","Lang Son","Lao Cai",
         "Long An","Nam Dinh","Nghe An","Ninh Binh","Ninh Thuan","Phu Tho","Phu Yen",
         "Quang Binh","Quang Nam","Quang Ngai","Quang Ninh","Quang Tri","Soc Trang",
         "Son La","Tay Ninh","Thai Binh","Thai Nguyen","Thanh Hoa","Thua Thien Hue",
         "Tien Giang","Tra Vinh","Tuyen Quang","Vinh Long","Vinh Phuc","Yen Bai"};

}
