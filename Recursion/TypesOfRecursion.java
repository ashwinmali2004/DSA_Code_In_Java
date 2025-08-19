class TypesOfRecursion{
    public static void main(String[] args) {
        System.out.println("Tail Recursion");
        fun(10);
        System.out.println("\nHead Recursion");
        rev(10);
        System.out.println("\nLinear Recursion");
        System.out.println(sum(6));
        System.out.println("Tree Recursion");
        System.out.println(fibo(7));
    }

    // Tail Recursion--> O(n)
    // print the number from n to 1
    static void fun(int n){
        if(n==0){
            return;
        }
        System.out.print(n+((n!=1)?",":" "));
        fun(n-1);
    }

    // Head Recursion--> O(n)
    // print the number from 1 to n
    static void rev(int n){
        if(n==0){
            return;
        }
        rev(n-1);
        System.out.print(n+((n!=10)?",":" "));
    }

    // Linear Recursion--> O(n)
    static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }

    // Tree Recursion--> (DP, DFS, Permutaion and major problems)--> O(2^n)
    static int fibo(int n){
        if(n==0) return 0;
        if(n==2 || n==1){
            return 1;
        }
        
        return fibo(n-1)+fibo(n-2);
    }
}
