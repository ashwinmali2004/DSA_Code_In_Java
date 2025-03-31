package String;

import java.util.*;

public class BasicFunctions {
    public static void main(String[] args) {
        
                // string functions
                String str = "Tshashwat TTiwarI";
                // str = str.toLowerCase();
                System.out.println(str.toLowerCase());
                System.out.println(str);
        
                System.out.println(str.toUpperCase());
        
                System.out.println(str.charAt(0));
        
                System.out.println(str.indexOf('T'));
                System.out.println(str.lastIndexOf('T'));
                System.out.println(str.length());
                char ch[] = str.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    System.out.print(ch[i] + " ");
                }
        
                System.out.println("SHASHWAT".compareTo("SHASH"));
                System.out.println("SHASH".compareTo("SHASHWAT"));
                System.out.println("SHASHWAT".compareTo("SHASHWAT"));
                System.out.println("SHASH".compareTo("AMASH"));
        
                System.out.println("    shSHWYUWF     ");
                System.out.println("    shSHWYUWF     ".trim());
                System.out.println("shashwat tiwari".startsWith("Rshashwat "));
                System.out.println("shashwat tiwari".endsWith("ri"));
        
                System.out.println("shashwat".substring(3, 3));
        
                String myLocations = "hyderabad, chennai, bangalore, noida, pune";
        
                String myLocationList[] = myLocations.split(",");
        
                for (int i = 0; i < myLocationList.length; i++) {
                    System.out.print(myLocationList[i] + " ");
                }
        
                StringBuilder name1 = new StringBuilder("shashwat");
                StringBuilder name2 = new StringBuilder("shashwat");
                StringBuilder name3 = new StringBuilder("shashwat");
                StringBuilder name4 = name1;
        
                System.out.println(name1 == name2);
                System.out.println(name2 == name3);
                System.out.println(name3 == name4);
                System.out.println(name4 == name2);
                System.out.println(name1 == name4);   //true because pointing to the object variable
        
                name4.append("tiwari");
        
                System.out.println(name1 == name2);
                System.out.println(name2 == name3);
                System.out.println(name3 == name4);
                System.out.println(name4 == name2);
                System.out.println(name1 == name4);   //true because pointing to the object variable

                System.out.println(name1.equals(name2)); // false

                System.out.println(name1.equals(name2)); // false
                System.out.println(name2.equals(name3)); // false
                System.out.println(name3.equals(name4)); // false
                System.out.println(name4.equals(name2)); // false
                System.out.println(name1.equals(name4)); // true because pointing to the object variable

        // To print the name of the company
        String email1 = "randomAvenger@hotgmail.com";
        String emailArr[] = email1.split("@");
        String lastPart = emailArr[emailArr.length - 1];
        int dotIndex = lastPart.lastIndexOf('.');
        System.out.println(lastPart.substring(0, dotIndex));


        // Operations on the next() and nextLine()
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word");
        String word1 = sc.next();
        // int word1 = sc.nextInt();
        System.out.println("Enter a word please");
        String word2 = sc.next();
        // int word2 = sc.nextInt();
        System.out.println("Enter a line");
        String line1 = sc.nextLine();
        System.out.println("Enter next line");
        String line2 = sc.nextLine();

        System.out.print("word1:" + word1 + ",");
        System.out.print("word2:" + word2 + ",");
        System.out.print("line1" + line1 + "*");
        System.out.print("line2" + line2 + "*");

    }
}
