import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] ans = twosum(nums, target);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    static int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> ansmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (ansmap.containsKey(target - nums[i])) {
                return new int[] { ansmap.get(target - nums[i]), i };
            }

            ansmap.put(nums[i], i);
        }

        return new int[] {};
    }
}