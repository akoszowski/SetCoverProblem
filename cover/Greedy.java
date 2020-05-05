package cover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// class representing the greedy algorithm
// adding to the solution consecutive sets
// the biggest number of not yet covered numbers
public class Greedy extends Algorithm {
    private static final Greedy INSTANCE = new Greedy();

    private Greedy(){

    }

    public static Greedy getInstance() {
        solution.clear();
        return INSTANCE;
    }

    @Override
    public void findSolution(ArrayList<Set> setsFamily, int instanceBound) {
        if (!checkIfCovers(setsFamily, instanceBound)) {
            solution.add(0);
            return;
        }

        int setsNum = setsFamily.size();
        int toBeCovered = instanceBound;
        boolean[] covered = new boolean[instanceBound + 1];
        boolean[] wasAdded = new boolean[setsNum];

        Arrays.fill(covered,false);
        Arrays.fill(wasAdded, false);

        int max, maxId, curVal;
        Set curSet;

        while (toBeCovered > 0) {
            max = 0;
            maxId = 0;

            for (int i = 0; i < setsNum; ++i) {
                curSet = setsFamily.get(i);

                if (!wasAdded[i]) {
                    curVal = commonNums(covered, curSet);

                    if (curVal > max) {
                        max = curVal;
                        maxId = i;
                    }
                }
            }

            curSet = setsFamily.get(maxId);

            for (Integer n: curSet.numbersInRange(instanceBound)) {
                covered[n] = true;
            }

            wasAdded[maxId] = true;
            solution.add(maxId + 1);

            Collections.sort(solution);

            toBeCovered -= max;
        }

    }

    // returns number of elements in given set not yet covered
    private int commonNums(boolean[] covered, Set s) {
        int counter = 0;
        ArrayList<Integer> curNums = s.numbersInRange(covered.length - 1);

        for (int n: curNums) {
            if (!covered[n]) {
                counter++;
            }
        }

        return counter;
    }
}
