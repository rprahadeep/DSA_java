//leetcode 202
//this approach uses fast-slow pointer concept

public class HappyNumber {
    public static void main(String[] args){
        int num = 19;
        System.out.println(hnum(num));
    }

    static boolean hnum(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;

    }

    static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans + (rem * rem);
            n = n / 10;
        }
        return ans;
    }
}


