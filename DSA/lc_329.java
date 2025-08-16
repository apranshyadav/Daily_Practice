class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] nextGreater=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            nextGreater[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int j=0;
        int [] res=new int[n-k+1];
        for(int i=0;i<=n-k;i++)
        {
        if(j<i) j=i; 
            while(nextGreater[j]<i+k)
            {
                j=nextGreater[j];
            }
            res[i]=nums[j];
        }
        return res;
    }
}