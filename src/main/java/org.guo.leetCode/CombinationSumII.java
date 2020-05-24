package org.guo.leetCode;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<String> exsits = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<Combination> stack = new Stack<>();
        List<Integer> candidateList = new ArrayList<>(candidates.length);
        for (int candidate : candidates) {
            candidateList.add(candidate);
        }
        Combination root = new Combination();
        root.candidates.addAll(candidateList);
        stack.push(root);
        while(!stack.isEmpty()) {
            Combination comb = stack.pop();
            String hash = comb.hash();
            if (exsits.contains(hash)) {
                continue;
            } else {
                exsits.add(hash);
            }
            if (comb.value == target) {
                res.add(comb.list);
                continue;
            } else if (comb.value > target) {
                continue;
            } else {
                for (int i = 0; i < comb.candidates.size(); i++) {
                    Combination copy = comb.copy();
                    List<Integer> newCandidates = new ArrayList<>();

                    for(int j = 0; j < comb.candidates.size(); j++) {
                        if (j != i) {
                            copy.candidates.add(comb.candidates.get(j));
                        }
                    }
                    stack.push(copy);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}

class Combination {
    List<Integer> list = new ArrayList<>();
    int value = 0;
    List<Integer> candidates = new ArrayList<>();

    public Combination copy() {
        Combination copy = new Combination();
        copy.list.addAll(this.list);
        copy.value = this.value;
        return copy;
    }

    public void add(int i) {
        list.add(i);
        value += i;
    }

    public String hash() {
        Collections.sort(list);
        StringBuilder sb = new StringBuilder("_");
        for (Integer i : list) {
            sb.append(i).append("_");
        }
        return sb.toString();
    }
}

