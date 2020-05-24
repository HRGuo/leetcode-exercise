package org.guo.leetCode;

import java.util.Arrays;

public class MaximumNumberofEvents {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            int start = a[0] - b[0];
            return start == 0 ? a[1] - b[1] : start;
        });
        int res = 0;
        int idx = 0;
        for (int i = 1; i <= events.length; i++) {
            if (events[idx][0] <=i && i <= events[idx][1]) {
                res++;
                idx++;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberofEvents().maxEvents(new int[][]
                {{1,4},{4,4},{2,2},{3,4},{1,1}}));
    }
}
