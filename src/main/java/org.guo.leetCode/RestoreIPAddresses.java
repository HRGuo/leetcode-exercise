package org.guo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        ips(res, s, "", 0, 4);
        return res;
    }

    public void ips(List<String> res, String s, String ip, int idx, int left) {
        if (idx >= s.length()) {
            return ;
        }
        if (left == 1) {
            String segment = s.substring(idx);
            if (segment.length() < 4 && Integer.parseInt(segment) < 256 && !(segment.length() > 1 && segment.startsWith("0"))) {
                res.add(ip + segment);
            }
        } else if (left > 1){
            for(int i = 3; i >= 1; i--) {
                if (idx >= s.length() || idx+i >= s.length()) {
                    continue;
                }
                String segment = s.substring(idx, idx+i);
                if (Integer.parseInt(segment) < 256 && !(segment.length() > 1 && segment.startsWith("0"))) {
                    ips(res, s, ip + segment + ".", idx+i, left-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("0279245587303"));
    }
}
