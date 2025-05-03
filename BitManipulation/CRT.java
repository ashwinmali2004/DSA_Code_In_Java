public class CRT {
    public static void main(String[] args) {
        
    }
    public static int countDigit(int n){
        if (n == 0) return 1; 
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int MSB(int n){
        if (n == 0) return 0; 
        int pos = 0;
        while(n > 1){
            n = n >> 1;
            pos++;
        }
        return pos;
    }

    public static int LSB(int n){
        int count=0;
        while(n != 0){
            if((n & 1) == 1){
                break;
            }
            n = n >> 1;
            count++;
        }
        return count;
    }
    
    public static int missing(int n, int[] arr){
        // int n = arr.length;
        int xor1 = 0;
        int xor2 = 0;
    
        for (int i = 0; i < n; i++) {
            xor1 ^= arr[i];
            // System.out.println(xor1);
        }
    
        for (int i = 0; i <= n; i++) {
            // System.out.println(xor2);
            xor2 ^= i;
        }
    
        return xor1 ^ xor2;
    }
}
