import java.util.*;
public class FractionalKnapsack {
    static class Item{
        int weight;
        int value;
        int parameter;
        Item(int weight, int value){
            this.weight = weight;
            this.value = value;
            this.parameter = value/weight;
        }

    }
    public static void main(String[] args){
        Item[] arr = {new Item(20,100), new Item(10,60), new Item(50,100), new Item(50,200)};
        Arrays.sort(arr, (a,b)->b.parameter-a.parameter);

        int sackWeight = 90;

        double totalVal = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].weight<sackWeight){
                totalVal = totalVal+arr[i].value;
                sackWeight = sackWeight-arr[i].weight;
            } else {
                totalVal = totalVal + (sackWeight*arr[i].parameter);
            }
        }
        System.out.println(totalVal);
    }
}
