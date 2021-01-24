package challenge.week02_2021_january_8th_january_14th;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3602/
// Boats to Save People

import java.util.Arrays;

public class Q04 {
    public int numRescueBoats(int[] people, int limit) {
        final int LEN = people.length;
        int answer = 0;

        Arrays.sort(people);
        int s = 0, e = 0;
        for (int i = LEN - 1; i > 0; i--) {
            if (people[0] + people[i] <= limit) {
                e = i;
                break;
            }
            answer++;
        }
        while (s <= e) {
            int sp = people[s], ep = people[e];
            if (sp + (s == e ? 0 : ep) <= limit) {
                s++;
            }
            e--;
            answer++;
        }
        return answer;
    }
}
