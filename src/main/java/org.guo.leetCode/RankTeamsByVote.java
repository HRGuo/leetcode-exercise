package org.guo.leetCode;

import java.util.*;

public class RankTeamsByVote {

        public String rankTeams(String[] votes) {
            if (votes.length == 1) {
                return votes[0];
            }
            Map<Character, Rank> map = new HashMap<>();
            for (int i = 0; i < votes.length; i++) {
                String vote = votes[i];
                for (int j = 0; j < vote.length(); j++) {
                    Character ch = vote.charAt(j);
                    if (map.containsKey(ch)) {
                        map.get(ch).add(j);
                    } else {
                        Rank rank = new Rank(vote.charAt(j), vote.length());
                        rank.add(j);
                        map.put(ch, rank);
                    }
                }
            }
            List<Rank> list = new ArrayList<>();
            list.addAll(map.values());
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (Rank rank : list) {
                sb.append(rank.team);
            }
            return sb.toString();
        }

        class Rank implements Comparable {

            private char team;
            private int[] rank;

            public Rank(char team, int size) {
                this.team = team;
                this.rank = new int[size];
            }

            public void add(int rankLevel) {
                this.rank[rankLevel]++;
            }

            @Override
            public int compareTo(Object o) {
                Rank other = (Rank) o;
                for (int i = 0; i < rank.length; i++) {
                    if (rank[i] == other.rank[i]) {
                        continue;
                    }
                    return other.rank[i] - rank[i];
                }
                return team - other.team;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Rank rank = (Rank) o;
                return team == rank.team;
            }

            @Override
            public int hashCode() {
                return Objects.hash(team);
            }
        }

    public static void main(String[] args) {
            String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(new RankTeamsByVote().rankTeams(votes));
    }
}
