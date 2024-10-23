package codeAthone_1;
import java.util.Scanner;

public class solution {

    // problem 1 solution-code->>
    public static int[] minMovesTogether(String seats) {
        int occupied = 0;
        for (char seat : seats.toCharArray()) {
            if (seat == 'O') {
                occupied++;
            }
        }
        
        if (occupied == 0 || occupied == seats.length()) {
            return new int[]{0, 0};
        }
        
        int[] emptyCounts = new int[seats.length()];
        int currentAvailable = 0;
        int index = 0;
        for (char seat : seats.toCharArray()) {
            if (seat == 'E') {
                currentAvailable++;
            } else {
                if (currentAvailable > 0) {
                    emptyCounts[index++] = currentAvailable;
                }
                currentAvailable = 0;
            }
        }
        
        int minEmptySeats = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            minEmptySeats = Math.min(minEmptySeats, emptyCounts[i]);
        }
        
        int minMoves = minEmptySeats - 1;
        int ways = 0;
        for (int i = 0; i < index; i++) {
            if (emptyCounts[i] == minEmptySeats) {
                ways++;
            }
        }
        
        return new int[]{minMoves * occupied+1, ways};
    }

    // problem 2 solution-code->>
    public static int maxMoney(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int maxMoney = 0; 
        int sum = 0;

        for(int j=0;j<n-1;j++){
            if(j>2) sum = nums[0];
            for (int i = j; i < n; i += 2) {
                sum += nums[i];
            }
            maxMoney = Math.max(maxMoney,sum);
            sum=0;
        }
        
        return maxMoney;
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = "";
        int i=0;
        System.out.println("Enter the no of seats : ");
        int n = sc.nextInt();
        System.out.println("Write the String : only E and O");
        while(i<n){
            s += sc.next();
            i++;
        }
        System.out.println(s);
        int[] arr=(minMovesTogether(s));
        System.out.println(arr[0] + " " + arr[1]);


        // Problem-2
        System.out.println("Write the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        for(int j=0;j<size;j++){
            nums[j]=sc.nextInt();
        }
        System.out.println(maxMoney(nums));
    }
}
