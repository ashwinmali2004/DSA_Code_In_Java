package String;

import Searching.Arrays;

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

        // To Find that give two Strings are Anagrams are not
        if(isAnagram("abcd","dcaba")){
            System.out.println("Given Strings are anagram!!");
        }else{
            System.out.println("Are not anagram!!");
        }
    }

    public static void printSubString(String s){
        System.out.println("Substrings of the String \""+ s +"\" is :");
        int size = s.length()*(s.length()+1)/2;  //n(n+1)/2 no. of substring of a string
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

    // It looks like O(n) complexity but in string concatination it is O(n^2)
    public static void printReverseString(String s){
        System.out.println("Reverse of the String \""+ s +"\" is :");
        String str = "";
        for(int i=s.length()-1;i>=0;i--){
            str+=s.charAt(i);
        }
        System.out.println(str);
    }

    // better approch
    public static void printReverseString2(String s){
        StringBuilder ans = new StringBuilder(s);
        // int n = ans.length();
        // for(int i=0;i<n/2;i++){
        //     char firstChar = ans.charAt(i);
        //     char lastChar = ans.charAt(n-1-i);
        //     ans.setCharAt(i, lastChar);
        //     ans.setCharAt(n-1-i, firstChar);
        // }
        System.out.println(ans.reverse().toString());
    }

    // O(n/2) and O(1) 
    // if we use StringBuilder reverse it and compare with equal than O(n) and O(n)
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

    public static boolean isAnagram(String s, String t){

        if(s.length()!=t.length()){
            return false;
        }
        int len = s.length();
        int freq[] = new int[26];

        int indexA = 0;
        int indexB = 0;

        while(indexA < len){
            char charA = s.charAt(indexA);
            int freqIndexA = charA-'a';
            freq[freqIndexA]+=1;

            char charB = t.charAt(indexB);
            int freqIndexB = charB-'a';
            freq[freqIndexB]-=1;
            
            indexA++;
            indexB++;
        }
        
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;


        // Approch-2
        // Using Sorting-->
        // if(s.length() != t.length()) return false;

        // char[] sc = s.toCharArray();                         
        // char[] tc = t.toCharArray();

        // Arrays.sort(sc);                         
        // Arrays.sort(tc);

        // if(Arrays.equals(sc, tc)) return true;

        // return false;  


        // Aprroch-3
        // Using MapFucntion-->
        // Map<Character, Integer> map = new HashMap<>();

        // for(char x : s.toCharArray()){
        //     map.put(x, map.getOrDefault(x,0)+1);
        // }

        // for(char x : t.toCharArray()){
        //     map.put(x, map.getOrDefault(x,0)-1);
        // }

        // for(int val : map.values()){
        //     if(val != 0){
        //         return false;
        //     }
        // }

        // return true;
    }
}
