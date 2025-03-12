//euclidean algorithm

public class GCD {
    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        System.out.println(gcd(a,b));

    }

    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
}
