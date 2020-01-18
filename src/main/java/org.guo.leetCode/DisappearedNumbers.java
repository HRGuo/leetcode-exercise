package org.guo.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Boolean> map = new HashMap<>(nums.length);
        for (int i = 1; i < nums.length; i++) {
            map.put(i, false);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i)) {
                map.put(i, true);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
