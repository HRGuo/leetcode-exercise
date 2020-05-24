package org.guo.leetCode;

public class RepeatAdd {

        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }
            int temp = 0;
            while (num >= 10) {
                temp += num % 10;
                num /= 10;
            }
            return addDigits(temp);
        }

    public static void main(String[] args) {
        new RepeatAdd().addDigits(38);
    }
}
