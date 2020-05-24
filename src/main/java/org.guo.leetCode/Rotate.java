package org.guo.leetCode;

public class Rotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int prevV = nums[start];
            int next = (start + k) % nums.length;
            do {
                int tmp = nums[next];
                nums[next] = prevV;
                prevV = tmp;
                next = (next + k) % nums.length;
                count++;
            } while(start != next);
        }
    }

    public static void main(String[] args) {
        new Rotate().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

}
