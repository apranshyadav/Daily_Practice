import java.util.*;
public class orderit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim());
        String sh = sc.nextLine();
        List<String> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLine().trim());
        }
        String or = sc.nextLine();
        List<String> b=new ArrayList<>();
        for(int i=0;i<n;i++){
            b.add(sc.nextLine().trim());
        }
        Map<String,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(b.get(i),i);
        }
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=mp.get(a.get(i));
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(int x:arr){
            int p=Collections.binarySearch(ls,x);
            if(p<0){
                p=-(p+1);
            }
            if(p==ls.size()){
                ls.add(x);
            }
            else {
                ls.set(p,x);
            }
        }
        System.out.print(n-ls.size());
        sc.close();
    }
}