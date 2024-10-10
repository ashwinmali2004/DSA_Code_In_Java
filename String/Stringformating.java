package String;

import java.util.Scanner;

public class Stringformating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String Concatenation-->
        System.out.println("Ashwin" + 64 + 87.99);

        System.out.println("Ashwin" + (64 + 87.99));

        System.out.println(64 + 87.99 + "Ashwin");

        String cal = 64 + 87.99 + "Ashwin";
        String name = "Ashwin";
        int rollNumber = 37;
        System.out.println("My name is " + name + " My roll number is " + rollNumber);

        // string formatting.
        double num = 67.86789765;
        System.out.println(num);
        System.out.printf("Number is %.2f"+"\n", num);
        String address = "India";
        String sent = String.format("Number is %.2f address is %s", num, address);
        System.out.println(sent);

    }
}
