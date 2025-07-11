import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {7,8,3,1,2};

        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            int smallest = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
