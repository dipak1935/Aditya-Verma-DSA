package Sliding_Window;

public class  P5_LargestSubArrayOfSumK {
    public static void main(String[] args) {

        int[] arr={4,1,7,1,1,1,2,3,5};
        int k=4;


        System.out.println(largestSubArray(arr,k));

    }

    private static int largestSubArray(int[] arr, int k) {

        int n=arr.length;

        int i=0,j=0;
        int lengthMax=0;
        int currSum=0;

        while(j<n){
            currSum+=arr[j];

            if(currSum<k) j++;
            else if(currSum == k){
                lengthMax=Math.max(lengthMax,j-i+1);

                j++;
                
            }
            else{

                while(currSum>k){
                    currSum-=arr[i];
                    i++;
                }

                if(currSum == k) lengthMax=Math.max(lengthMax,j-i+1);

                j++;
            }
        }

        return lengthMax;
    }
}
