package org.guo.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] visited = new int[amount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (cur == amount) {
                return visited[cur];
            }
            for (int coin : coins) {
                int next = cur + coin;
                if (next <= amount) {
                    if (visited[next] != 0) {
                        if (visited[next] > visited[cur] + 1) {
                            visited[next] = visited[cur] + 1;
                        }
                        continue;
                    }
                    queue.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    }
}
