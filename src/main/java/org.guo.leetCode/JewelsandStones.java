package org.guo.leetCode;

public class JewelsandStones {

    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            Character ch = J.charAt(i);
            int index = -1;
            while((index = S.indexOf(ch, index+1)) != -1) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new JewelsandStones().numJewelsInStones("aA", "aAAbbbb"));
    }
}
