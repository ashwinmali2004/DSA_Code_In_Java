package String;

public class QuestionsOnString {
    public static void main(String[] args) {
        // To print all the substrings of given string
        printSubString("abc");
        
        // To revers the given String
        printReverseString("abcde");
        printReverseString2("abcde");

        // To check that the String is Palindrome or not
        checkPalindrome("naman");
        checkPalindrome("Ashwin");

        // To solve the given problem 
        leetcode151("a good   example");
    }

    public static void printSubString(String s){
        System.out.println("Substrings of the String \""+ s +"\" is :");
        int size = s.length()*(s.length()+1)/2;
        int index = 0;
        String[] str = new String[size];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                str[index++] = s.substring(i, j+1);
            }
        }
        for(String a : str){
            System.out.print(a +",");
        }
        System.err.println();
    }

    public static void printReverseString(String s){
        System.out.println("Reverse of the String \""+ s +"\" is :");
        String str = "";
        for(int i=s.length()-1;i>=0;i--){
            str+=s.charAt(i);
        }
        System.out.println(str);
    }

    public static void printReverseString2(String s){
        StringBuilder ans = new StringBuilder(s);
        int n = ans.length();
        for(int i=0;i<n/2;i++){
            char firstChar = ans.charAt(i);
            char lastChar = ans.charAt(n-1-i);
            ans.setCharAt(i, lastChar);
            ans.setCharAt(n-1-i, firstChar);
        }
        System.out.println(ans.toString());
    }

    public static void checkPalindrome(String s){
        System.out.println("Given String \""+ s +"\" is :");
        boolean isTrue = true;
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                isTrue = false;
            }
            start++;
            end--;
        }
        if (isTrue) {
            System.out.println(" Palindrome!");
        }else{
            System.out.println(" Not a Palindrome!");
        }
    }

    public static void leetcode151(String s){
        // System.out.println("Given String \""+ s +"\" is :");
        // String[] str = s.trim().split("\\s+"); 
        // String ans = "";
        // for (int i = str.length - 1; i >= 0; i--) {
        //     ans += str[i] + (i > 0 ? " " : "");
        // }
        // System.out.println(ans);

        // approch-2 Optimized Using StringBuilder

        String[] words = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                str.append(words[i]);
                str.append(" ");
            }
        }
        System.out.println(str.toString().trim());
    }

    
}
