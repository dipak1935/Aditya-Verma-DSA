package Sliding_Window;

public class P1_MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {

        int[] arr={2,5,1,8,2,9,1};
        int k=3;

        maxSum2(arr,k);
    }

    private static void maxSum(int[] arr, int k) {

        int n=arr.length;

        int maxSum=0;

        for(int i=0;i<n-k+1;i++){
            int currSum=0;
            for(int j=i;j<i+k;j++){
                currSum+=arr[j];
            }
            maxSum=Math.max(maxSum,currSum);
        }

        System.out.println(maxSum);
    }

    private static void maxSum2(int[] arr, int k) {

        int n=arr.length;

        int maxSum=0,currSum=0;
        int i=0,j=0;

        while(j<n){

            currSum+=arr[j];

            if(j-i+1<k) j++;
            else if(j-i+1==k){
                maxSum=Math.max(maxSum,currSum);

                currSum-=arr[i];
                i++;
                j++;
            }
        }

        System.out.println(maxSum);
    }
}
