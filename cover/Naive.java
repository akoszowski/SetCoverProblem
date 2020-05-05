package cover;

import java.util.ArrayList;
import java.util.Arrays;

// class representing the naive algorithm
// adding set to the solution if one contains not yet covered numbers
public class Naive extends Algorithm {
    private static final Naive INSTANCE = new Naive();

    private Naive(){

    }

    public static Naive getInstance() {
        solution.clear();
        return INSTANCE;
    }


    @Override
    public void findSolution(ArrayList<Set> setsFamily, int instanceBound) {
        if (!checkIfCovers(setsFamily, instanceBound)) {
            solution.add(0);
            return;
        }

        int setId = 1;
        boolean toBeAdded;
        boolean[] covered = new boolean[instanceBound + 1];
        ArrayList<Integer> curNums;

        Arrays.fill(covered, false);

        for (Set s: setsFamily) {
            toBeAdded= false;
            curNums = s.numbersInRange(instanceBound);

            for (Integer n: curNums) {
                if (!covered[n]) {
                    toBeAdded = true;
                    covered[n] = true;
                }
            }

            if (toBeAdded) {
                solution.add(setId);
            }

            setId++;
        }
    }
}
