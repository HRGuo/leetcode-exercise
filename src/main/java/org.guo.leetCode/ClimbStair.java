package org.guo.leetCode;

import java.math.BigInteger;

public class ClimbStair {
    public int climbStairs(int n) {
        int ways = 0;
        int m = 0;
        while (m * 2 <= n) {
            int tmp = combine(m, m + (n - m * 2));
            System.out.println(String.format("m:%s n:%s  ways:%s", m, m + (n - m * 2), tmp));
            ways += tmp;
            m++;
        }
        return ways;
    }

    public int combine(int m, int n) {
        if (m == 0 || m == n) {
            return 1;
        }
        int motherEnd = 0;
        int sonStart = 0;
        if (m > n - m) {
            motherEnd = n - m;
            sonStart = m + 1;
        } else {
            motherEnd = m;
            sonStart = n-m+1;
        }

        BigInteger mother = BigInteger.ONE;
        for (int i = 1; i<= motherEnd; i++) {
            mother = mother.multiply(BigInteger.valueOf(i));
        }

        BigInteger son = BigInteger.ONE;;
        for (int i = sonStart; i <= n; i++) {
            son = son.multiply(BigInteger.valueOf(i));
        }
        return son.divide(mother).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStair().climbStairs(44));
//        System.out.println(new ClimbStair().combine(14, 30));
    }
}
