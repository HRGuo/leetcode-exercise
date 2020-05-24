package org.guo.leetCode;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FrogPositionSolution {

        static class Node {
            private int id;
            private double probability;
            private int t;

            public Node(int id, double probability, int t) {
                this.id = id;
                this.probability = probability;
                this.t = t;
            }
        }

        public double frogPosition(int n, int[][] edges, int t, int target) {
            boolean[] visited = new boolean[n + 1];
            Set<Integer>[] sets = new HashSet[n + 1];
            for (int i = 1; i < sets.length; i++) {
                sets[i] = new HashSet<>();
            }
            for (int[] edge : edges) {
                sets[edge[0]].add(edge[1]);
                sets[edge[1]].add(edge[0]);
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 1.0, 0));
            visited[1] = true;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.t == t && node.id == target) {
                    return node.probability;
                }
                if (node.t < t) {
                    int childNum = 0;
                    Set<Integer> set = sets[node.id];
                    for (Integer next : set) {
                        if (!visited[next]) childNum++;
                    }
                    if (childNum == 0) {
                        queue.add(new Node(node.id, node.probability, node.t + 1));
                    } else {
                        for (Integer next : set) {
                            if (!visited[next]) {
                                visited[next] = true;
                                queue.add(new Node(next, node.probability / childNum, node.t + 1));
                            }
                        }
                    }
                }
            }
            return 0.0;
        }

    public static void main(String[] args) {
        System.out.println(new FrogPositionSolution().frogPosition(7,
                new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 2, 4));
    }

}
