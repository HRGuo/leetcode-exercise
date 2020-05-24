package org.guo.leetCode;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int pick = (n + 1)/2;
        int res;
        while ((res = guess(pick)) != 0) {
            if (res > 0) {
                right = pick;
            } else {
                left = pick;
            }
            pick = (right + left) / 2;
        }
        return pick;
    }

    private int guess(int pick) {
        int number = 6;
        if (pick > number ) {
            return 1;
        } else if (pick < number ) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower().guessNumber(10));
    }
}
