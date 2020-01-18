package org.guo.leetCode;

import java.util.HashSet;

public class SingleNum {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.toArray(new Integer[set.size()])[0];
    }

    public static void main(String[] args) {
        System.out.println(new SingleNum().singleNumber(new int[]{2,2,1}));
    }
}
