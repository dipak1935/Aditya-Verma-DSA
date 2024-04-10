package Sliding_Window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2_FirstNegativeNoInEveryWindowOfSizeK {
    public static void main(String[] args) {

        int[] arr={12,-1,-7,8,-15,30,16,28};
        int[] arr2={-8, 2, 3, -6, 10};
        int k=2;

        System.out.println(Arrays.toString(firstNeg(arr2,k)));
        System.out.println(Arrays.toString(firstNeg2(arr2,k)));
        System.out.println(Arrays.toString(firstNeg3(arr2,k)));
    }

    private static int[] firstNeg3(int[] arr, int k) {

        int n=arr.length;

        int[] ans=new int[n-k+1];

        Queue<Integer> temp=new LinkedList<>();

        int i=0;

        for(int j=0;j<n;j++){

            if(arr[j]<0) temp.add(j);

            if(j-i+1==k){

                if(!temp.isEmpty()){

                    ans[i]=arr[temp.peek()];
                    if(temp.peek()==i) temp.poll();
                }

                i++;
            }

        }

        return ans;
    }

    private static int[] firstNeg2(int[] arr, int k) {

        int n=arr.length;

        int[] ans=new int[n-k+1];

        Queue<Integer> temp=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(arr[i]<0) temp.add(i);
        }

        int i=0,j=0;

        while(j<n){

            if(j-i+1<k) j++;

            else if(j-i+1==k){

                if(!temp.isEmpty()){

                    if(temp.peek()<=j && temp.peek()>=i){

                      //  ansIndex.add(temp.element());

                        ans[i]=arr[temp.peek()];

                        if(temp.peek()==i) temp.poll();

                    }
                }

                i++;
                j++;

            }

        }

        return ans;

    }
    private static int[] firstNeg(int[] arr, int k) {

        int n=arr.length;

        int[] ans=new int[n-k+1];


        for(int i=0;i<n-k+1;i++){
            for(int j=i;j<i+k;j++){
                if(arr[j]<0){
                    ans[i]=arr[j];
                    break;
                }
            }
        }
        return ans;

    }
}
