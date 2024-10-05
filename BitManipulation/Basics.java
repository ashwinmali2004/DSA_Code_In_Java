package BitManipulation;

public class Basics {
    
    public static void main(String[] args) {
        // System.out.println("BitManipulation of the 5 : "+bitmanipulation(5));
        // printBits(32);
        // printBits(33);
        // printOddEven(27);
        // printOddEven(30);
        // int res= setIthBit(32,4);
        // printBits(res);
        // printBits(27);
        // int res = unsetIthBit(27, 3);
        // printBits(res);
        // isPowerOfTwo(32);
        // isPowerOfTwo(33);
    }

    public static int bitmanipulation(int target){
        int ans;
        ans= ~(target);
        return ans;
    }

    // To print the bits of a number
    public static void printBits(int num){
        for(int i=7;i>=0;i--){
            System.out.print((num>>i) & 1);
        }
        System.out.println();
    }

    public static void printOddEven(int num){
        if((num & 1) != 0){
            System.out.println("Number is Odd");
        }else{
            System.out.println("Number is even");
        }
    }

    public static int setIthBit(int num, int bit){
        return num | (1<<bit);
    }

    public static int ToggleBit(int num, int bit){
        return num ^ (1<<bit);
    }
 
    public static int unsetIthBit(int num, int bit){
        return num & ~(1<<bit);
    }
    
    public static void isPowerOfTwo(int num){
        if((num & (num-1)) == 0){
            System.out.println("Number is power of two.");
        }else{
            System.out.println("Number is not power of two.");
        }
    }

    public static int unsetRightMostSetBit(int num){
        return (num & num-1);
    }
}