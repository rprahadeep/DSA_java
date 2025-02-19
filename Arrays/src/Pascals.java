//given N, print the pascals triangle with N rows

import java.util.*;

public class Pascals {
    public static void main(String[] args) {
        int N = 6;
        List<List<Integer>> ans = pascalsTriangle(N);
        for (List<Integer> it : ans) {
            for (int e : it) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    static List<Integer> generateRow(int row) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int n = 1;
        for (int i = 1; i < row; i++) {
            n = n * (row - i);
            n = n / i;
            res.add(n);
        }
        return res;
    }

    static List<List<Integer>> pascalsTriangle(int row) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 1; i <= row; i++) {
            triangle.add(generateRow(i));
        }

        return triangle;
    }
}
