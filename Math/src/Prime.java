import java.util.*;

public class Prime {
    public static void main(String[] args){
        int N = 30;
        int[] prime = new int[N+1];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;

        for(int i=2;i<=Math.sqrt(N);i++){
            if(prime[i]==1){
                for(int j = i*i;j<=N;j = j+i){
                    prime[j] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(prime));
    }
}
