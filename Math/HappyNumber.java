// leetcode  202
/* this approach uses the fast-slow concept used in cycle detection of linked-list */

public class HappyNumber {
  public static void main(String[] args) {
    int n = 19;
    System.err.println(hnum(n));
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