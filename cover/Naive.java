package cover;

import java.util.ArrayList;
import java.util.Arrays;

public class Naive extends Algorithm {

    @Override
    public void findSolution(ArrayList<Set> setsFamily, int instanceBound) {
        if (!checkIfCovers(setsFamily, instanceBound)) {
            solution.add(0);
            return;
        }

        int setId = 1;
        boolean hasNotCovered;
        boolean[] covered = new boolean[instanceBound + 1];
        ArrayList<Integer> curNums;

        Arrays.fill(covered, false);

        for (Set s: setsFamily) {
            hasNotCovered = false;
            curNums = s.numbersInRange(instanceBound);

            for (Integer n: curNums) {
                if (!covered[n]) {
                    hasNotCovered = true;
                    covered[n] = true;
                }
            }

            if (hasNotCovered) {
                solution.add(setId);
            }

            setId++;
        }
    }
}
