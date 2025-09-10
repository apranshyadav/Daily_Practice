package DSA.lec100925;

public class Knapsack_Zero_One {

    public static void main(String[] args){

        int cap = 4;
        int[] vt = {1,2,3,2,2};
        int[] val = {0, 4, 0, 5, 3};


    }

    public static int Knapsack(int[] vt, int[] val, int cap, int i){

        int inc=0,exc=0;
        if(cap>=vt[i]) {
            inc = val[i] + Knapsack(vt, val, cap - vt[i], i+1);
        }
        exc = Knapsack(vt, val, cap, i+1)

        return Math.max(inc, exc);
    }
    
}