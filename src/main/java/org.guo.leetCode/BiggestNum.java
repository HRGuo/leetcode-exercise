package org.guo.leetCode;

public class BiggestNum {

    public static void main(String[] args) {

        BiggestNum bn = new BiggestNum();
        System.out.println(bn.compare(121, 12));

    }

    private int compare(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        int i = 0;
        while (i < Math.min(str1.length(), str2.length())) {
            int number1 = Integer.valueOf(str1.charAt(i));
            int number2 = Integer.valueOf(str2.charAt(i));
            if (number1 == number2) {
                if (i == str1.length() - 1 && i == str2.length()) {
                    return 0;
                } else if (i == str1.length() - 1) {
                    return -cpSelf(str2, i);
                } else if (i == str2.length() - 1) {
                    return cpSelf(str1, i);
                } else {
                    i++;
                    continue;
                }
            } else {
                return number1 - number2;
            }
        }
        return 0;
    }

    private int cpSelf(String num, int i) {
        int base = Integer.valueOf(num.charAt(0));
        while (i+1 < num.length()) {
            int numip1 = Integer.valueOf(num.charAt(i+1));
            if (numip1 != base) {
                return numip1 - base;
            }
            i++;
        }
        return Integer.valueOf(num.charAt(num.length() - 1))
                - Integer.valueOf(num.charAt(num.length() - 2));
    }
}
