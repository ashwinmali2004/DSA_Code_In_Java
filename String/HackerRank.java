package String;
import java.io.*;
import java.util.*;

public class HackerRank {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // To use the logic of seperations.. in String-->
        String s = scan.nextLine().trim();
        if (s.isEmpty()) {
             System.out.println(0); return; 
        }
        String[] spt = s.split("[^A-Za-z]+");
        System.out.println(spt.length);
        for(String a : spt) System.out.println(a);
        scan.close();
    }
}
