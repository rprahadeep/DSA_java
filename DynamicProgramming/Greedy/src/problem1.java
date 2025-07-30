import java.util.Arrays;

//Minimum no.of coins
public class problem1 {
    public static void main(String[] args){
        int[] denominations = {1,2,5,10,20,50,100,200,500};
        int price = 73;
        int count = 0;
        for(int i=denominations.length-1;i>=0;i--){
            if(denominations[i]>price){
                continue;
            }else{
                while(price>=denominations[i]){
                    price = price-denominations[i];
                    count = count+1;
                }
            }
        }
        System.out.println(count);

    }
}
