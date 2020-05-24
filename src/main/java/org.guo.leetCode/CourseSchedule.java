package org.guo.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites.length == 1) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == tmp) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        return cnt == numCourses;
    }

    public static void main(String[] args) {
        new CourseSchedule().canFinish(3, new int[][]{{1, 0}, {2, 0}});
    }
}
