//function to compute nCr

public class NCR {
    public static void main(String[] args){
        System.out.println(combinations(10,3));
    }
    static int combinations(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
