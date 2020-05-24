package org.guo.leetCode;

import java.util.Arrays;

public class Asteroids {

    public int[] asteroidCollision(int[] asteroids) {
        int disapper = 0;
        int left = 0;
        int right = 1;
        while(left < right && right < asteroids.length) {
            if (asteroids[left] > 0 && asteroids[right] < 0) {
                if (asteroids[left] + asteroids[right] == 0) {
                    asteroids[left] = 0;
                    asteroids[right] = 0;
                    disapper += 2;
                } else if (asteroids[left] + asteroids[right] < 0) {
                    asteroids[left] = 0;
                    disapper++;
                } else if (asteroids[left] + asteroids[right] > 0) {
                    asteroids[right] = 0;
                    disapper++;
                }
                while(left >= 0 && asteroids[left]==0) {
                    left--;
                }
                if (left == -1) {
                    left = right;
                    while(left < asteroids.length && asteroids[left] == 0){
                        left++;
                    }
                    if (left == asteroids.length) break;
                }
                right = left + 1;
                while(right < asteroids.length && asteroids[right] == 0) {
                    right++;
                }
                if (right == asteroids.length) break;
            } else {
                left++;
                while (left < asteroids.length && asteroids[left] == 0) {
                    left++;
                }
                right = left + 1;
                while (right < asteroids.length && asteroids[right] == 0) {
                    right++;
                }
            }
        }
        int[] res = new int[asteroids.length - disapper];
        int i = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                res[i++] = asteroid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Asteroids().asteroidCollision(new int[]{2, -1, 1, -2})));
    }
}
