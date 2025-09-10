package DSA.lec100925;

public class Valentine_Magic {
    public static void main(String[] args){
        int[] boys = {2, 11, 3};
        int[] girls = {5, 7, 3, 2};

        System.out.println(Valentine(boys, girls, 0, 0));
    }

    public static int Valentine(int[] boys, int[] girls, int i, int j){
        if(i==boys.length){
            return 0;
        }
        if(j==girls.length){
            return 9999999;
        }

        int sel  = Math.abs(boys[i]-girls[j]+Valentine(boys, girls, i+1, j+1));
        int rej = Valentine(boys, girls, i, j+1);
        return Math.min(sel,rej);


    }




}
