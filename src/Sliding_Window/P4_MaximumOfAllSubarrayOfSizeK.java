package Sliding_Window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P4_MaximumOfAllSubarrayOfSizeK {
    public static void main(String[] args) {

        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxOfAllSubarray(arr,k)));
    }

    private static int[] maxOfAllSubarray(int[] arr,int k) {

        int n=arr.length;
        int[] ans=new int[n-k+1];
        int maxElement=Integer.MIN_VALUE;
        Deque<Integer> temp=new LinkedList<>();

        int i=0,j=0;

        while (j<n){

            while(!temp.isEmpty() && arr[j]> arr[temp.getLast()]){
                temp.removeLast();
            }

            temp.add(j);


            if(j-i+1 < k) j++;
            else if(j-i+1 == k){

                if(temp.getFirst()<i) temp.removeFirst();


                ans[i]=arr[temp.getFirst()];

                i++;
                j++;

            }
        }

        return ans;
    }
}
