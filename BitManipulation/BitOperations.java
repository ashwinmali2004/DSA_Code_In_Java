package BitManipulation;

public class BitOperations {
    public static void main(String[] args) {
        printBits(53);
        int res1 = clearLSB(53, 4);
        printBits(res1);
        int res2 = clearMSB(53, 4);
        printBits(res2);
        int res3 = clearMSBExclusive(53, 4);
        printBits(res3);
        int arr[] = {2,4,6,2,1,1};
        printTwoUniqueElement(arr);

    }

    // PrintBits-->
    public static void printBits(int num){
        for(int i = 7;i>0;i--){
            System.out.print(num>>i & 1);
        }
        System.out.println();
    }

    public static int clearLSB(int num, int bit){
        return num & ~((1<<bit+1)-1);
    }
    
    public static int clearMSB(int num, int bit){
        return num & ((1<<bit)-1);
    }
    public static int clearMSBExclusive(int num, int bit){
        return num & ((1<<bit+1)-1);
    }

    public static void printTwoUniqueElement(int arr[]){
        int l = arr.length;
        int res = 0;
        for(int i=0;i<l;i++){
            res=res^arr[i];
        }
        int setBit=0;
        int bit=0;
        while(res!=0){
            if((res>>bit & 1) !=0){
                setBit=bit;
                break;
            }
            bit++; 
        }
        int res1=0;
        for(int i=0;i<l;i++){
            if((arr[i]>>setBit & 1) !=0){
                res1 = res1 ^ arr[i];
            }
        }
        int num1 = res^res1;
        int num2 = num1^res;
        System.out.println("num1 : "+num1+" num2 : "+num2);
    }

}
