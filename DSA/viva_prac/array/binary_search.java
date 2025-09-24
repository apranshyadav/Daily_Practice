package DSA.viva_prac.array;

public class binary_search {
    public static int Binary_search(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.print(mid);
            System.out.print(l);
            System.out.print(r);

            if (a[mid] == key) return mid;
            else if (a[mid] < key) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int ans = Binary_search(arr, 7);
        System.out.println(ans); 
    }
}
