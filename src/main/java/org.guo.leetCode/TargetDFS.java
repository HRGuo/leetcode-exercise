package org.guo.leetCode;

import java.util.*;

public class TargetDFS {

        Set<Path> existsPaths = new HashSet<>();
        Set<Path> resSet = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> candidateList = new ArrayList<>();
            for (int candidate : candidates) {
                candidateList.add(candidate);
            }
            dfs(new Path(), candidateList, target);
            for (Path path : resSet) {
                List<Integer> resList = new ArrayList<>();
                for (Integer index : path.indices) {
                    resList.add(index);
                }
                res.add(resList);
            }
            return res;
        }

        public void dfs(Path prefixPath, List<Integer> candidates, int target) {
            if (existsPaths.contains(prefixPath)) {
                return;
            }
            existsPaths.add(prefixPath.clone());
            if (prefixPath.value == target) {
                resSet.add(prefixPath);
                return;
            } else if (prefixPath.value > target) {
                return;
            } else if (prefixPath.value < target) {
                for (int i = 0; i < candidates.size(); i++) {
                    int tmp = candidates.get(i);
                    List<Integer> newCandidates = (List<Integer>) ((ArrayList<Integer>) candidates).clone();
                    newCandidates.remove(i);
                    dfs(prefixPath.add(tmp), newCandidates, target);
                }
            }
        }
    }


    class Path {
        TreeSet<Integer> indices = new TreeSet();
        Integer value = 0;

        public Path clone() {
            Path clone = new Path();
            TreeSet<Integer> indices = new TreeSet();
            for (Integer index : indices) {
                indices.add(index);
            }
            clone.indices = indices;
            clone.value = this.value;
            return clone;
        }

        public Path add(Integer index) {
            this.indices.add((index));
            this.value += index;
            return this;
        }

        public boolean equals(Path path) {
            if (this == path) {
                return true;
            }
            if (null == path || this.indices.size() != path.indices.size()) {
                return false;
            }
            Iterator thisIterator = this.indices.iterator();
            Iterator otherIterator = path.indices.iterator();
            while (thisIterator.hasNext()) {
                if(thisIterator.next() != otherIterator.next()) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.indices);
        }
    }
