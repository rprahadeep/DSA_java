//koko eating bananas
//leetcode 875

public class problem4{
    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        int h = 8;

        int start = 1;
        int end = findMax(piles);

        while(start<=end){
            int mid = start + (end-start)/2;
            if(calculateHours(piles,mid)<=h){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);


    }

    static int findMax(int[] arr){
        int max = 0;
        for(int i:arr){
            max = Math.max(i,max);
        }
        return max;
    }

    static int calculateHours(int[] arr, int val){
        int ans = 0;
        for(int i:arr){
            ans = ans + (int)Math.ceil((double)i/(double)val);
        }
        return ans;
    }

}