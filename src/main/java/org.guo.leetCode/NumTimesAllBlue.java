package org.guo.leetCode;

public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int blue = 0;
        int[] lights = new int[light.length];
        for (int i = 0; i < light.length; i++) {
            int target = light[i];
            lights[target - 1] = 1;
            if (target == 1) {
                lights[target - 1] = 2;
                blue++;
            }
            if (target - 2 >= 0 && lights[target - 2] >= 1) {
                lights[target - 1] = 2;
                blue++;
            }
            if (target < light.length && lights[target] == 1) {
                lights[target] = 2;
                blue++;
            }

            if (i + 1 == blue) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumTimesAllBlue().numTimesAllBlue(new int[]{2,1,3,5,4}));
    }
}
