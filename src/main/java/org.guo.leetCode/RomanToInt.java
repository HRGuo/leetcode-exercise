package org.guo.leetCode;

public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case 'I':
                    if (prev == 'V' || prev == 'X'){
                        res -= 1;
                    } else {
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if (prev == 'L' || prev == 'C') {
                        res -= 10;
                    } else {
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (prev == 'D' || prev == 'M') {
                        res -= 100;
                    } else {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
            prev = ch;
        }
        return res;
    }

    public static void main(String[] args) {
        new RomanToInt().romanToInt("IV");
    }
}
